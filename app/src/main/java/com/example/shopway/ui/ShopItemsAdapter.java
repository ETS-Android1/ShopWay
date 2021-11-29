package com.example.shopway.ui;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.shopway.R;
import com.example.shopway.model.Item;
import java.util.ArrayList;

public class ShopItemsAdapter extends RecyclerView.Adapter<ShopItemsAdapter.ViewHolder> {

    private ArrayList<Item> items;
    final private OnListItemClickListener onListItemClickListener;

    ShopItemsAdapter(ArrayList<Item> items, OnListItemClickListener onListItemClickListener) {
        this.items = items;
        this.onListItemClickListener = onListItemClickListener;
    }

    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.shop_items_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
            holder.name.setText(items.get(position).getName());
            holder.itemIcon.setImageResource(items.get(position).getIconId());
            holder.price.setText(items.get(position).getPrice());

    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener
    {
        TextView name;
        ImageView itemIcon;
        TextView price;

        public ViewHolder(View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.itemName);
            itemIcon = itemView.findViewById(R.id.itemImage);
            price = itemView.findViewById(R.id.priceText);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            onListItemClickListener.onListItemClick(getAdapterPosition());
        }
    }

    public interface OnListItemClickListener
    {
        void onListItemClick(int clickedItemIndex);
    }
}


