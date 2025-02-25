package com.example.febandroid;

public class MyListData {
    String name;
    String des;
    int img;

    public MyListData(String name, String des, int img) {
        this.name = name;
        this.des = des;
        this.img = img;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDes() {
        return des;
    }

    public void setDes(String des) {
        this.des = des;
    }

    public int getImg() {
        return img;
    }

    public void setImg(int img) {
        this.img = img;
    }
}
