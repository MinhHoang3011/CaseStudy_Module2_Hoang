package systems;

import controller.MedicinFacade;
import login.Login;
import model.Medicine;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class RunByUser {
    private final Scanner scanner = new Scanner(System.in);
    private final MedicinFacade medicinFacade = MedicinFacade.getInstance();
    private final RunbyAdmin runbyAdmin = new RunbyAdmin();
    private ArrayList <Medicine> listCart = new ArrayList<>();
    public RunByUser() {

    }
    public void menuOfUser() {
        try {
            do {
                System.out.println("╔============================================================╗");
                System.out.println("╔============================================================╗");
                System.out.println("║              ▂ ▃ ▅ ▆ █ HỆ THỐNG USER █ ▆ ▅ ▃ ▂             ║");
                System.out.println("╠============================================================╣");
                System.out.println("║>[1]. Hiển thị sản phẩm Thuốc                               ║");
                System.out.println("║>[2]. Tìm kiếm sản phẩm Thuốc                               ║");
                System.out.println("║>[3]. Thêm sản phẩm vào giỏ hàng                            ║");
                System.out.println("║>[4]. Xóa sản phẩm khỏi giỏ hàng                            ║");
                System.out.println("║>[5]. Đăng xuất                                             ║");
                System.out.println("╚============================================================╝");
                System.out.println("Mời bạn nhập lựa chọn");
                int choice = Integer.parseInt(scanner.nextLine());
                switch (choice) {
                    case 1:
                        runbyAdmin.display();
                        break;
                    case 2:
                        medicinFacade.search();
                        break;
                    case 3:
                        runbyAdmin.display();
                        addMedicinetoCart();
                        break;
                    case 4:
                        displayCart();
                        removeMedicineToCart();
                    case 0:
                        System.out.println("Đã đăng xuất !!!");
                        System.out.println("^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^");
                        break;
                    default:
                        System.out.println("Bạn đã nhập sai,Vui lòng nhập lại !!!");
                break;}

            }while (true);

        }catch (Exception e){
            System.out.println("Bạn đã nhập sai, Vui lòng nhập lại !!!");
            menuOfUser();
        }
    }
    public void addMedicinetoCart() {
        try {
            System.out.println("Nhập ID cây muốn thêm vào giỏ hàng");
            int id = Integer.parseInt(scanner.nextLine());
            Medicine medicine = medicinFacade.findMedicineById(id);
            if (medicine == null) {
                System.out.println("Nhập sai mã thuốc !!! ");
            }else {
                listCart.add(medicine);
                System.out.println("Đã thêm thuốc vào giỏ hàng thành công!!!");
            }
        }catch (InputMismatchException e) {
            System.out.println("Bạn đã nhập sai dữ liệu! Vui lòng nhập lại!");
            System.out.println("^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^");
            addMedicinetoCart();
        }
    }
    public void displayCart() {
        if ((listCart.isEmpty())) {
            System.out.println("Chưa có thuốc trong giỏ hàng !!!");
        }else {
            for (Medicine m : listCart){
                System.out.println(m);
            }
        }
    }
    public void removeMedicineToCart() {
        try {
            if (listCart.isEmpty()) {
                System.out.println("Chưa có thuốc trong giỏ hàng !!!");
            }else {
                System.out.println("Nhập ID thuốc muốn xóa : ");
                int idRemove = Integer.parseInt(scanner.nextLine());
                boolean check = listCart.removeIf(p -> p.getId() == idRemove);
                if (!check) {
                    System.out.println("Không tìm thấy thuốc !!!");
                }else {
                    System.out.println("Đã xóa thuốc khỏi giỏ hàng thành công");
                }
            }
        }catch (InputMismatchException e) {
            System.out.println("Bạn đã nhập sai dữ liệu! Vui lòng nhập lại!");
            System.out.println("^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^");
            addMedicinetoCart();
        }
    }
    public double getTotalPrice() {
        double totalPrice = 0;
        for (Medicine m : listCart) {
            totalPrice += m.getPrice();
        }
        return totalPrice;
    }
}
