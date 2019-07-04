package com.tranduc.smacthuctap.model;

public class DayOne {
    private String name;
    private String img;
    private String general;
    private String pass;
    private String status;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getGeneral() {
        return general;
    }

    public void setGeneral(String general) {
        this.general = general;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public DayOne(String name, String img, String general, String pass, String status) {
        this.name = name;
        this.img = img;
        this.general = general;
        this.pass = pass;
        this.status = status;
    }
}
