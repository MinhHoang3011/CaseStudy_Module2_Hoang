package controller;

import model.*;

import java.util.ArrayList;
import java.util.Scanner;

public class MedicinFacade {
    private MedicinProductManager medicinProductManager;
    private AnalgesicManager analgesicManager;
    private AntibioticsManager antibioticsManager;
    private TonicManager tonicManager;
    private VitaminManager vitaminManager;

    private static MedicinFacade instance;
    private final Scanner scanner = new Scanner(System.in);
    private MedicinFacade() {
        medicinProductManager = new MedicinProductManager();
        analgesicManager = new AnalgesicManager();
        antibioticsManager = new AntibioticsManager();
        tonicManager = new TonicManager();
        vitaminManager = new VitaminManager();
    }
    public synchronized static MedicinFacade getInstance() {
        if (instance == null){
            instance =new MedicinFacade();
        }
        return instance;
    }
    public void add(int id, String name, double price, String unit, int choiceAdd) {
        switch (choiceAdd){
            case 1:
                Analgesic analgesic = new Analgesic(id, name, price, unit);
                analgesicManager.add(analgesic);
                medicinProductManager.add(analgesic);
                break;
            case 2:
                Antibiotics antibiotics = new Antibiotics(id, name, price, unit);
                antibioticsManager.add(antibiotics);
                medicinProductManager.add(antibiotics);
                break;
            case 3:
                Vitamin vitamin = new Vitamin(id, name, price, unit);
                vitaminManager.add(vitamin);
                medicinProductManager.add(vitamin);
                break;
            case 4:
                Tonic tonic = new Tonic(id, name, price, unit);
                tonicManager.add(tonic);
                medicinProductManager.add(tonic);
                break;
        }
    }
    public void displayChoice(int choice) {
        switch (choice) {
            case 1:
                medicinProductManager.display();
                break;
            case 2:
                analgesicManager.display();
                break;
            case 3:
                antibioticsManager.display();
                break;
            case 4:
                vitaminManager.display();
                break;
            case 5:
                tonicManager.display();
                break;
            case 0:
                System.out.println("TR??? L???I");
                break;
            default:
                System.out.println("Nh???p sai l???a ch???n");
                break;
        }
    }
    public void delete(int id){
        medicinProductManager.delete(id);
        analgesicManager.delete(id);
        antibioticsManager.delete(id);
        vitaminManager.delete(id);
        tonicManager.delete(id);
    }
    public void deleteAll(){
        medicinProductManager.deleteAll();
        analgesicManager.deleteAll();
        antibioticsManager.deleteAll();
        vitaminManager.deleteAll();
        tonicManager.deleteAll();
    }
    public void edit(int id, int choiceAdd){
        switch (choiceAdd){
            case 1:
                System.out.println("Nh???p t??n m???i ");
                String name = scanner.nextLine();
                medicinProductManager.editName(id, name);
                analgesicManager.editName(id,name);
                antibioticsManager.editName(id,name);
                vitaminManager.editName(id,name);
                tonicManager.editName(id,name);
                break;
            case 2:
                System.out.println("Nh???p gi?? m???i");
                double price = Double.parseDouble(scanner.nextLine());
                medicinProductManager.editPrice(id,price);
                analgesicManager.editPrice(id, price);
                antibioticsManager.editPrice(id,price);
                vitaminManager.editPrice(id,price);
                tonicManager.editPrice(id,price);
                break;
        }
    }
    public boolean checkID(int id) {
        for (Medicine m: medicinProductManager.getMedicineArrayList()
             ) {if (m.getId() == id){
                 return true;
        }
        }
        return false;
    }
    public void backUpData() {
        medicinProductManager.setMedicineArrayList();
        System.err.println("Kh??i ph???c d??? li???u th??nh c??ng");
        System.out.println("--------------------------------------------------------------------------");

    }
    public Medicine findMedicineById(int id) {
        Medicine medicine = null;
        for (Medicine m: medicinProductManager.getMedicineArrayList()
             ) {if (m.getId()==id){
                 medicine = m;
                 break;
        }
        }
        if (medicine !=null) {
            System.out.println(medicine);
        }else {
            System.out.println("Kh??ng t??m th???y thu???c c???n t??m");
        }
        return medicine;
    }
    public void search(int choiceAdd) {

        switch (choiceAdd) {
            case 1:
                System.out.println("Nh???p t??n thu???c c???n t??m : ");
                String name = scanner.nextLine();
                ArrayList<Medicine> medicineArrayList = medicinProductManager.medicinesSearchByName(name);
                if (medicineArrayList.isEmpty()){
                    System.out.println("Kh??ng c?? t??n thu???c n??o c???n t??m !!!");
                }else {
                    for (Medicine m:medicineArrayList
                         ) {
                        System.out.println(m);
                    }
                    break;
                }
            case 2:
                System.out.println("Nh???p ID thu???c c???n t??m !!!");
                int id = Integer.parseInt(scanner.nextLine());
               findMedicineById(id);

        }
    }
}

