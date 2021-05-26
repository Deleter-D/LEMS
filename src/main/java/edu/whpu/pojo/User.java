package edu.whpu.pojo;

public class User {
    private int u_ID;
    private String u_account;
    private String u_password;
    private String u_name;
    private String u_tele;
    private int u_facultyID;
    private String u_identity;
    private Faculty faculty;

    public User() {
    }

    public User(String u_account, String u_password, String u_name, String u_tele, int u_facultyID, String u_identity) {
        this.u_account = u_account;
        this.u_password = u_password;
        this.u_name = u_name;
        this.u_tele = u_tele;
        this.u_facultyID = u_facultyID;
        this.u_identity = u_identity;
    }

    public int getU_ID() {
        return u_ID;
    }

    public void setU_ID(int u_ID) {
        this.u_ID = u_ID;
    }

    public String getU_account() {
        return u_account;
    }

    public void setU_account(String u_account) {
        this.u_account = u_account;
    }

    public String getU_password() {
        return u_password;
    }

    public void setU_password(String u_password) {
        this.u_password = u_password;
    }

    public String getU_name() {
        return u_name;
    }

    public void setU_name(String u_name) {
        this.u_name = u_name;
    }

    public String getU_tele() {
        return u_tele;
    }

    public void setU_tele(String u_tele) {
        this.u_tele = u_tele;
    }

    public int getU_facultyID() {
        return u_facultyID;
    }

    public void setU_facultyID(int u_facultyID) {
        this.u_facultyID = u_facultyID;
    }

    public String getU_identity() {
        return u_identity;
    }

    public void setU_identity(String u_identity) {
        this.u_identity = u_identity;
    }

    public Faculty getFaculty() {
        return faculty;
    }

    public void setFaculty(Faculty faculty) {
        this.faculty = faculty;
    }

    @Override
    public String toString() {
        return "User{" +
                "u_ID=" + u_ID +
                ", u_account='" + u_account + '\'' +
                ", u_password='" + u_password + '\'' +
                ", u_name='" + u_name + '\'' +
                ", u_tele='" + u_tele + '\'' +
                ", u_facultyID=" + u_facultyID +
                ", u_identity='" + u_identity + '\'' +
                ", faculty=" + faculty +
                '}';
    }
}
