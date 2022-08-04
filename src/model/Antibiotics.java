package model;

import java.io.Serializable;

public class Antibiotics extends Medicine implements Serializable {

    public Antibiotics() {
    }

    public Antibiotics(int id, String name, double price, String unit) {
        super(id, name, price, unit);
    }

    @Override
    public String toString() {
        return "Antibiotic{" +
                "id=" + getId() +
                ", name='" + getName() + '\'' +
                ", price=" + getPrice() +
                ", unit='" + getUnit() + '\'' +
                '}';
    }
}
