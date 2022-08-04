package controller;

public interface MedicinManager<E> {
    void display();
    void delete (int id);
    void deleteAll ();
    void add(E e);

    void editName (int id, String editName);
    void editPrice(int id, double price);

//    void editUnit (int id, String editUnit);
}
