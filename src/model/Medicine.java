package model;

import java.io.Serializable;

public abstract class Medicine implements Serializable {
    private int id;
    private String name;
    private double price;

    public Medicine(int id, String name, double price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    public Medicine() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }


    @Override
    public String toString() {
        return String.format("║ %-8s ║ %-10.0f ║ %-14s ║ %-105s ║",id ,name ,price);
    }
}
