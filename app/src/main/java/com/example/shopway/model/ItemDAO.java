package com.example.shopway.model;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.shopway.R;

import java.util.ArrayList;
import java.util.List;

public class ItemDAO {

    private MutableLiveData<ArrayList<Item>> items;
    private static ItemDAO instance;

    private ArrayList<Item> nettoItems;
    private ArrayList<Item> faktaItems;
    private ArrayList<Item> bilkaItems;
    private ArrayList<Item> lovbjergItems;
    private ArrayList<Item> remaItems;
    private ArrayList<Item> lidlItems;

    private ArrayList<Item> cartItems;
    private MutableLiveData<ArrayList<Item>> cartData;

    public static ItemDAO getInstance()
    {
        if(instance == null)
        {
            instance = new ItemDAO();
        }
        return instance;
    }

    private ItemDAO()
    {
        cartItems = new ArrayList<>();
        items = new MutableLiveData<>();
        cartData = new MutableLiveData<>();

        nettoItems = new ArrayList<>();
        nettoItems.add(new Item("Beef", R.drawable.netto_beef, 35.00));
        nettoItems.add(new Item("Minced Beef", R.drawable.netto_minced_meat, 24.00));
        nettoItems.add(new Item("Mango", R.drawable.netto_mango, 8.00));
        nettoItems.add(new Item("Potatoes", R.drawable.netto_potatoes, 15.00));
        nettoItems.add(new Item("Shrooms", R.drawable.netto_shrooms, 12.00));
        nettoItems.add(new Item("Gin Tonic", R.drawable.netto_gin_tonic, 20.00));
        nettoItems.add(new Item("Juice", R.drawable.netto_juice, 10.00));
        nettoItems.add(new Item("Towels", R.drawable.netto_towels, 99.00));
        nettoItems.add(new Item("Kitchen Scale", R.drawable.netto_scale, 79.00));

        faktaItems = new ArrayList<>();
        faktaItems.add(new Item("Minced Beef", R.drawable.fakta_minced_meat, 20.00));
        faktaItems.add(new Item("Kotlett", R.drawable.fakta_pork, 29.00));
        faktaItems.add(new Item("Pears", R.drawable.fakta_pears, 5.00));
        faktaItems.add(new Item("Blueberries", R.drawable.fakta_blueberries, 20.00));
        faktaItems.add(new Item("Coca Cola", R.drawable.fakta_soda, 15.00));

        bilkaItems = new ArrayList<>();
        bilkaItems.add(new Item("Chicken", R.drawable.bilka_chicken, 25.00));
        bilkaItems.add(new Item("Clementines", R.drawable.bilka_clementines, 10.00));
        bilkaItems.add(new Item("Potatoes", R.drawable.bilka_potatoes, 15.00));
        bilkaItems.add(new Item("Champange", R.drawable.bilka_champange, 150.00));
        bilkaItems.add(new Item("Shampoo", R.drawable.bilka_shampoo, 35.00));
        bilkaItems.add(new Item("Soap", R.drawable.bilka_soap, 12.00));

        lovbjergItems = new ArrayList<>();
        lovbjergItems.add(new Item("Minced Beef", R.drawable.lov_minced_beef, 39.00));
        lovbjergItems.add(new Item("Pork", R.drawable.lov_pork, 39.00));
        lovbjergItems.add(new Item("Soya Milk", R.drawable.lov_soya, 19.00));
        lovbjergItems.add(new Item("Yoghurt", R.drawable.lov_youghurt, 18.00));
        lovbjergItems.add(new Item("Coffee", R.drawable.lov_coffee, 29.00));
        lovbjergItems.add(new Item("Toilet Paper", R.drawable.lov_toilet_paper, 25.00));

        remaItems = new ArrayList<>();
        remaItems.add(new Item("Beef", R.drawable.rema_beef, 30.00));
        remaItems.add(new Item("Ham", R.drawable.rema_ham, 10.00));
        remaItems.add(new Item("Corn", R.drawable.rema_corn, 5.00));
        remaItems.add(new Item("Cookies", R.drawable.rema_cookies, 13.00));
        remaItems.add(new Item("Chips", R.drawable.rema_chips, 20.00));
        remaItems.add(new Item("Cola", R.drawable.rema_soda, 12.00));

        lidlItems = new ArrayList<>();
        lidlItems.add(new Item("Minced Beef", R.drawable.lidl_minced_beef, 20.00));
        lidlItems.add(new Item("Sausage", R.drawable.lidl_sossage, 25.00));
        lidlItems.add(new Item("Bread", R.drawable.lidl_bread, 15.00));
        lidlItems.add(new Item("Corny", R.drawable.lidl_corny, 10.00));
        lidlItems.add(new Item("Ice Cream", R.drawable.lidl_ice_cream, 30.00));
        lidlItems.add(new Item("Bluse", R.drawable.lidl_bluse, 89.00));

    }

    public LiveData<ArrayList<Item>> getItems(int code)
    {
        if(code == 0)
        {
            items.setValue(nettoItems);
        } else if(code == 1)
        {
            items.setValue(bilkaItems);
        } else if(code == 2)
        {
            items.setValue(lovbjergItems);
        } else if(code == 3)
        {
            items.setValue(remaItems);
        } else if(code == 4)
        {
            items.setValue(lidlItems);
        } else if(code == 5)
        {
            items.setValue(faktaItems);
        }
        return items;
    }

    public void addToCart(Item item)
    {
        Boolean exists = false;
        ArrayList<Item> current = cartData.getValue();
        for(int i = 0; i < cartItems.size(); i++)
        {
            if(item.getIconId() == current.get(i).getIconId())
            {
                exists = true;
                cartItems.get(i).incrementQuantity();
            }
        }
        if(exists == false)
        {
            cartItems.add(item);
        }
        cartData.setValue(current);
    }

    public LiveData<ArrayList<Item>> showCartItems()
    {
        cartData.setValue(cartItems);
        return cartData;
    }

    public void removeFromCart(Item item)
    {
        ArrayList<Item> current = cartData.getValue();
        for(int i = 0; i < current.size(); i++)
        {
            if(item.getIconId() == current.get(i).getIconId())
            {
                if(current.get(i).getQuantity() > 1)
                {
                    current.get(i).decreaseQuantity();
                } else
                {
                    current.remove(i);
                }
            }
        }
    }

}
