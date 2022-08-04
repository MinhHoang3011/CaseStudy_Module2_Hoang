package controller;

import model.Antibiotics;
import model.Medicine;
import storage.IOFileBinary;

import java.io.File;
import java.util.ArrayList;

public class AntibioticsManager implements MedicinManager<Antibiotics> {
    private ArrayList<Antibiotics> antibioticsArrayList;
    private IOFileBinary<Antibiotics> antibioticsIOFileBinary = new IOFileBinary<>();

    public AntibioticsManager(){
        if (new File("FileDataAntibiotics").length()==0) {
            antibioticsArrayList = new ArrayList<>();
        }else {
            antibioticsArrayList = antibioticsIOFileBinary.readFileData("FileDataAntibiotics");
        }
    }
    public ArrayList<Antibiotics> getAntibioticsArrayList(){
        return antibioticsArrayList;
    }

    @Override
    public void display() {
        antibioticsArrayList = antibioticsIOFileBinary.readFileData("FileDataAntibiotics");
        if (antibioticsArrayList.isEmpty()){
            System.out.println("\t\t Chưa có sản phẩm nào ");
        }else {
            antibioticsArrayList.forEach(System.out::println);
        }
    }

    @Override
    public void delete(int id) {
        antibioticsArrayList.removeIf(p -> p.getId() == id);
        antibioticsIOFileBinary.writerFileData(antibioticsArrayList,"FileDataAntibiotics");
    }

    @Override
    public void deleteAll() {
        antibioticsArrayList.clear();
        antibioticsIOFileBinary.writerFileData(antibioticsArrayList,"FileDataAntibiotics");
    }

    @Override
    public void add(Antibiotics antibiotics) {
        antibioticsArrayList.add(antibiotics);
        antibioticsIOFileBinary.writerFileData(antibioticsArrayList,"FileDataAntibiotics");
    }

    @Override
    public void editName(int id, String editName) {
        for (Medicine m: antibioticsArrayList
             ) {if (m.getId() ==  id) {
                 m.setName(editName);
        }
        }
        antibioticsIOFileBinary.writerFileData(antibioticsArrayList,"FileDataAntibiotics");
    }

    @Override
    public void editPrice(int id, double price) {
        for (Medicine m:antibioticsArrayList
             ) {if (m.getId() == id){
                 m.setPrice(price);
        }
        }
        antibioticsIOFileBinary.writerFileData(antibioticsArrayList,"FileDataAntibiotics");
    }
}
