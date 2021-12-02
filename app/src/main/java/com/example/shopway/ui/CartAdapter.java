package com.example.shopway.ui;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.shopway.R;
import com.example.shopway.model.Item;

import java.util.ArrayList;
import java.util.List;

public class CartAdapter extends RecyclerView.Adapter<CartAdapter.ViewHolder> {
    final private OnListItemClickListener onListItemClickListener;
    ArrayList<Item> items;

    public CartAdapter(ArrayList<Item> items, OnListItemClickListener onListItemClickListener) {
        this.onListItemClickListener = onListItemClickListener;
        this.items = items;
    }

    public void updateData(ArrayList<Item> items)
    {
        this.items = items;
        notifyDataSetChanged();
    }


    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.cart_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.name.setText(items.get(position).getName());
        holder.quantity.setText(items.get(position).getQuantityString());
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener
    {
        TextView name;
        TextView quantity;
        Button addMore;
        Button remove;

        public ViewHolder(View itemView)
        {
            super(itemView);
            name = itemView.findViewById(R.id.cart_item_name);
            quantity = itemView.findViewById(R.id.cart_item_quantity);
            addMore = itemView.findViewById(R.id.add_cart);
            remove = itemView.findViewById(R.id.remove_cart);

            addMore.setOnClickListener(this);
            remove.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            if(v.getId() == addMore.getId()) {
                onListItemClickListener.onAddClick(getAdapterPosition());
            } else {
                onListItemClickListener.onRemoveClick(getAdapterPosition());
            }
        }
    }

    public interface OnListItemClickListener
    {
        void onAddClick(int clickedItemIndex);
        void onRemoveClick(int clickedItemIndex);
    }
}


