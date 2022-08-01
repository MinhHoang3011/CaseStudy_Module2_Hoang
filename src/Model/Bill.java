package Model;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
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

    public void display(){
        System.out.println("╔====================================================================================================================================================╗");
        System.out.println("\t Username:" + userName);
        System.out.printf("║    %-5s ║    %-7s ║      %-9s ║                                    %-70s ║\n", "ID","Giá","Hãng","Tên sản phẩm");
        medicine.forEach(System.out::println);
        System.out.println("  Total Price " + totalPrice + '\t' + "  Purchase Date: " + purchaseDate.format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss")));
        System.out.println("╚====================================================================================================================================================╝");
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
