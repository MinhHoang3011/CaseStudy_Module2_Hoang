package model;

import java.io.Serializable;

public class Analgesic extends Medicine implements Serializable {
    public Analgesic() {
    }

    public Analgesic(int id, String name, double price, String unit) {
        super(id, name, price,unit);
    }

    @Override
    public String toString() {
        return "Analgesic{" +
                "id=" + getId() +
                ", name='" + getName() + '\'' +
                ", price=" + getPrice() +
                ", unit='" + getUnit() + '\'' +
                '}';
    }
}
