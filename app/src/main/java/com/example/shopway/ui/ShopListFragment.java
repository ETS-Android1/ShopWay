package com.example.shopway.ui;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.shopway.R;
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

        shopRecyclerList = view.findViewById(R.id.shopsRecycler);
        shopRecyclerList.hasFixedSize();
        shopRecyclerList.setLayoutManager(new LinearLayoutManager(view.getContext()));
        shopRecyclerList.setAdapter(adapter);

        return view;
    }

    @Override
    public void onListItemClick(int clickedItemIndex) {

        Bundle bundle = new Bundle();

        if(clickedItemIndex == 0)
        {
           bundle.putInt("shopCode", 0);
        }
        else if(clickedItemIndex == 1)
        {
            bundle.putInt("shopCode", 1);
        }
        else if(clickedItemIndex == 2)
        {
            bundle.putInt("shopCode", 2);
        }
        else if(clickedItemIndex == 3)
        {
            bundle.putInt("shopCode", 3);
        }
        else if(clickedItemIndex == 4)
        {
            bundle.putInt("shopCode", 4);
        }
        else if(clickedItemIndex == 5)
        {
           bundle.putInt("shopCode", 5);
        }

        Navigation.findNavController(getActivity(), R.id.nav_host_fragment).navigate(R.id.nav_items, bundle);

    }
}