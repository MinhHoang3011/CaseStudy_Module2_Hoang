package Model;

import java.io.Serializable;

public class Vitamin extends Medicine implements Serializable {

    public Vitamin(int id, String name, double price, String brand, String dateOfManufacture, String expiry) {
        super(id, name, price, brand, dateOfManufacture, expiry);
    }

    public Vitamin() {
    }

    @Override
    public String toString() {
        return "Vitamin{}";
    }
}
