package systems;

import controller.MedicinFacade;
import login.Login;
import model.Medicine;
import storage.IOFileBinary;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class RunbyAdmin {
    public static void main(String[] arg) {
        RunbyAdmin runbyAdmin = new RunbyAdmin();
        runbyAdmin.menuOfAdmin();
    }

    private final Scanner scanner = new Scanner(System.in);
    private MedicinFacade medicinFacade = MedicinFacade.getInstance();
    private ArrayList<Medicine> listOfAdmin = new ArrayList<>();
    public RunbyAdmin() {

    }

    public void menuOfAdmin() {
        try {
            do {
                System.out.println("╔============================================================╗");
                System.out.println("║              ▂ ▃ ▅ ▆ █ HỆ THỐNG QUẢN LÝ THUỐC █ ▆ ▅ ▃ ▂    ║");
                System.out.println("╠============================================================╣");
                System.out.println("║>[1]. Thêm sản phẩm thuốc                                   ║");
                System.out.println("║>[2]. Sửa thông tin thuốc                                   ║");
                System.out.println("║>[3]. Xóa sản phẩm thuốc                                    ║");
                System.out.println("║>[4]. Hiển thị sản phẩm thuốc                               ║");
                System.out.println("║>[5]. Khôi phục dữ liệu                                     ║");
                System.out.println("║>[6]. Tìm kiếm thuốc                                        ║");
                System.out.println("║>[7]. Tổng giá tiền thuốc                                   ║");
                System.out.println("║>[0]. Đăng xuất                                             ║");
                System.out.println("╚============================================================╝");
                System.out.println(" Mời nhập lựa chọn !!! >>");
                int choice = Integer.parseInt(scanner.nextLine());
                switch (choice) {
                    case 1:
                        menuAddMedicine();
                        break;
                    case 2:
                        try {
                            System.out.println("Nhập ID thuốc cần sửa !!!");
                            int id = Integer.parseInt(scanner.nextLine());
                            if (medicinFacade.checkID(id)){
                                editMedicine(id);
                                System.out.println("Thông tin thuốc đã được cập nhật !!!");
                            }else {
                                System.out.println("Không tìm thấy thông tin thuốc !!!");
                                System.out.println("^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^");
                            }
                        }catch (InputMismatchException e) {
                            System.out.println("Sai kiểu dữ liệu !!!");
                            System.out.println("^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^");
                        }
                        break;
                    case 3:
                        deleteMedicine();
                        break;
                    case 4:
                        display();
                        break;
                    case 5:
                        System.out.println("Dữ liệu đã được khôi phục !!!");
                        medicinFacade.backUpData();
                        break;
                    case 6:
                        seach();
                        break;
                    case 7:
                        System.out.println("Tổng số tiền là :" + getTotalPrice());
                        break;
                    case 0:
                        System.out.println("Đã đăng xuất !!!");
                        System.out.println("^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^");
                        new Login().loginSystem();
                        break;
                    default:
                        System.out.println("ERROR");
                        break;
                }
            }while (true);
        }catch (Exception e) {
            System.out.println("Nhập sai dữ liệu !!! Mời nhập lại ");
            System.out.println("^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^");
            menuOfAdmin();
        }
    }
    public void menuAddMedicine() {
        try {
            do {
                System.out.println("╔===========================================╗");
                System.out.println("║     ▂ ▃ ▅ ▆ █ THÊM THUỐC  █ ▆ ▅ ▃ ▂       ║");
                System.out.println("╠===========================================╣");
                System.out.println("║>[1]. Analgesic                            ║");
                System.out.println("║>[2]. Antibiotics                          ║");
                System.out.println("║>[3]. Tonic                                ║");
                System.out.println("║>[4]  Vitamin                              ║");
                System.out.println("║>[0]. Thoát                                ║");
                System.out.println("╚===========================================╝");
                System.out.println("Mời nhập lựa chọn !!! ");
                int choiceAdd = Integer.parseInt(scanner.nextLine());
                if (choiceAdd == 0) {
                    break;
                } else if (choiceAdd < 0 || choiceAdd > 3) {
                    System.out.println("Sai lựa chọn, Mời nhập lại !!!");
                    menuAddMedicine();
                }
                System.out.println("Nhập ID Thuốc : ");
                int id = Integer.parseInt(scanner.nextLine());
                System.out.println("Nhập tên Thuốc : ");
                String name = scanner.nextLine();
                System.out.println("Nhập giá sản phẩm : ");
                double price = Double.parseDouble(scanner.nextLine());
                System.out.println("Nhập đơn vị sản phẩm : ");
                String unit = scanner.nextLine();
                if (!medicinFacade.checkID(id)){
                    medicinFacade.add(id, name, price, unit, choiceAdd);
                    System.out.println("Thêm Thuốc thành công !!!");
                }else {
                    System.out.println("Thêm sản phẩm không thành công");
                    System.out.println("^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^");
                }
                break;
            }while (true);
        }catch (InputMismatchException e) {
            System.out.println("Nhập sai dữ liệu,vui lòng nhập lại !!!");
            System.out.println("^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^");
            menuAddMedicine();
        }

    }
    public void editMedicine(int id) {
        try {
            System.out.println("╔===========================================╗");
            System.out.println("║     ▂ ▃ ▅ ▆ █   SỬA THUỐC   █ ▆ ▅ ▃ ▂     ║");
            System.out.println("╠===========================================╣");
            System.out.println("║>[1]. Sửa tên                              ║");
            System.out.println("║>[2]. Sửa giá                              ║");
            System.out.println("║>[3]. Sửa đơn vị                           ║");
            System.out.println("║>[0]. Thoát                                ║");
            System.out.println("╚===========================================╝");
            display();
            System.out.println("Mời nhập lựa chọn : ");
            int choiceAdd = Integer.parseInt(scanner.nextLine());
            medicinFacade.edit(id, choiceAdd);
        }catch (InputMismatchException e){
            System.out.println("Nhập sai dữ liệu,vui lòng nhập lại !!!");
            System.out.println("^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^");
            editMedicine(id);
        }
    }
    public void deleteMedicine() {
        try {
            System.out.println("╔===========================================╗");
            System.out.println("║       ▂ ▃ ▅ ▆ █ XOÁ THUỐC  █ ▆ ▅ ▃ ▂      ║");
            System.out.println("╠===========================================╣");
            System.out.println("║>[1]. Xóa Thuốc theo ID                    ║");
            System.out.println("║>[2]. Xóa tất cả Thuốc                     ║");
            System.out.println("║>[0]. Thoát                                ║");
            System.out.println("╚===========================================╝");
            System.out.println("Mời nhập lựa chọn : ");
            int choiceAdd = Integer.parseInt(scanner.nextLine());
            switch (choiceAdd) {
                case 1:
                    System.out.println("Mời nhập mã ID : ");
                    int id = Integer.parseInt(scanner.nextLine());
                    if (medicinFacade.checkID(id)){
                        medicinFacade.delete(id);
                        System.out.println("Xóa Thuốc thành công !!!!");
                        System.out.println("^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^");
                    }else {
                        System.out.println("ID Thuốc cần xóa không đúng !!!!");
                        System.out.println("^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^");
                    }
                    break;
                case 2:
                    System.out.println("Xóa tất cả dữ liệu Thuốc !!!");
                    String choice = scanner.nextLine();
                    if (choice.equalsIgnoreCase("Y")){
                        medicinFacade.deleteAll();
                        System.out.println("Đã xóa hết dữ liệu Thuốc !!!");
                        System.out.printf("^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^");
                    }else {
                        break;
                    }
                case 0:
                    System.out.println("Thoát");
                    break;
                default:
                    System.out.println("ERROR");
                    break;
            }
        }catch (InputMismatchException e) {
            System.out.println("Nhập sai dữ liệu,Vui lòng nhập lại !!!");
            System.out.println("^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^");
            deleteMedicine();
        }
    }
    public void display(){
        try {
            System.out.println("╔===========================================╗");
            System.out.println("║    ▂ ▃ ▅ ▆ █ HIỂN THỊ THUỐC  █ ▆ ▅ ▃ ▂    ║");
            System.out.println("╠===========================================╣");
            System.out.println("║>[1]. Tất cả thuốc                         ║");
            System.out.println("║>[2]. Analgesic                            ║");
            System.out.println("║>[3]. Antibiotics                          ║");
            System.out.println("║>[4]. Tonic                                ║");
            System.out.println("║>[5]. Vitamin                              ║");
            System.out.println("║>[0]. Thoát                                ║");
            System.out.println("╚===========================================╝");
            System.out.println("moi nhap vao lua chon");
            int choiceAdd = Integer.parseInt(scanner.nextLine());
            medicinFacade.displayChoice(choiceAdd);
        }catch (InputMismatchException e) {
            System.out.println("Nhập sai dữ liệu,Vui lòng nhập lại !!!");
            System.out.println("^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^");
            display();
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
    }catch (InputMismatchException e){
            System.out.println("Bạn đã nhập sai dữ liệu,Vui lòng nhập lại");
            seach();
        }
}
    public double getTotalPrice() {
        IOFileBinary ioFileBinary = new IOFileBinary();
        List<Medicine> temp = (List<Medicine>) ioFileBinary.readFileData("FileDataMedicine");
        double totalPrice = 0;
        for (Medicine m : temp) {
            totalPrice += m.getPrice();
        }
        return totalPrice;
    }
}
