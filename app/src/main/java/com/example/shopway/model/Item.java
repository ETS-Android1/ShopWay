package com.example.shopway.model;

public class Item {

    private String name;
    private int iconId;
    private double price;
    private String type;


    public Item(String name, int iconId, double price) {
        this.name = name;
        this.iconId = iconId;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public int getIconId() {
        return iconId;
    }

    public String getPrice() {
        return Double.toString(price);
    }

}
