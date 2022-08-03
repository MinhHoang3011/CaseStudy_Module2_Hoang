package model;

import java.io.Serializable;

public class Tonic extends Medicine implements Serializable {
    public Tonic() {
    }

    public Tonic(int id, String name, double price) {
        super(id, name, price);
    }

    @Override
    public String toString() {
        return "Tonic{}";
    }
}
