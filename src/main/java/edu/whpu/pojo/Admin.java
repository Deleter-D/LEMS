package edu.whpu.pojo;

public class Admin {
    private int a_ID;
    private String a_account;
    private String a_password;
    private String a_name;
    private String a_tele;
    private int a_facultyID;

    public Admin() {
    }

    public Admin(String a_account, String a_password, String a_name, String a_tele, int a_facultyID) {
        this.a_account = a_account;
        this.a_password = a_password;
        this.a_name = a_name;
        this.a_tele = a_tele;
        this.a_facultyID = a_facultyID;
    }

    public int getA_ID() {
        return a_ID;
    }

    public void setA_ID(int a_ID) {
        this.a_ID = a_ID;
    }

    public String getA_account() {
        return a_account;
    }

    public void setA_account(String a_account) {
        this.a_account = a_account;
    }

    public String getA_password() {
        return a_password;
    }

    public void setA_password(String a_password) {
        this.a_password = a_password;
    }

    public String getA_name() {
        return a_name;
    }

    public void setA_name(String a_name) {
        this.a_name = a_name;
    }

    public String getA_tele() {
        return a_tele;
    }

    public void setA_tele(String a_tele) {
        this.a_tele = a_tele;
    }

    public int getA_facultyID() {
        return a_facultyID;
    }

    public void setA_facultyID(int a_facultyID) {
        this.a_facultyID = a_facultyID;
    }

    @Override
    public String toString() {
        return "Admin{" +
                "a_ID=" + a_ID +
                ", a_account='" + a_account + '\'' +
                ", a_password='" + a_password + '\'' +
                ", a_name='" + a_name + '\'' +
                ", a_tele='" + a_tele + '\'' +
                ", a_facultyID=" + a_facultyID +
                '}';
    }
}
