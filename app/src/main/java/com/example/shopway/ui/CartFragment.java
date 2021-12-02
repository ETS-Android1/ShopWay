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

public class CartFragment extends Fragment implements CartAdapter.OnListItemClickListener {
    private CartViewModel viewModel;
    CartAdapter adapter;
    RecyclerView itemsList;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        viewModel = new ViewModelProvider(this).get(CartViewModel.class);
        View view = inflater.inflate(R.layout.fragment_shopping_cart, container, false);
        itemsList = view.findViewById(R.id.cartRecycler);
        itemsList.hasFixedSize();
        itemsList.setLayoutManager(new LinearLayoutManager(this.getContext()));
        adapter = new CartAdapter(this);
        viewModel.getCartItems().observe(getViewLifecycleOwner(), adapter::updateData);
        itemsList.setAdapter(adapter);




        return view;
    }

    @Override
    public void onListItemClick(int clickedItemIndex) {

    }
}