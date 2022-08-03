package model;

import java.io.Serializable;

public class Antibiotics extends Medicine implements Serializable {

    public Antibiotics() {
    }

    public Antibiotics(int id, String name, double price) {
        super(id, name, price);
    }
}
