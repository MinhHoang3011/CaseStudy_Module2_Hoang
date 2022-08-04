package controller;

import crawlsData.ListDataMedicin;
import model.Medicine;
import storage.IOFileBinary;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class MedicinProductManager implements MedicinManager<Medicine> {
    private ArrayList<Medicine> medicineArrayList;
    private IOFileBinary<Medicine> medicineIOFileBinary = new IOFileBinary<>();

    public MedicinProductManager(){
        if (!new File("FileDataMedicine").exists()) {
            try {
                new File("FileDataMedicine").createNewFile();
            }catch (IOException e) {
                e.printStackTrace();
            }
        }
        if (new File("FileDataMedicine").length() == 0) {
            medicineArrayList = new ArrayList<>();
        }else {
            medicineArrayList = medicineIOFileBinary.readFileData("FileDataMedicine");
        }
    }
    public void setDataCrawls() {
    }
    public void setMedicineArrayList() {
        ListDataMedicin listDataMedicin = new ListDataMedicin();
        medicineArrayList.addAll(listDataMedicin.setListAnagesic());
        medicineArrayList.addAll(listDataMedicin.setListAntibiotics());
        medicineArrayList.addAll(listDataMedicin.setListTonic());
        medicineArrayList.addAll(listDataMedicin.setListVitamin());
        medicineIOFileBinary.writerFileData(medicineArrayList,"FileDataMedicine");
    }

    public static void main(String[] args) {
        MedicinProductManager medicinProductManager = new MedicinProductManager();
        medicinProductManager.setMedicineArrayList();
    }
    public void getMedicineArrayLists(){
        medicineIOFileBinary.readFileData("FileDataMedicine");
    }
    public ArrayList<Medicine> getMedicineArrayList() {
        return medicineArrayList;
    }
    @Override
    public void display() {
        medicineArrayList = medicineIOFileBinary.readFileData("FileDataMedicine");
        if (medicineArrayList.isEmpty()) {
            System.err.println("\t\t Chưa có sản phẩm nào ");
        }else {
            for (Medicine m:medicineArrayList
                 ) {
                System.out.println(m);

            }
        }
    }

    @Override
    public void delete(int id) {
        medicineArrayList.removeIf(p -> p.getId() == id);
        medicineIOFileBinary.writerFileData(medicineArrayList,"FileDataMedicine");
    }

    @Override
    public void deleteAll() {
        medicineArrayList.clear();
        medicineIOFileBinary.writerFileData(medicineArrayList,"FileDataMedicine");
    }

    @Override
    public void add(Medicine medicine) {
        medicineArrayList.add(medicine);
        medicineIOFileBinary.writerFileData(medicineArrayList,"FileDataMedicine");
    }

    @Override
    public void editName(int id, String editName) {
        for (Medicine m: medicineArrayList
             ) {if (m.getId() == id) {
                 m.setName(editName);
        }
        }
        medicineIOFileBinary.writerFileData(medicineArrayList,"FileDataMedicine");
    }

    @Override
    public void editPrice(int id, double price) {
        for (Medicine m:medicineArrayList
             ) {if (m.getId() == id){
                 m.setPrice(price);
        }
        }
        medicineIOFileBinary.writerFileData(medicineArrayList,"FileDataMedidcine");
    }
}
