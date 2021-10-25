package com.example.shopway.model;

public class Shop {

    private String name;
    private int iconId;

    public Shop(String name, int iconId)
    {
        this.name = name;
        this.iconId = iconId;
    }

    public String getName() {
        return name;
    }

    public int getIconId() {
        return iconId;
    }
}
