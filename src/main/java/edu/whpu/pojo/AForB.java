package edu.whpu.pojo;

import java.util.Date;

public class AForB {
    private int afb_ID;
    private String afb_name;
    private int afb_number;
    private Date afb_bDate;
    private Date afb_rDate;
    private String afb_usefor;
    private String afb_bName;
    private String afb_bTele;
    private int afb_facultyID;
    private int afb_isPermited;

    public AForB() {
    }

    public AForB(String afb_name, int afb_number, Date afb_bDate, Date afb_rDate, String afb_usefor, String afb_bName, String afb_bTele, int afb_facultyID, int afb_isPermited) {
        this.afb_name = afb_name;
        this.afb_number = afb_number;
        this.afb_bDate = afb_bDate;
        this.afb_rDate = afb_rDate;
        this.afb_usefor = afb_usefor;
        this.afb_bName = afb_bName;
        this.afb_bTele = afb_bTele;
        this.afb_facultyID = afb_facultyID;
        this.afb_isPermited = afb_isPermited;
    }

    public int getAfb_ID() {
        return afb_ID;
    }

    public void setAfb_ID(int afb_ID) {
        this.afb_ID = afb_ID;
    }

    public String getAfb_name() {
        return afb_name;
    }

    public void setAfb_name(String afb_name) {
        this.afb_name = afb_name;
    }

    public int getAfb_number() {
        return afb_number;
    }

    public void setAfb_number(int afb_number) {
        this.afb_number = afb_number;
    }

    public Date getAfb_bDate() {
        return afb_bDate;
    }

    public void setAfb_bDate(Date afb_bDate) {
        this.afb_bDate = afb_bDate;
    }

    public Date getAfb_rDate() {
        return afb_rDate;
    }

    public void setAfb_rDate(Date afb_rDate) {
        this.afb_rDate = afb_rDate;
    }

    public String getAfb_usefor() {
        return afb_usefor;
    }

    public void setAfb_usefor(String afb_usefor) {
        this.afb_usefor = afb_usefor;
    }

    public String getAfb_bName() {
        return afb_bName;
    }

    public void setAfb_bName(String afb_bName) {
        this.afb_bName = afb_bName;
    }

    public String getAfb_bTele() {
        return afb_bTele;
    }

    public void setAfb_bTele(String afb_bTele) {
        this.afb_bTele = afb_bTele;
    }

    public int getAfb_facultyID() {
        return afb_facultyID;
    }

    public void setAfb_facultyID(int afb_facultyID) {
        this.afb_facultyID = afb_facultyID;
    }

    public int getAfb_isPermited() {
        return afb_isPermited;
    }

    public void setAfb_isPermited(int afb_isPermited) {
        this.afb_isPermited = afb_isPermited;
    }

    @Override
    public String toString() {
        return "AForB{" +
                "afb_ID=" + afb_ID +
                ", afb_name='" + afb_name + '\'' +
                ", afb_number=" + afb_number +
                ", afb_bDate=" + afb_bDate +
                ", afb_rDate=" + afb_rDate +
                ", afb_usefor='" + afb_usefor + '\'' +
                ", afb_bName='" + afb_bName + '\'' +
                ", afb_bTele='" + afb_bTele + '\'' +
                ", afb_facultyID=" + afb_facultyID +
                ", afb_isPermited=" + afb_isPermited +
                '}';
    }
}
