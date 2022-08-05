package accounts;

import java.util.ArrayList;

public class CreateUser {
    private String nameUser;
    private String emailUser;
    private String phoneNumberUser;

    private ArrayList<CreateUser> createUserArrayList = new ArrayList<>();

    public CreateUser(String nameUser, String emailUser, String phoneNumberUser) {
        this.nameUser = nameUser;
        this.emailUser = emailUser;
        this.phoneNumberUser = phoneNumberUser;
    }

    public CreateUser() {
    }

    public String getNameUser() {
        return nameUser;
    }

    public void setNameUser(String nameUser) {
        this.nameUser = nameUser;
    }

    public String getEmailUser() {
        return emailUser;
    }

    public void setEmailUser(String emailUser) {
        this.emailUser = emailUser;
    }

    public String getPhoneNumberUser() {
        return phoneNumberUser;
    }

    public void setPhoneNumberUser(String phoneNumberUser) {
        this.phoneNumberUser = phoneNumberUser;
    }

    @Override
    public String toString() {
        return "CreateUser{" +
                "nameUser='" + nameUser + '\'' +
                ", emailUser='" + emailUser + '\'' +
                ", phoneNumberUser='" + phoneNumberUser + '\'' +
                '}';
    }
}
