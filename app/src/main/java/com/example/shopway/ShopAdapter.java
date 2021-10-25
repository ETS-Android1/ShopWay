package com.example.shopway;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.shopway.model.Shop;

import java.util.ArrayList;

public class ShopAdapter extends RecyclerView.Adapter<ShopAdapter.ViewHolder> {

    private ArrayList<Shop> shops;
    final private OnListItemClickListener onListItemClickListener;


    ShopAdapter(ArrayList<Shop> shops, OnListItemClickListener onListItemClickListener)
    {
        this.shops = shops;
        this.onListItemClickListener = onListItemClickListener;
    }

    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.shop_list_item, parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.name.setText(shops.get(position).getName());
        holder.shopIcon.setImageResource(shops.get(position).getIconId());

    }

    @Override
    public int getItemCount() {
        return shops.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener
    {
        TextView name;
        ImageView shopIcon;

        public ViewHolder(View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.shopName);
            shopIcon = itemView.findViewById(R.id.shopPic);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            onListItemClickListener.onListItemClick(getAdapterPosition());
        }
    }

    public interface OnListItemClickListener {
        void onListItemClick(int clickedItemIndex);
    }
}
