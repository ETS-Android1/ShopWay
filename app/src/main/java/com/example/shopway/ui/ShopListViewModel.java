package com.example.shopway.ui;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.example.shopway.model.Shop;
import com.example.shopway.model.ShopRepository;

import java.util.ArrayList;

public class ShopListViewModel extends ViewModel {

    private ShopRepository repository;

    public ShopListViewModel()
    {
        repository = ShopRepository.getInstance();

    }

    public LiveData<ArrayList<Shop>> getShops() {
        return repository.getShopList();
    }
}
