package systems;

import controller.MedicinFacade;
import login.Login;
import model.Medicine;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class RunByUser {
//    public static void main(String[] arg) {
//        RunByUser runByUser = new RunByUser();
//        runByUser.menuOfUser();
//    }
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
                System.out.println("║>[5]. Hiển thị sản phẩm trong giỏ hàng                      ║");
                System.out.println("║>[6]. Tổng tiền thuốc                                       ║");
                System.out.println("║>[0]. Đăng xuất                                             ║");
                System.out.println("╚============================================================╝");
                System.out.println("Mời bạn nhập lựa chọn");
                int choice = Integer.parseInt(scanner.nextLine());
                switch (choice) {
                    case 1:
                        runbyAdmin.display();
                        break;
                    case 2:
                        runbyAdmin.seach();
                        break;
                    case 3:
                        runbyAdmin.display();
                        addMedicinetoCart();
                        break;
                    case 4:
                        displayCart();
                        removeMedicineToCart();
                    case 5:
                        displayCart();
                        break;
                    case 6:
                        System.out.println("Tổng tiền thuốc trong giỏ hàng : "+totalPrice());
                    case 0:
                        System.out.println("Đã đăng xuất !!!");
                        System.out.println("^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^");
                        new Login().loginSystem();
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
    public void seach() {
        try {
            System.out.println("╔============================================╗");
            System.out.println("║   ▂ ▃ ▅ ▆ █ TÌM KIẾM SẢN PHẨM  █ ▆ ▅ ▃ ▂   ║");
            System.out.println("╠============================================╣");
            System.out.println("║>[1]. Theo tên thuốc                        ║");
            System.out.println("║>[2]. Theo ID                               ║");
            System.out.println("║>[0]. Thoát                                 ║");
            System.out.println("╚============================================╝");
            System.out.print(" Mời bạn nhập vào lựa chọn: ");
            int choiceAdd = Integer.parseInt(scanner.nextLine());
            medicinFacade.search(choiceAdd);
        } catch (InputMismatchException e) {
            System.out.println("Bạn đã nhập sai dữ liệu,Vui lòng nhập lại");
            seach();
        }
    }
    public double totalPrice() {
        double totalPrice = 0;
        for (Medicine x : listCart) {
            totalPrice += x.getPrice();
        }
        return totalPrice;
    }
}

