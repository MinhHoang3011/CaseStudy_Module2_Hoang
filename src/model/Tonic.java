package model;

import java.io.Serializable;

public class Tonic extends Medicine implements Serializable {
    public Tonic() {
    }

    public Tonic(int id, String name, double price, String unit) {
        super(id, name, price, unit);
    }

    @Override
    public String toString() {
        return "Tonic{}";
    }
}
