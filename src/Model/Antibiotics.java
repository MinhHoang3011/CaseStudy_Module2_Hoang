package Model;

import java.io.Serializable;

public class Antibiotics extends Medicine implements Serializable {

    public Antibiotics() {
    }

    public Antibiotics(int id, String name, double price, String brand, String dateOfManufacture, String expiry) {
        super(id, name, price, brand, dateOfManufacture, expiry);
    }

    @Override
    public String toString() {
        return "Antibiotics{}";
    }
}
