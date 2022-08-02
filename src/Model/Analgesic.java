package Model;

import java.io.Serializable;

public class Analgesic extends Medicine implements Serializable {
    public Analgesic() {
    }

    public Analgesic(int id, String name, double price, String brand, String dateOfManufacture, String expiry) {
        super(id, name, price, brand, dateOfManufacture, expiry);
    }
    @Override
    public String toString() {
        return String.format("║ %-8s ║ %-10.0f ║ %-14s ║ %-105s ║",getId(),getName(),getPrice(),getBrand(),getDateOfManufacture(),getExpiry());
    }
    public void display() {
        System.out.println("╔====================================================================================================================================================╗");
        System.out.printf("║ %-8s ║ %-10.0f ║ %-14s ║ %-105s ║\n║        %-31s ║ Chi tiết: %-95s ║\n",getId(),getName(),getPrice(),getBrand(),getDateOfManufacture(),getExpiry());
        System.out.println("╚====================================================================================================================================================╝");
    }
}
