package com.example.shopway.model;

import android.content.Context;

import androidx.lifecycle.LiveData;

import java.util.ArrayList;

public class ItemRepository {

    private ItemDAO itemDAO;
    private static ItemRepository instance;

    public static ItemRepository getInstance(Context context)
    {
        if(instance == null)
        {
            instance = new ItemRepository(context);
        }
        return instance;
    }

    private ItemRepository(Context context)
    {
        itemDAO = ItemDAO.getInstance(context);
    }

    public LiveData<ArrayList<Item>> getItemsList(int code)
    {
        return itemDAO.getItems(code);
    }

    public void addCartItem(Item item)
    {
        itemDAO.addToCart(item);
    }

    public void deleteCartItem(Item item)
    {
        itemDAO.removeFromCart(item);
    }

    public LiveData<ArrayList<Item>> showCartItems()
    {
        return itemDAO.showCartItems();
    }

    public void emptyCart()
    {
      itemDAO.emptyCart();
    }

    public LiveData<Double> getTotal()
    {
       return itemDAO.getTotal();
    }
}
