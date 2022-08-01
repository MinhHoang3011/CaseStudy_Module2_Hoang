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
        return "Analgesic{}";
    }
}
