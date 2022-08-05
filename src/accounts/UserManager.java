package accounts;

import storage.IOFileBinary;

import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;

public class UserManager implements Serializable {
    private ArrayList<CreateUser> createUserArrayList;
    private IOFileBinary<CreateUser> createUserIOFileBinary = new IOFileBinary<>();
    public UserManager(){
        if (!new File("FileDataAccount").exists()){
            try {
                new File("FileDataAccount").createNewFile();
            }catch (IOException e) {
                e.getMessage();
            }
        }
        if (new File("FileDataAccount").length()==0){
            createUserArrayList = new ArrayList<>();
        }else {
            createUserArrayList= createUserIOFileBinary.readFileData("FileDataAccount");
        }
    }
    public ArrayList<CreateUser> getCreateUserArrayList() {
        createUserArrayList =  createUserIOFileBinary.readFileData("FileDataAccount");
        return createUserArrayList;
    }
    public void addCreateUser(CreateUser createUser){
        if (!new File("FileDataAccount").exists()){
            try {
                new File("FileDataAccount").createNewFile();
            }catch (IOException e){
                e.getMessage();
            }
        }
        if (new File("FileDataAccount").length() == 0) {
            createUserArrayList = new ArrayList<>();
        }else {
            createUserArrayList = createUserIOFileBinary.readFileData("FileDataAccount");
        }
        createUserArrayList.add(createUser);
        createUserIOFileBinary.writerFileData(createUserArrayList, "FileDataAccount");
    }

    public void displayUser() {
        createUserArrayList = createUserIOFileBinary.readFileData("FileDataAccount");
        if (createUserArrayList.isEmpty()) {
            System.out.println("Chưa có thông tin người dùng nào đăng kí!!");
            System.out.println("-------------------------------------------");
        }else {
            System.out.println("    nameUser  -  phonenumberUser  -  emailUser");
            createUserArrayList.forEach(System.out::println);
            System.out.println("^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^");
        }
    }
}
