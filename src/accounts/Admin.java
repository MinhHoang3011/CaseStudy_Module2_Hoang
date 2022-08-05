package accounts;

import java.io.Serializable;
import java.util.ArrayList;

public class Admin implements Serializable {
    private String adminName;
    private String adminPass;
    private final ArrayList<Admin> adminArrayList = new ArrayList<Admin>();

    public Admin(String adminName, String adminPass) {
        this.adminName = adminName;
        this.adminPass = adminPass;
    }
    public Admin() {
        adminArrayList.add(new Admin("ADMIN","123456"));
    }
    public ArrayList<Admin> getAdminArrayList() {
        return adminArrayList;
    }

    public String getAdminName() {
        return adminName;
    }

    public void setAdminName(String adminName) {
        this.adminName = adminName;
    }

    public String getAdminPass() {
        return adminPass;
    }

    public void setAdminPass(String adminPass) {
        this.adminPass = adminPass;
    }

    @Override
    public String toString() {
        return "Admin{" +
                "adminName='" + adminName + '\'' +
                ", adminPass='" + adminPass + '\'' +
                ", adminArrayList=" + adminArrayList +
                '}';
    }
}
