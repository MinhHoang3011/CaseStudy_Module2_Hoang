package model;

import java.io.Serializable;

public class Vitamin extends Medicine implements Serializable {

    public Vitamin() {
    }

    public Vitamin(int id, String name, double price, String unit) {
        super(id, name, price, unit);
    }

    @Override
    public String toString() {
        return "Vitamin{}";
    }
}
