package edu.whpu.pojo;

import java.util.Date;

public class AForLPA {
    private int aflpa_ID;
    private String aflpa_name;
    private int aflpa_number;
    private Date aflpa_bDate;
    private String aflpa_useFor;
    private String aflpa_bName;
    private String aflpa_bTele;
    private int aflpa_facultyID;
    private int aflpa_isPermited;

    public AForLPA() {
    }

    public AForLPA(String aflpa_name, int aflpa_number, Date aflpa_bDate, String aflpa_useFor, String aflpa_bName, String aflpa_bTele, int aflpa_facultyID, int aflpa_isPermited) {
        this.aflpa_name = aflpa_name;
        this.aflpa_number = aflpa_number;
        this.aflpa_bDate = aflpa_bDate;
        this.aflpa_useFor = aflpa_useFor;
        this.aflpa_bName = aflpa_bName;
        this.aflpa_bTele = aflpa_bTele;
        this.aflpa_facultyID = aflpa_facultyID;
        this.aflpa_isPermited = aflpa_isPermited;
    }

    public int getAflpa_ID() {
        return aflpa_ID;
    }

    public void setAflpa_ID(int aflpa_ID) {
        this.aflpa_ID = aflpa_ID;
    }

    public String getAflpa_name() {
        return aflpa_name;
    }

    public void setAflpa_name(String aflpa_name) {
        this.aflpa_name = aflpa_name;
    }

    public int getAflpa_number() {
        return aflpa_number;
    }

    public void setAflpa_number(int aflpa_number) {
        this.aflpa_number = aflpa_number;
    }

    public Date getAflpa_bDate() {
        return aflpa_bDate;
    }

    public void setAflpa_bDate(Date aflpa_bDate) {
        this.aflpa_bDate = aflpa_bDate;
    }

    public String getAflpa_useFor() {
        return aflpa_useFor;
    }

    public void setAflpa_useFor(String aflpa_useFor) {
        this.aflpa_useFor = aflpa_useFor;
    }

    public String getAflpa_bName() {
        return aflpa_bName;
    }

    public void setAflpa_bName(String aflpa_bName) {
        this.aflpa_bName = aflpa_bName;
    }

    public String getAflpa_bTele() {
        return aflpa_bTele;
    }

    public void setAflpa_bTele(String aflpa_bTele) {
        this.aflpa_bTele = aflpa_bTele;
    }

    public int getAflpa_facultyID() {
        return aflpa_facultyID;
    }

    public void setAflpa_facultyID(int aflpa_facultyID) {
        this.aflpa_facultyID = aflpa_facultyID;
    }

    public int getAflpa_isPermited() {
        return aflpa_isPermited;
    }

    public void setAflpa_isPermited(int aflpa_isPermited) {
        this.aflpa_isPermited = aflpa_isPermited;
    }

    @Override
    public String toString() {
        return "AForLPA{" +
                "aflpa_ID=" + aflpa_ID +
                ", aflpa_name='" + aflpa_name + '\'' +
                ", aflpa_number=" + aflpa_number +
                ", aflpa_bDate=" + aflpa_bDate +
                ", aflpa_useFor='" + aflpa_useFor + '\'' +
                ", aflpa_bName='" + aflpa_bName + '\'' +
                ", aflpa_bTele='" + aflpa_bTele + '\'' +
                ", aflpa_facultyID=" + aflpa_facultyID +
                ", aflpa_isPermited=" + aflpa_isPermited +
                '}';
    }
}
