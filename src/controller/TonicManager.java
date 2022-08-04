package controller;

import model.Medicine;
import model.Tonic;
import storage.IOFileBinary;

import java.io.File;
import java.util.ArrayList;

public class TonicManager implements MedicinManager<Tonic> {
    private ArrayList<Tonic> listTonic;
    private IOFileBinary<Tonic> tonicIOFileBinary = new IOFileBinary<>();

    public TonicManager() {
        if (new File("FileDataTonic").length() == 0 ){
            listTonic = new ArrayList<>();
        }else {
            listTonic = tonicIOFileBinary.readFileData("FileDataTonic");
        }
    }

    public ArrayList<Tonic> getListTonic() {
        return listTonic;
    }

    @Override
    public void display() {
        listTonic = tonicIOFileBinary.readFileData("FileDataTonic");
        if (listTonic.isEmpty()) {
            System.err.println("\t\tChưa có sản phẩm nào");
        }else {
            for (Tonic t:listTonic
                 ) {
                System.out.println(t);

            }
        }
    }

    @Override
    public void delete(int id) {
        listTonic.removeIf(p ->p.getId()== id );
        tonicIOFileBinary.writerFileData(listTonic,"FileDataTonic");
    }

    @Override
    public void deleteAll() {
        listTonic.clear();
        tonicIOFileBinary.writerFileData(listTonic,"FileDataTonic");
    }

    @Override
    public void add(Tonic tonic) {
        listTonic.add(tonic);
        tonicIOFileBinary.writerFileData(listTonic,"FileDataTonic");
    }

    @Override
    public void editName(int id, String editName) {
        for (Medicine m: listTonic
        ) { if (m.getId() == id) {
            m.setName(editName);
        }
        }
        tonicIOFileBinary.writerFileData(listTonic,"FileDataTonic");
    }

    @Override
    public void editPrice(int id, double price) {
        for (Medicine m: listTonic
        ) { if (m.getId()== id) {
            m.setPrice(price);
        }
        }
        tonicIOFileBinary.writerFileData(listTonic,"FileDataTonic");
    }
}
