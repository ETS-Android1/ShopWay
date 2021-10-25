package com.example.shopway.model;

import androidx.lifecycle.LiveData;

import java.util.ArrayList;
import java.util.List;

public class ShopRepository {

    private ShopDAO shopDAO;
    private static ShopRepository instance;

    public static ShopRepository getInstance()
    {
        if(instance == null)
        {
            instance = new ShopRepository();
        }
        return instance;
    }

    private ShopRepository()
    {
        shopDAO = ShopDAO.getInstance();
    }

    public LiveData<ArrayList<Shop>> getShopList()
    {
        return shopDAO.getShops();
    }
}
