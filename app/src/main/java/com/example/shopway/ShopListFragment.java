package com.example.shopway;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.shopway.model.Shop;

import java.util.ArrayList;

public class ShopListFragment extends Fragment implements ShopAdapter.OnListItemClickListener {

    private ShopListViewModel viewModel;
    ShopAdapter adapter;
    RecyclerView shopRecyclerList;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        viewModel = new ViewModelProvider(this).get(ShopListViewModel.class);
        ArrayList<Shop> shops = viewModel.getShops().getValue();
        adapter = new ShopAdapter(shops, this);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_shop_list, container, false);

        //Line below might make a problem -_0_- definitely makes a problem. Moving it in the onCreate method doesn't make a difference
        shopRecyclerList = view.findViewById(R.id.shopsRecycler);
        shopRecyclerList.hasFixedSize();
        shopRecyclerList.setLayoutManager(new LinearLayoutManager(view.getContext()));


        shopRecyclerList.setAdapter(adapter);

        return view;
    }

    @Override
    public void onListItemClick(int clickedItemIndex) {

    }
}