package com.example.v4n0v.geandroid.recycler_adapters;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.v4n0v.geandroid.Product;
import com.example.v4n0v.geandroid.R;
import com.example.v4n0v.geandroid.data.Preferences;

import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Locale;

/**
 * Created by v4n0v on 14.03.18.
 */

public class RecyclerCartAdapter extends RecyclerView.Adapter<RecyclerCartAdapter.ViewHolder> {

    private List<Product> elements;


    public RecyclerCartAdapter(List<Product> elements) {
        this.elements = elements;

    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(viewGroup.getContext());
        return new ViewHolder(inflater, viewGroup);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.bind(position);
    }


    @Override
    public int getItemCount() {
        return (null != elements ? elements.size() : 0);
    }

    /**
     * View holder to display each RecylerView itemFactoryTextView
     */
    protected class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private TextView itemFactoryTextView;
        private TextView itemPriceTextView;
        private TextView itemInsertPriceTextView;
        private TextView itemtypeTextView;
        private ImageView itemIsInCartImageView;
        private int id;

        public ViewHolder(LayoutInflater inflater, ViewGroup parent) {
            super(inflater.inflate(R.layout.item_products, parent, false));

            itemPriceTextView = itemView.findViewById(R.id.item_cart_insert_price);
            itemFactoryTextView = itemView.findViewById(R.id.item_cart_factory);
            itemInsertPriceTextView = itemView.findViewById(R.id.item_cart_price);
            itemtypeTextView = itemView.findViewById(R.id.item_type_title);
            itemIsInCartImageView = itemView.findViewById(R.id.item_cart_added);
            itemIsInCartImageView.setOnClickListener(this);
            itemIsInCartImageView.setTag(R.id.item_cart_added);

        }

        void bind(int position) {
            if (elements.size() > 0) {
                itemFactoryTextView.setText(elements.get(position).getFactoryTitle());
                itemPriceTextView.setText(String.valueOf(elements.get(position).getPrice()) + "p");
                itemInsertPriceTextView.setText(String.format("%.0f", elements.get(position).getInsertPrice()) + "p");
                itemtypeTextView.setText(elements.get(position).getTypeTitle());
                if (elements.get(position).isSelected()) {
                    id = Preferences.ID_IN_CART_ICO;
                } else {
                    id = Preferences.ID_OUT_CART_ICO;
                }


                itemIsInCartImageView.setImageResource(id);

            }
        }


        @Override
        public void onClick(View view) {
             int tag = (int) view.getTag();
             String toast;
            if (tag==R.id.item_cart_added){
                if (elements.get(getLayoutPosition()).isSelected()) {
                    elements.get(getLayoutPosition()).setSelected(false);
                    toast="удалено из корзины";
                } else {
                    elements.get(getLayoutPosition()).setSelected(true);
                    toast="добавлено в корзину";
                }

                Toast.makeText(view.getContext(), toast, Toast.LENGTH_SHORT).show();
                notifyDataSetChanged();
            }
        }
    }


}