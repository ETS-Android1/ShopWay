package com.example.shopway.model;

public class Item {

    private String name;
    private int iconId;
    private double price;
    private String type;
    private int quantity;


    public Item(String name, int iconId, double price) {
        this.name = name;
        this.iconId = iconId;
        this.price = price;
        quantity = 0;
    }

    public String getName() {
        return name;
    }

    public int getIconId() {
        return iconId;
    }

    public String getPriceString() {
        return Double.toString(price);
    }

    public double getPrice() {
        return price;
    }

    public String getQuantityString() {
        return "Quantity: " + quantity;
    }

    public int getQuantity()
    {
        return quantity;
    }

    public void setQuantity() {
        this.quantity = 1;
    }

    public void incrementQuantity()
    {
        quantity += 1;
        price += price; //For when I show overall price in the cart
    }

    public void decreaseQuantity()
    {
        quantity -= 1;
        price -= price;
    }

}
