package Controller;

import Model.Medicine;
import Model.Vitamin;
import Storage.IOFileBinary;

import java.io.File;
import java.util.ArrayList;

public class VitaminManager implements MedicinManager<Vitamin>{
    private ArrayList<Vitamin> listVitamin;
    private IOFileBinary<Vitamin> vitaminIOFileBinary = new IOFileBinary<>();

    public VitaminManager() {
        if (new File("FileDataVitamin").length() == 0 ) {
            listVitamin = new ArrayList<>();
        }else {
            listVitamin = vitaminIOFileBinary.readFileData("FileDataVitamin");
        }
    }

    public ArrayList<Vitamin> getListVitamin(){
        return listVitamin;
    }
    @Override
    public void display() {
        listVitamin =vitaminIOFileBinary.readFileData("FileDataVitamin");
        if (listVitamin.isEmpty()) {
            System.err.println("\t\t Chưa có sản phẩm nào ");
        }else {
            listVitamin.forEach(System.out::println);
        }
    }

    @Override
    public void delete(int id) {
        listVitamin.removeIf(p -> p.getId() == id);
        vitaminIOFileBinary.writerFileData(listVitamin,"FileDataVitamin");
    }

    @Override
    public void deleteAll() {
        listVitamin.clear();
        vitaminIOFileBinary.writerFileData(listVitamin, "FileDataVitamin");
    }

    @Override
    public void add(Vitamin vitamin) {
        listVitamin.add(vitamin);
        vitaminIOFileBinary.writerFileData(listVitamin,"FileDataVitamin");
    }


    @Override
    public void editName(int id, String editName) {
        for (Medicine m:listVitamin
             ) {if (m.getId() == id) {
                 m.setName(editName);
        }
        }
        vitaminIOFileBinary.writerFileData(listVitamin,"FileDataVitamin");
    }

    @Override
    public void editPrice(int id, double price) {
        for (Medicine m:listVitamin
             ) { if (m.getId() == id) {
                 m.setPrice(price);
        }
        }
        vitaminIOFileBinary.writerFileData(listVitamin,"FileDataVitamin");
    }

    @Override
    public void editBrand(int id, String brand) {
        for (Medicine m:listVitamin
             ) {if (m.getId() == id) {
                 m.setBrand(brand);
        }
        }
        vitaminIOFileBinary.writerFileData(listVitamin,"FileDataVitamin");
    }
}