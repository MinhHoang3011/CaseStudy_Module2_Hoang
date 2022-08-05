package accounts;

import java.io.Serializable;
import java.util.ArrayList;

public class User implements Serializable {
     private String userName;
     private String userPass;

     private ArrayList<User> userArrayList = new ArrayList<>();

     public User (String userName, String userPass){
         this.userName = userName;
         this.userPass = userPass;
     }
     public User() {
     }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPass() {
        return userPass;
    }

    public void setUserPass(String userPass) {
        this.userPass = userPass;
    }

    public ArrayList<User> getUserArrayList() {
        return userArrayList;
    }

    public void setUserArrayList(ArrayList<User> userArrayList) {
        this.userArrayList = userArrayList;
    }

    @Override
    public String toString() {
        return "User{" +
                "userName='" + userName + '\'' +
                ", userPass='" + userPass + '\'' +
                ", userArrayList=" + userArrayList +
                '}';
    }
}
