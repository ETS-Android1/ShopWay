package com.example.shopway.model;

import android.content.Context;

import androidx.lifecycle.LiveData;

import java.util.ArrayList;
import java.util.List;

public class ShopRepository {

    private ShopDAO shopDAO;
    private static ShopRepository instance;

    public static ShopRepository getInstance(Context context)
    {
        if(instance == null)
        {
            instance = new ShopRepository(context);
        }
        return instance;
    }

    private ShopRepository(Context context)
    {
        shopDAO = ShopDAO.getInstance(context);
    }

    public LiveData<ArrayList<Shop>> getShopList()
    {
        return shopDAO.getShops();
    }
}
