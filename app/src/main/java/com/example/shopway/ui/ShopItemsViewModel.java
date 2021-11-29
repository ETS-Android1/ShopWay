package com.example.shopway.ui;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.example.shopway.model.Item;
import com.example.shopway.model.ItemRepository;

import java.util.ArrayList;

public class ShopItemsViewModel extends ViewModel {
    private ItemRepository repository;

    public ShopItemsViewModel()
    {
        repository = ItemRepository.getInstance();
    }

    public LiveData<ArrayList<Item>> getShopItems(int code)
    {
        return repository.getItemsList(code);
    }
}
