package edu.whpu.pojo;

import java.util.Date;

public class AForP {
    private int afp_ID;
    private String afp_name;
    private float afp_price;
    private int afp_number;
    private Date afp_dateForP;
    private String afp_manufacturer;
    private String afp_shelfLife;
    private int afp_adminID;
    private int afp_facultyID;
    private int afp_isPermited;

    public AForP() {
    }

    public AForP(String afp_name, float afp_price, int afp_number, Date afp_dateForP, String afp_manufacturer, String afp_shelfLife, int afp_adminID, int afp_facultyID, int afp_isPermited) {
        this.afp_name = afp_name;
        this.afp_price = afp_price;
        this.afp_number = afp_number;
        this.afp_dateForP = afp_dateForP;
        this.afp_manufacturer = afp_manufacturer;
        this.afp_shelfLife = afp_shelfLife;
        this.afp_adminID = afp_adminID;
        this.afp_facultyID = afp_facultyID;
        this.afp_isPermited = afp_isPermited;
    }

    public int getAfp_ID() {
        return afp_ID;
    }

    public void setAfp_ID(int afp_ID) {
        this.afp_ID = afp_ID;
    }

    public String getAfp_name() {
        return afp_name;
    }

    public void setAfp_name(String afp_name) {
        this.afp_name = afp_name;
    }

    public float getAfp_price() {
        return afp_price;
    }

    public void setAfp_price(float afp_price) {
        this.afp_price = afp_price;
    }

    public int getAfp_number() {
        return afp_number;
    }

    public void setAfp_number(int afp_number) {
        this.afp_number = afp_number;
    }

    public Date getAfp_dateForP() {
        return afp_dateForP;
    }

    public void setAfp_dateForP(Date afp_dateForP) {
        this.afp_dateForP = afp_dateForP;
    }

    public String getAfp_manufacturer() {
        return afp_manufacturer;
    }

    public void setAfp_manufacturer(String afp_manufacturer) {
        this.afp_manufacturer = afp_manufacturer;
    }

    public String getAfp_shelfLife() {
        return afp_shelfLife;
    }

    public void setAfp_shelfLife(String afp_shelfLife) {
        this.afp_shelfLife = afp_shelfLife;
    }

    public int getAfp_adminID() {
        return afp_adminID;
    }

    public void setAfp_adminID(int afp_adminID) {
        this.afp_adminID = afp_adminID;
    }

    public int getAfp_facultyID() {
        return afp_facultyID;
    }

    public void setAfp_facultyID(int afp_facultyID) {
        this.afp_facultyID = afp_facultyID;
    }

    public int getAfp_isPermited() {
        return afp_isPermited;
    }

    public void setAfp_isPermited(int afp_isPermited) {
        this.afp_isPermited = afp_isPermited;
    }

    @Override
    public String toString() {
        return "AForP{" +
                "afp_ID=" + afp_ID +
                ", afp_name='" + afp_name + '\'' +
                ", afp_price=" + afp_price +
                ", afp_number=" + afp_number +
                ", afp_dateForP=" + afp_dateForP +
                ", afp_manufacturer='" + afp_manufacturer + '\'' +
                ", afp_shelfLife='" + afp_shelfLife + '\'' +
                ", afp_adminID=" + afp_adminID +
                ", afp_facultyID=" + afp_facultyID +
                ", afp_isPermited=" + afp_isPermited +
                '}';
    }
}
