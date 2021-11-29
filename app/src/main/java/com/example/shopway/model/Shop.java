package com.example.shopway.model;

public class Shop {

    private String name;
    private int iconId;
    private String location;

    public Shop(String name, int iconId, String location)
    {
        this.name = name;
        this.iconId = iconId;
        this.location = location;
    }

    public String getName() {
        return name;
    }

    public int getIconId() {
        return iconId;
    }

    public String getLocation()
    {
        return location;
    }
}
