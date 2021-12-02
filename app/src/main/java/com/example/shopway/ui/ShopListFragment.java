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
           bundle.putString("URI", "https://netto.dk/tilbudsavis/#");
        }
        else if(clickedItemIndex == 1)
        {
            bundle.putInt("shopCode", 1);
            bundle.putString("URI", "https://avis.bilka.dk/bilka/denne-uges-avis/");
        }
        else if(clickedItemIndex == 2)
        {
            bundle.putInt("shopCode", 2);
            bundle.putString("URI", "https://www.lovbjerg.dk/tilbudsavis");
        }
        else if(clickedItemIndex == 3)
        {
            bundle.putInt("shopCode", 3);
            bundle.putString("URI", "https://rema1000.dk/om-rema-1000/avis/avis/?gclid=Cj0KCQiA-qGNBhD3ARIsAO_o7ymBkPKm6qDxgUtWaV1tjoCOKoeK7zFcvUxYmnwLiW2XcU9jt4dLLpwaAhZMEALw_wcB#catalogs/UcOmC0Ta/1");
        }
        else if(clickedItemIndex == 4)
        {
            bundle.putInt("shopCode", 4);
            bundle.putString("URI", "https://www.lidl.dk/information/tilbudsavis");
        }
        else if(clickedItemIndex == 5)
        {
           bundle.putInt("shopCode", 5);
            bundle.putString("URI", "https://fakta.coop.dk/tilbudsavis/");
        }

        Navigation.findNavController(getActivity(), R.id.nav_host_fragment).navigate(R.id.nav_items, bundle);

    }
}