package com.example.shopway.ui;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.shopway.R;
import com.example.shopway.model.Item;

import java.util.ArrayList;

public class CartFragment extends Fragment implements CartAdapter.OnListItemClickListener {
    private CartViewModel viewModel;
    CartAdapter adapter;
    RecyclerView itemsList;
    TextView orderPrice;
    Button checkout;
    Button emptyCart;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);



    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        viewModel = new ViewModelProvider(this).get(CartViewModel.class);
        adapter = new CartAdapter(this);
        viewModel.getCartItems().observe(getViewLifecycleOwner(), adapter::updateData);
        View view = inflater.inflate(R.layout.fragment_shopping_cart, container, false);
        itemsList = view.findViewById(R.id.cartRecycler);
        itemsList.hasFixedSize();
        itemsList.setLayoutManager(new LinearLayoutManager(this.getContext()));
        itemsList.setAdapter(adapter);

        checkout = view.findViewById(R.id.cashout_button);
        emptyCart = view.findViewById(R.id.empty_cart_button);

        emptyCart.setOnClickListener(v -> viewModel.emptyCart());

        return view;
    }

    @Override
    public void onListItemClick(int clickedItemIndex) {
        viewModel.removeFromCart(adapter.items.get(clickedItemIndex));
        adapter.updateData(viewModel.getCartItems().getValue());
    }
}