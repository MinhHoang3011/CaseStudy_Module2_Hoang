package systems;

import controller.MedicinFacade;
import model.Medicine;

import java.util.ArrayList;
import java.util.Scanner;

public class RunByUser {
    private final Scanner scanner = new Scanner(System.in);
    private final MedicinFacade medicinFacade = MedicinFacade.getInstance();

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
                System.out.println("║>[6]. Thanh toán                                            ║");
                System.out.println("║>[7]. Lịch sử mua hàng
            }
        }
    }
}
