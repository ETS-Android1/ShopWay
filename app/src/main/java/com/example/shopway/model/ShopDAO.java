package com.example.shopway.model;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.shopway.R;

import java.util.ArrayList;
import java.util.List;

public class ShopDAO {

    private MutableLiveData<ArrayList<Shop>> shops;
    private static ShopDAO instance;

    public static ShopDAO getInstance()
    {
        if(instance == null)
        {
            instance = new ShopDAO();
        }
        return instance;
    }

    private ShopDAO()
    {
        shops = new MutableLiveData<>();
        ArrayList<Shop> newList = new ArrayList<>();
        newList.add(new Shop("Netto", R.drawable.s_netto, "Horsens"));
        newList.add(new Shop("Bilka", R.drawable.s_bilka, "Horsens"));
        newList.add(new Shop("Løvbjerg", R.drawable.s_lovbjerg, "Horsens"));
        newList.add(new Shop("Rema1000", R.drawable.s_rema, "Horsens"));
        newList.add(new Shop("Lidl", R.drawable.s_lidl, "Horsens"));
        newList.add(new Shop("Fakta", R.drawable.s_fakta, "Horsens"));

        shops.setValue(newList);
    }

    public LiveData<ArrayList<Shop>> getShops()
    {
        return shops;
    }
}
