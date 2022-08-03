package model;

import java.io.Serializable;

public class Vitamin extends Medicine implements Serializable {

    public Vitamin(int id, String name, double price) {
        super(id, name, price);
    }

    public Vitamin() {
    }

    @Override
    public String toString() {
        return "Vitamin{}";
    }
}
