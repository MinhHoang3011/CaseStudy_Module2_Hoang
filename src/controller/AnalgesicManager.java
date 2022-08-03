package controller;

import model.Analgesic;
import model.Medicine;
import storage.IOFileBinary;

import java.io.File;
import java.util.ArrayList;

public class AnalgesicManager implements MedicinManager<Analgesic>{

    private ArrayList<Analgesic> listAnalgesic;
    private IOFileBinary<Analgesic> ioFileBinaryAnalgesic = new IOFileBinary<>();

    public AnalgesicManager() {
        if (new File("FileDataCase").length() == 0) {
            listAnalgesic = new ArrayList<>();
        }else {
            listAnalgesic = ioFileBinaryAnalgesic.readFileData("FileDataCase");
        }
    }
    public ArrayList<Analgesic> getListAnalgesic() {
        return listAnalgesic;
    }

    @Override
    public void display() {
        listAnalgesic = ioFileBinaryAnalgesic.readFileData("FileDataCase");
        if (listAnalgesic.isEmpty()){
            System.err.println("\t\tChưa có sản phẩm nào");
        }else {
            listAnalgesic.forEach(Analgesic::display);
        }
    }

    @Override
    public void delete(int id) {
        listAnalgesic.removeIf(p -> p.getId() == id);
        ioFileBinaryAnalgesic.writerFileData(listAnalgesic, "FileDataCase");
    }

    @Override
    public void deleteAll() {
        listAnalgesic.clear();
    }

    @Override
    public void add(Analgesic analgesic) {
        listAnalgesic.add(analgesic);
        ioFileBinaryAnalgesic.writerFileData(listAnalgesic,"FileDataCase");
    }

    @Override
    public void editName(int id, String editName) {
        for (Medicine m: listAnalgesic) {
            if (m.getId() == id){
                m.setName(editName);
            }
        }
        ioFileBinaryAnalgesic.writerFileData(listAnalgesic,"FileDataCase");
    }

    @Override
    public void editPrice(int id, double price) {
        for (Medicine m: listAnalgesic
             ) {
            if (m.getId() == id) {
                m.setPrice(price);
            }
        }
        ioFileBinaryAnalgesic.writerFileData(listAnalgesic,"FileDataCase");
    }

}



