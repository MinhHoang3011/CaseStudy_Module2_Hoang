package Model;

import java.io.Serializable;

public class Medicine implements Serializable {
    private int id;
    private String name;
    private double price;
    private String brand;
    private String dateOfManufacture;
    private String expiry;

    public Medicine(int id, String name, double price, String brand, String dateOfManufacture, String expiry) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.brand = brand;
        this.dateOfManufacture = dateOfManufacture;
        this.expiry = expiry;
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

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getDateOfManufacture() {
        return dateOfManufacture;
    }

    public void setDateOfManufacture(String dateOfManufacture) {
        this.dateOfManufacture = dateOfManufacture;
    }

    public String getExpiry() {
        return expiry;
    }

    public void setExpiry(String expiry) {
        this.expiry = expiry;
    }

    @Override
    public String toString() {
        return "Medicine{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", brand='" + brand + '\'' +
                ", dateOfManufacture='" + dateOfManufacture + '\'' +
                ", expiry='" + expiry + '\'' +
                '}';
    }
}
