package Controller;

import Model.Antibiotics;
import Model.Medicine;
import Storage.IOFileBinary;

import java.io.File;
import java.util.ArrayList;

public class AntibioticsManager implements MedicinManager<Antibiotics> {
    private ArrayList<Antibiotics> listAntibiotics;
    private IOFileBinary<Antibiotics> antibioticsIOFileBinary = new IOFileBinary<>();

    public AntibioticsManager() {
        if (new File("FileDataCase1").length() == 0 ){
            listAntibiotics = new ArrayList<>();
        }else {
            listAntibiotics = antibioticsIOFileBinary.readFileData("FileDataCase1");
        }
    }

    public ArrayList<Antibiotics> getListAntibiotics() {
        return listAntibiotics;
    }

    @Override
    public void display() {
        listAntibiotics = antibioticsIOFileBinary.readFileData("FileDataCase1");
        if (listAntibiotics.isEmpty()) {
            System.err.println("\t\tChưa có sản phẩm nào");
        }else {
            listAntibiotics.forEach(System.out::println);
        }
    }

    @Override
    public void delete(int id) {
        listAntibiotics.removeIf(p ->p.getId()== id );
        antibioticsIOFileBinary.writerFileData(listAntibiotics,"FileDataCase1");
    }

    @Override
    public void deleteAll() {
        listAntibiotics.clear();
        antibioticsIOFileBinary.writerFileData(listAntibiotics,"FileDataCase1");
    }

    @Override
    public void add(Antibiotics antibiotics) {
        listAntibiotics.add(antibiotics);
        antibioticsIOFileBinary.writerFileData(listAntibiotics,"FileDataCase1");
    }

    @Override
    public void editName(int id, String editName) {
        for (Medicine m: listAntibiotics
             ) { if (m.getId() == id) {
                 m.setName(editName);
        }
        }
        antibioticsIOFileBinary.writerFileData(listAntibiotics,"FileDataCase1");
    }

    @Override
    public void editPrice(int id, double price) {
        for (Medicine m: listAntibiotics
             ) { if (m.getId()== id) {
                 m.setPrice(price);
        }
        }
        antibioticsIOFileBinary.writerFileData(listAntibiotics,"FileDataCase1");
    }

    @Override
    public void editBrand(int id, String brand) {
        for (Medicine m: listAntibiotics
             ) { if (m.getId() == id) {
                 m.setBrand(brand);
        }
        }
        antibioticsIOFileBinary.writerFileData(listAntibiotics,"FileDataCase1");
    }
}
