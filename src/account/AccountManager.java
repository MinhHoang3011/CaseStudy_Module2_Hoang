package account;

import validate.ValidateAll;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class AccountManager {
    public static final String PLEASE_SIGN_UP = "Mời bạn đăng ký >>>";
    public static final String USER_FILE_PATH = "src\\data_file\\user.csv";
    public static final String EMAIL_REGEX = "^[a-zA-Z0-9_!#$%&’*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+$";
    public static final String PASSWORD_REGEX = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#&()–[{}]:;',?/*~$^+=<>]).{8,20}$";
    public static final String NOT_VALID_EMAIL_MESSAGE = "Nhập Email chưa đúng định dạng!!!\nYêu cầu nhập lại theo dạng (username@main.com) >>> ";
    public static final String NOT_VALID_PASS_MESSAGE = "Nhập Password chưa đúng định dạng!!!";
    public static final int FIRST_CHOICE = 1;
    public static final int SECOND_CHOICE = 2;
    public static final int THIRD_CHOICE = 3;

    private List<Acccount> accounts = new ArrayList<>();

}