package edu.whpu.pojo;

public class Faculty {
    private int f_ID;
    private String f_name;
    private String f_deanName;
    private String f_deanTele;

    public Faculty() {
    }

    public Faculty(int f_ID, String f_name, String f_deanName, String f_deanTele) {
        this.f_ID = f_ID;
        this.f_name = f_name;
        this.f_deanName = f_deanName;
        this.f_deanTele = f_deanTele;
    }

    public int getF_ID() {
        return f_ID;
    }

    public void setF_ID(int f_ID) {
        this.f_ID = f_ID;
    }

    public String getF_name() {
        return f_name;
    }

    public void setF_name(String f_name) {
        this.f_name = f_name;
    }

    public String getF_deanName() {
        return f_deanName;
    }

    public void setF_deanName(String f_deanName) {
        this.f_deanName = f_deanName;
    }

    public String getF_deanTele() {
        return f_deanTele;
    }

    public void setF_deanTele(String f_deanTele) {
        this.f_deanTele = f_deanTele;
    }

    @Override
    public String toString() {
        return "Faculty{" +
                "f_ID=" + f_ID +
                ", f_name='" + f_name + '\'' +
                ", f_deanName='" + f_deanName + '\'' +
                ", f_deanTele='" + f_deanTele + '\'' +
                '}';
    }
}
