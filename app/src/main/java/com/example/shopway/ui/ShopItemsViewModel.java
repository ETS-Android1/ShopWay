package com.example.shopway.ui;

import android.app.Application;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.example.shopway.model.Item;
import com.example.shopway.model.ItemRepository;

import java.util.ArrayList;

public class ShopItemsViewModel extends AndroidViewModel {
    private ItemRepository repository;

    public ShopItemsViewModel(Application application)
    {
        super(application);
        repository = ItemRepository.getInstance(application.getApplicationContext());
    }

    public LiveData<ArrayList<Item>> getShopItems(int code)
    {
        return repository.getItemsList(code);
    }

    public void addCartItem(Item item)
    {
        repository.addCartItem(item);
    }

    public void removeCartItem(Item item)
    {

    }
}
