package controller;

import model.Analgesic;
import model.Medicine;
import storage.IOFileBinary;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class AnalgesicManager implements MedicinManager<Analgesic>{

    private ArrayList<Analgesic> listAnalgesic;
    private IOFileBinary<Analgesic> ioFileBinaryAnalgesic = new IOFileBinary<>();

    public AnalgesicManager(){
        if (new File("FileDataAnalgesic").length() == 0) {
            listAnalgesic = new ArrayList<>();
        }else {
            listAnalgesic = ioFileBinaryAnalgesic.readFileData("FileDataAnalgesic");
        }
    }
    public ArrayList<Analgesic> getListAnalgesic() {
        return listAnalgesic;
    }

    @Override
    public void display() {
        listAnalgesic = ioFileBinaryAnalgesic.readFileData("FileDataAnalgesic");
        if (listAnalgesic.isEmpty()){
            System.err.println("\t\tChưa có sản phẩm nào");
        }else {
            for (Analgesic a: listAnalgesic
                 ) {
                System.out.println(a);

            }
        }
    }

    @Override
    public void delete(int id) {
        listAnalgesic.removeIf(p -> p.getId() == id);
        ioFileBinaryAnalgesic.writerFileData(listAnalgesic, "FileDataAnalgesic");
    }

    @Override
    public void deleteAll() {
        listAnalgesic.clear();
    }

    @Override
    public void add(Analgesic analgesic) {
        listAnalgesic.add(analgesic);
        ioFileBinaryAnalgesic.writerFileData(listAnalgesic,"FileDataAnalgesic");
    }

    @Override
    public void editName(int id, String editName) {
        for (Medicine m: listAnalgesic) {
            if (m.getId() == id){
                m.setName(editName);
            }
        }
        ioFileBinaryAnalgesic.writerFileData(listAnalgesic,"FileDataAnalgesic");
    }

    @Override
    public void editPrice(int id, double price) {
        for (Medicine m: listAnalgesic
             ) {
            if (m.getId() == id) {
                m.setPrice(price);
            }
        }
        ioFileBinaryAnalgesic.writerFileData(listAnalgesic,"FileDataAnalgesic");
    }
//    public static void main(String[] args) {
//        AnalgesicManager analgesicManager = new AnalgesicManager();
//        analgesicManager.display();
//    }
}




