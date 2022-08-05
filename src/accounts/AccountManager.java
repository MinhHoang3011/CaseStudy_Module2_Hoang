package accounts;

import storage.IOFileBinary;

import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Scanner;

public class AccountManager implements Serializable {
    CreateUser createUser = new CreateUser();
    private ArrayList<User> userArrayList;
    private IOFileBinary<User> userIOFileBinary = new IOFileBinary<>();

    public AccountManager() {
        try {
            if (!new File("FileDataUserAcc").exists()){
                new File("FileDataUserAcc").createNewFile();
            }
            if (new File("FileDataUserAcc").length() == 0){
                this.userArrayList = new ArrayList<>();
            }else {
                this.userArrayList = userIOFileBinary.readFileData("FileDataUserAcc");

            }
        }catch (IOException e) {
            e.getMessage();
        }
    }
public ArrayList<User> getUserArrayList(){
        return userArrayList;
}
public void addAccount(User user){
        try {
            if (!new File("FileDataUserAcc").exists()){
                new File("FileDataUserAcc").createNewFile();
            }
            if (new File("FileDataUserAcc").length() == 0){
                this.userArrayList = new ArrayList<>();
            }else {
                this.userArrayList = userIOFileBinary.readFileData("FileDataUserAcc");
            }
            userArrayList.add(user);
            userIOFileBinary.writerFileData(userArrayList,"FileDataUserAcc");
        }catch (IOException e) {
            System.err.println("Không thể thêm tài khoản !!!");
        }
}
public void displayUserAccount() {
        userArrayList = userIOFileBinary.readFileData("FileDataUserAcc");
        if (userArrayList.isEmpty()){
            System.out.println(" Chưa có tài khoản nào đăng ký !!!");
            System.out.println("^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^");
        }
        else {
            System.err.println("Tài khoản khách hàng");
            System.err.println("^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^");
        for (User u: userArrayList){
            System.out.println(u);
        }
        }
}
//public deleteAccount(){
//        userArrayList = userIOFileBinary.readFileData("FileDataUserAcc");
//        Scanner input = new Scanner(System.in);
//    System.out.println("Nhập tài khoản muốn xóa :");
//    S
}

