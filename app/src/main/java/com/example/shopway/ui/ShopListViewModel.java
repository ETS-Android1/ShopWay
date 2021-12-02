package com.example.shopway.ui;

import android.app.Application;
import android.content.Context;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.example.shopway.model.Shop;
import com.example.shopway.model.ShopRepository;

import java.util.ArrayList;

public class ShopListViewModel extends AndroidViewModel {

    private ShopRepository repository;

    public ShopListViewModel(Application app)
    {
        super(app);
        repository = ShopRepository.getInstance(app.getApplicationContext());

    }

    public LiveData<ArrayList<Shop>> getShops() {
        return repository.getShopList();
    }


}
