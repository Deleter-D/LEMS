package edu.whpu.pojo;


import java.util.Date;

public class Device {
    private int d_ID;
    private String d_name;
    private float d_price;
    private int d_number;
    private Date d_dateForP;
    private String d_manufacturer;
    private String d_shelfLife;
    private int d_adminID;
    private int d_facultyID;
    private int d_isBorrowed;
    private User admin;
    private Faculty faculty;

    public Device() {
    }

    public Device(String d_name, float d_price, int d_number, Date d_dateForP, String d_manufacturer, String d_shelfLife, int d_adminID, int d_facultyID, int d_isBorrowed) {
        this.d_name = d_name;
        this.d_price = d_price;
        this.d_number = d_number;
        this.d_dateForP = d_dateForP;
        this.d_manufacturer = d_manufacturer;
        this.d_shelfLife = d_shelfLife;
        this.d_adminID = d_adminID;
        this.d_facultyID = d_facultyID;
        this.d_isBorrowed = d_isBorrowed;
    }

    public int getD_ID() {
        return d_ID;
    }

    public void setD_ID(int d_ID) {
        this.d_ID = d_ID;
    }

    public String getD_name() {
        return d_name;
    }

    public void setD_name(String d_name) {
        this.d_name = d_name;
    }

    public float getD_price() {
        return d_price;
    }

    public void setD_price(float d_price) {
        this.d_price = d_price;
    }

    public int getD_number() {
        return d_number;
    }

    public void setD_number(int d_number) {
        this.d_number = d_number;
    }

    public Date getD_dateForP() {
        return d_dateForP;
    }

    public void setD_dateForP(Date d_dateForP) {
        this.d_dateForP = d_dateForP;
    }

    public String getD_manufacturer() {
        return d_manufacturer;
    }

    public void setD_manufacturer(String d_manufacturer) {
        this.d_manufacturer = d_manufacturer;
    }

    public String getD_shelfLife() {
        return d_shelfLife;
    }

    public void setD_shelfLife(String d_shelfLife) {
        this.d_shelfLife = d_shelfLife;
    }

    public int getD_adminID() {
        return d_adminID;
    }

    public void setD_adminID(int d_adminID) {
        this.d_adminID = d_adminID;
    }

    public int getD_facultyID() {
        return d_facultyID;
    }

    public void setD_facultyID(int d_facultyID) {
        this.d_facultyID = d_facultyID;
    }

    public int getD_isBorrowed() {
        return d_isBorrowed;
    }

    public void setD_isBorrowed(int d_isBorrowed) {
        this.d_isBorrowed = d_isBorrowed;
    }

    public Faculty getFaculty() {
        return faculty;
    }

    public void setFaculty(Faculty faculty) {
        this.faculty = faculty;
    }

    public User getAdmin() {
        return admin;
    }

    public void setAdmin(User admin) {
        this.admin = admin;
    }

    @Override
    public String toString() {
        return "Device{" +
                "d_ID=" + d_ID +
                ", d_name='" + d_name + '\'' +
                ", d_price=" + d_price +
                ", d_number=" + d_number +
                ", d_dateForP=" + d_dateForP +
                ", d_manufacturer='" + d_manufacturer + '\'' +
                ", d_shelfLife='" + d_shelfLife + '\'' +
                ", d_adminID=" + d_adminID +
                ", d_facultyID=" + d_facultyID +
                ", d_isBorrowed=" + d_isBorrowed +
                ", admin=" + admin +
                ", faculty=" + faculty +
                '}';
    }
}
