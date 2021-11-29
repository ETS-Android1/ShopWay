package com.example.shopway.model;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.shopway.R;

import java.util.ArrayList;

public class ItemDAO {

    private MutableLiveData<ArrayList<Item>> items;
    private static ItemDAO instance;

    private ArrayList<Item> nettoItems;
    private ArrayList<Item> faktaItems;

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
        items = new MutableLiveData<>();
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

    }

    public void setItemsList(int code)
    {

    }

    public LiveData<ArrayList<Item>> getItems(int code)
    {
        if(code == 0)
        {
            items.setValue(nettoItems);
        } else if(code == 7)
        {
            items.setValue(faktaItems);
        }
        return items;
    }

}
