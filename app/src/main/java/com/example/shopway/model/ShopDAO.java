package com.example.shopway.model;

import android.content.Context;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.shopway.R;

import java.util.ArrayList;
import java.util.List;

public class ShopDAO {

    private MutableLiveData<ArrayList<Shop>> shops;
    private static ShopDAO instance;
    Context context;

    public static ShopDAO getInstance(Context context)
    {
        if(instance == null)
        {
            instance = new ShopDAO(context);
        }
        return instance;
    }

    private ShopDAO(Context context)
    {
        this.context = context;
        shops = new MutableLiveData<>();
        ArrayList<Shop> newList = new ArrayList<>();
        newList.add(new Shop(context.getString(R.string.netto_string), R.drawable.s_netto, context.getString(R.string.horsens_string)));
        newList.add(new Shop(context.getString(R.string.bilka_string), R.drawable.s_bilka, context.getString(R.string.horsens_string)));
        newList.add(new Shop(context.getString(R.string.lov_string), R.drawable.s_lovbjerg, context.getString(R.string.horsens_string)));
        newList.add(new Shop(context.getString(R.string.rema_string), R.drawable.s_rema, context.getString(R.string.horsens_string)));
        newList.add(new Shop(context.getString(R.string.lidl_string), R.drawable.s_lidl, context.getString(R.string.horsens_string)));
        newList.add(new Shop(context.getString(R.string.fakta_string), R.drawable.s_fakta, context.getString(R.string.horsens_string)));

        shops.setValue(newList);
    }

    public LiveData<ArrayList<Shop>> getShops()
    {
        return shops;
    }
}
