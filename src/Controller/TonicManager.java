package Controller;

import Model.Medicine;
import Model.Tonic;
import Storage.IOFileBinary;

import java.io.File;
import java.util.ArrayList;

public class TonicManager implements MedicinManager<Tonic> {
    private ArrayList<Tonic> listTonic;
    private IOFileBinary<Tonic> tonicIOFileBinary = new IOFileBinary<>();

    public TonicManager() {
        if (new File("FileDataCase2").length() == 0 ){
            listTonic = new ArrayList<>();
        }else {
            listTonic = tonicIOFileBinary.readFileData("FileDataCase2");
        }
    }

    public ArrayList<Tonic> getListTonic() {
        return listTonic;
    }

    @Override
    public void display() {
        listTonic = tonicIOFileBinary.readFileData("FileDataCase2");
        if (listTonic.isEmpty()) {
            System.err.println("\t\tChưa có sản phẩm nào");
        }else {
            listTonic.forEach(System.out::println);
        }
    }

    @Override
    public void delete(int id) {
        listTonic.removeIf(p ->p.getId()== id );
        tonicIOFileBinary.writerFileData(listTonic,"FileDataCase2");
    }

    @Override
    public void deleteAll() {
        listTonic.clear();
        tonicIOFileBinary.writerFileData(listTonic,"FileDataCase2");
    }

    @Override
    public void add(Tonic tonic) {
        listTonic.add(tonic);
        tonicIOFileBinary.writerFileData(listTonic,"FileDataCase2");
    }

    @Override
    public void editName(int id, String editName) {
        for (Medicine m: listTonic
        ) { if (m.getId() == id) {
            m.setName(editName);
        }
        }
        tonicIOFileBinary.writerFileData(listTonic,"FileDataCase2");
    }

    @Override
    public void editPrice(int id, double price) {
        for (Medicine m: listTonic
        ) { if (m.getId()== id) {
            m.setPrice(price);
        }
        }
        tonicIOFileBinary.writerFileData(listTonic,"FileDataCase1");
    }

    @Override
    public void editBrand(int id, String brand) {
        for (Medicine m: listTonic
        ) { if (m.getId() == id) {
            m.setBrand(brand);
        }
        }
        tonicIOFileBinary.writerFileData(listTonic,"FileDataCase1");
    }
}
