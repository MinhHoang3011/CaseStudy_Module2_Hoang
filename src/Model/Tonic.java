package Model;

import java.io.Serializable;

public class Tonic extends Medicine implements Serializable {
    public Tonic() {
    }

    public Tonic(int id, String name, double price, String brand, String dateOfManufacture, String expiry) {
        super(id, name, price, brand, dateOfManufacture, expiry);
    }

    @Override
    public String toString() {
        return "Tonic{}";
    }
}
