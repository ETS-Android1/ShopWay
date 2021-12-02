package com.example.shopway.ui;

import android.app.Application;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.shopway.model.Item;
import com.example.shopway.model.ItemRepository;

import java.util.ArrayList;
import java.util.List;

public class CartViewModel extends AndroidViewModel {
    private ItemRepository repository;

    public CartViewModel(Application app)

    {
        super(app);
        repository = ItemRepository.getInstance();
    }

    public LiveData<ArrayList<Item>> getCartItems()
    {
        return repository.showCartItems();
    }

    public void removeFromCart(Item item)
    {
        repository.deleteCartItem(item);
    }

    public void emptyCart()
    {
        repository.emptyCart();
    }


}

