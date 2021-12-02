package com.example.shopway.model;

import android.content.Context;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.shopway.R;

import java.util.ArrayList;
import java.util.List;

public class ItemDAO {

    private MutableLiveData<ArrayList<Item>> items;
    private static ItemDAO instance;

    private ArrayList<Item> nettoItems;
    private ArrayList<Item> faktaItems;
    private ArrayList<Item> bilkaItems;
    private ArrayList<Item> lovbjergItems;
    private ArrayList<Item> remaItems;
    private ArrayList<Item> lidlItems;

    private ArrayList<Item> cartItems;
    private MutableLiveData<ArrayList<Item>> cartData;

    Context context;

    public static ItemDAO getInstance(Context context)
    {
        if(instance == null)
        {
            instance = new ItemDAO(context);
        }
        return instance;
    }

    private ItemDAO(Context context)
    {
        this.context = context;
        cartItems = new ArrayList<>();
        items = new MutableLiveData<>();
        cartData = new MutableLiveData<>();

        nettoItems = new ArrayList<>();
        nettoItems.add(new Item(context.getString(R.string.beef_string), R.drawable.netto_beef, 35.00));
        nettoItems.add(new Item(context.getString(R.string.mBeef_string), R.drawable.netto_minced_meat, 24.00));
        nettoItems.add(new Item(context.getString(R.string.mango_string), R.drawable.netto_mango, 8.00));
        nettoItems.add(new Item(context.getString(R.string.potato_string), R.drawable.netto_potatoes, 15.00));
        nettoItems.add(new Item(context.getString(R.string.shroom_string), R.drawable.netto_shrooms, 12.00));
        nettoItems.add(new Item(context.getString(R.string.gin_string), R.drawable.netto_gin_tonic, 20.00));
        nettoItems.add(new Item(context.getString(R.string.juice_string), R.drawable.netto_juice, 10.00));
        nettoItems.add(new Item(context.getString(R.string.tow_string), R.drawable.netto_towels, 99.00));
        nettoItems.add(new Item(context.getString(R.string.scale_string), R.drawable.netto_scale, 79.00));

        faktaItems = new ArrayList<>();
        faktaItems.add(new Item(context.getString(R.string.mBeef_string), R.drawable.fakta_minced_meat, 20.00));
        faktaItems.add(new Item(context.getString(R.string.cot_string), R.drawable.fakta_pork, 29.00));
        faktaItems.add(new Item(context.getString(R.string.pear_string), R.drawable.fakta_pears, 5.00));
        faktaItems.add(new Item(context.getString(R.string.blueberies_string), R.drawable.fakta_blueberries, 20.00));
        faktaItems.add(new Item(context.getString(R.string.soda_string), R.drawable.fakta_soda, 15.00));

        bilkaItems = new ArrayList<>();
        bilkaItems.add(new Item(context.getString(R.string.chick_string), R.drawable.bilka_chicken, 25.00));
        bilkaItems.add(new Item(context.getString(R.string.clem_string), R.drawable.bilka_clementines, 10.00));
        bilkaItems.add(new Item(context.getString(R.string.potato_string), R.drawable.bilka_potatoes, 15.00));
        bilkaItems.add(new Item(context.getString(R.string.champ_string), R.drawable.bilka_champange, 150.00));
        bilkaItems.add(new Item(context.getString(R.string.shampo_string), R.drawable.bilka_shampoo, 35.00));
        bilkaItems.add(new Item(context.getString(R.string.soap_string), R.drawable.bilka_soap, 12.00));

        lovbjergItems = new ArrayList<>();
        lovbjergItems.add(new Item(context.getString(R.string.mBeef_string), R.drawable.lov_minced_beef, 39.00));
        lovbjergItems.add(new Item(context.getString(R.string.pork_string), R.drawable.lov_pork, 39.00));
        lovbjergItems.add(new Item(context.getString(R.string.soya_string), R.drawable.lov_soya, 19.00));
        lovbjergItems.add(new Item(context.getString(R.string.yoghurt_string), R.drawable.lov_youghurt, 18.00));
        lovbjergItems.add(new Item(context.getString(R.string.coffee_string), R.drawable.lov_coffee, 29.00));
        lovbjergItems.add(new Item(context.getString(R.string.toilet_string), R.drawable.lov_toilet_paper, 25.00));

        remaItems = new ArrayList<>();
        remaItems.add(new Item(context.getString(R.string.beef_string), R.drawable.rema_beef, 30.00));
        remaItems.add(new Item(context.getString(R.string.ham_string), R.drawable.rema_ham, 10.00));
        remaItems.add(new Item(context.getString(R.string.corn_string), R.drawable.rema_corn, 5.00));
        remaItems.add(new Item(context.getString(R.string.cookie_string), R.drawable.rema_cookies, 13.00));
        remaItems.add(new Item(context.getString(R.string.chips_string), R.drawable.rema_chips, 20.00));
        remaItems.add(new Item(context.getString(R.string.soda_string), R.drawable.rema_soda, 12.00));

        lidlItems = new ArrayList<>();
        lidlItems.add(new Item(context.getString(R.string.mBeef_string), R.drawable.lidl_minced_beef, 20.00));
        lidlItems.add(new Item(context.getString(R.string.sousage_string), R.drawable.lidl_sossage, 25.00));
        lidlItems.add(new Item(context.getString(R.string.bread_string), R.drawable.lidl_bread, 15.00));
        lidlItems.add(new Item(context.getString(R.string.corny_string), R.drawable.lidl_corny, 10.00));
        lidlItems.add(new Item(context.getString(R.string.ice_string), R.drawable.lidl_ice_cream, 30.00));
        lidlItems.add(new Item(context.getString(R.string.bluse_string), R.drawable.lidl_bluse, 89.00));

    }

    public LiveData<ArrayList<Item>> getItems(int code)
    {
        if(code == 0)
        {
            items.setValue(nettoItems);
        } else if(code == 1)
        {
            items.setValue(bilkaItems);
        } else if(code == 2)
        {
            items.setValue(lovbjergItems);
        } else if(code == 3)
        {
            items.setValue(remaItems);
        } else if(code == 4)
        {
            items.setValue(lidlItems);
        } else if(code == 5)
        {
            items.setValue(faktaItems);
        }
        return items;
    }

    public void addToCart(Item item)
    {
        Boolean exists = false;
        Item newItem = new Item(item.getName(), item.getIconId(), item.getPrice());
        newItem.setQuantity();
        ArrayList<Item> current = cartData.getValue();
        if(current != null)  {
            for (int i = 0; i < current.size(); i++) {
                if (item.getIconId() == current.get(i).getIconId()) {
                    exists = true;
                    cartItems.get(i).incrementQuantity();
                }
            }
        }
        if(exists == false)
        {
            cartItems.add(newItem);
        }
        cartData.setValue(current);
    }

    public LiveData<ArrayList<Item>> showCartItems()
    {
        cartData.setValue(cartItems);
        return cartData;
    }

    public void removeFromCart(Item item)
    {
        ArrayList<Item> current = cartData.getValue();
        for(int i = 0; i < current.size(); i++)
        {
            if(item.getIconId() == current.get(i).getIconId())
            {
                if(current.get(i).getQuantity() > 1)
                {
                    current.get(i).decreaseQuantity();
                } else
                {
                    current.remove(i);
                }
            }
        }
    }

    public void emptyCart()
    {
        if(cartData != null) {
            ArrayList<Item> current = new ArrayList<>();
            cartData.setValue(current);
        }
    }

    public LiveData<Double> getTotal()
    {
        MutableLiveData<Double> toSend = new MutableLiveData<>();
        double total = 0;
        ArrayList<Item> current = cartData.getValue();

        for(int i = 0; i < current.size(); i++)
        {
            total += current.get(i).getPrice();
        }
        toSend.setValue(total);

        return toSend;
    }


}
