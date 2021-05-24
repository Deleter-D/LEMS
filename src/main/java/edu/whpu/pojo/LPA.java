package edu.whpu.pojo;

import java.util.Date;

public class LPA {
    private int lpa_ID;
    private String lpa_name;
    private float lpa_price;
    private int lpa_number;
    private Date lpa_dateForP;
    private String lpa_manufacturer;
    private String lpa_shelfLife;
    private int lpa_adminID;

    public LPA() {
    }

    public LPA(String lpa_name, float lpa_price, int lpa_number, Date lpa_dateForP, String lpa_manufacturer, String lpa_shelfLife, int lpa_adminID) {
        this.lpa_name = lpa_name;
        this.lpa_price = lpa_price;
        this.lpa_number = lpa_number;
        this.lpa_dateForP = lpa_dateForP;
        this.lpa_manufacturer = lpa_manufacturer;
        this.lpa_shelfLife = lpa_shelfLife;
        this.lpa_adminID = lpa_adminID;
    }

    public int getLpa_ID() {
        return lpa_ID;
    }

    public void setLpa_ID(int lpa_ID) {
        this.lpa_ID = lpa_ID;
    }

    public String getLpa_name() {
        return lpa_name;
    }

    public void setLpa_name(String lpa_name) {
        this.lpa_name = lpa_name;
    }

    public float getLpa_price() {
        return lpa_price;
    }

    public void setLpa_price(float lpa_price) {
        this.lpa_price = lpa_price;
    }

    public int getLpa_number() {
        return lpa_number;
    }

    public void setLpa_number(int lpa_number) {
        this.lpa_number = lpa_number;
    }

    public Date getLpa_dateForP() {
        return lpa_dateForP;
    }

    public void setLpa_dateForP(Date lpa_dateForP) {
        this.lpa_dateForP = lpa_dateForP;
    }

    public String getLpa_manufacturer() {
        return lpa_manufacturer;
    }

    public void setLpa_manufacturer(String lpa_manufacturer) {
        this.lpa_manufacturer = lpa_manufacturer;
    }

    public String getLpa_shelfLife() {
        return lpa_shelfLife;
    }

    public void setLpa_shelfLife(String lpa_shelfLife) {
        this.lpa_shelfLife = lpa_shelfLife;
    }

    public int getLpa_adminID() {
        return lpa_adminID;
    }

    public void setLpa_adminID(int lpa_adminID) {
        this.lpa_adminID = lpa_adminID;
    }

    @Override
    public String toString() {
        return "LPA{" +
                "lpa_ID=" + lpa_ID +
                ", lpa_name='" + lpa_name + '\'' +
                ", lpa_price=" + lpa_price +
                ", lpa_number=" + lpa_number +
                ", lpa_dateForP=" + lpa_dateForP +
                ", lpa_manufacturer='" + lpa_manufacturer + '\'' +
                ", lpa_shelfLife='" + lpa_shelfLife + '\'' +
                ", lpa_adminID=" + lpa_adminID +
                '}';
    }
}
