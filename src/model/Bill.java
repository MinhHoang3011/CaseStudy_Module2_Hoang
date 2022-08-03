package model;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;

public class Bill implements Serializable {
    private String userName;
    private ArrayList<Medicine> medicine;
    private double totalPrice;
    private LocalDateTime purchaseDate;


    public Bill(String userName, ArrayList<Medicine> product,double totalPrice, LocalDateTime purchaseDate) {
        this.userName = userName;
        this.medicine = product;
        this.totalPrice = totalPrice;
        this.purchaseDate = purchaseDate;
    }

    public ArrayList<Medicine> getProduct() {
        return medicine;
    }

    public String getUserName() {
        return userName;
    }

    public LocalDateTime getPurchaseDate() {
        return purchaseDate;
    }

    public double getTotalPrice() {
        return totalPrice;
    }


    @Override
    public String toString() {
        return "Bill{" +
                "userName='" + userName + '\'' +
                ", medicine=" + medicine +
                ", totalPrice=" + totalPrice +
                ", purchaseDate=" + purchaseDate +
                '}';
    }
}
