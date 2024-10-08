package com.example.vehicles;

public class Vehicle
{
    private String name;
    private int img;
    public Vehicle(){}
    public Vehicle(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }//hey

    public int getImg() {
        return img;
    }

    public void setImg(int img) {
        this.img = img;
    }

    public void setName(String name) {
        this.name = name;
    }
}
