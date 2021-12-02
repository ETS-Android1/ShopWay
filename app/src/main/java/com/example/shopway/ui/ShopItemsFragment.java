package com.example.shopway.ui;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.shopway.R;
import com.example.shopway.model.Item;
import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;


public class ShopItemsFragment extends Fragment implements ShopItemsAdapter.OnListItemClickListener {

    private ShopItemsViewModel viewModel;
    ShopItemsAdapter adapter;
    RecyclerView itemsRecyclerList;
    private int shopCode;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        shopCode = getArguments().getInt("shopCode");

        viewModel = new ViewModelProvider(this).get(ShopItemsViewModel.class);
        ArrayList<Item> items = viewModel.getShopItems(shopCode).getValue();
        adapter = new ShopItemsAdapter(items, this);


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_shop_items, container, false);
        itemsRecyclerList = view.findViewById(R.id.itemsRecycler);
        itemsRecyclerList.hasFixedSize();
        itemsRecyclerList.setLayoutManager(new LinearLayoutManager(view.getContext()));
        itemsRecyclerList.setAdapter(adapter);

        return view;
    }

    @Override
    public void onListItemClick(int clickedItemIndex) {
        Item newItem = adapter.items.get(clickedItemIndex);
        viewModel.addCartItem(newItem);
        Snackbar addSnack = Snackbar.make(itemsRecyclerList,newItem.getName()
                + " added to cart!", Snackbar.LENGTH_SHORT).setAction("Undo", view -> {
            Snackbar undoSnack = Snackbar.make(itemsRecyclerList, newItem.getName()
                    + " is now removed!", Snackbar.LENGTH_SHORT);
            viewModel.removeCartItem(newItem);
            undoSnack.show();
        });
        addSnack.show();
    }
}