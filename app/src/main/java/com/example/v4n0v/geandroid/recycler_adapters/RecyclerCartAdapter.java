package com.example.v4n0v.geandroid.recycler_adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.v4n0v.geandroid.R;
import com.example.v4n0v.geandroid.goods.Product;

import java.util.List;

/**
 * Created by v4n0v on 14.03.18.
 */

public class RecyclerCartAdapter extends RecyclerView.Adapter<RecyclerCartAdapter.ViewHolder1> implements ListUpdateListener{

    private List<Product> elements;

    public static RecyclerCartAdapter getInstance(){
        if (adapter==null)adapter=new RecyclerCartAdapter();
        return adapter;
    }
    static RecyclerCartAdapter adapter;
    private RecyclerCartAdapter(){

    }


public void setElements(List<Product> elements) {
        this.elements = elements;

    }
    @Override
    public ViewHolder1 onCreateViewHolder(ViewGroup viewGroup, int viewType) {



        View itemLayoutView  = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_cart, viewGroup, false);
        ViewHolder1 vh = new ViewHolder1(itemLayoutView);
        return vh;

    }

    @Override
    public void onBindViewHolder(ViewHolder1 holder, int position) {

        holder.bind(position);

    }


    @Override
    public int getItemCount() {
        return (null != elements ? elements.size() : 0);
    }

    @Override
    public void update() {
        notifyDataSetChanged();
    }


    protected class ViewHolder1 extends RecyclerView.ViewHolder{// implements View.OnClickListener {
        private TextView itemTitleTextView;
        private TextView itemPriceTextView;

        private ImageView itemIsInCartImageView;
        private int id;


        public ViewHolder1(View v) {
            super(v);
//            super(inflater.inflate(R.layout.item_glass, parent, false));

            itemPriceTextView = itemView.findViewById(R.id.item_cart_price);
            itemTitleTextView = itemView.findViewById(R.id.item_cart_title);

            itemIsInCartImageView = itemView.findViewById(R.id.item_cart_added);
           // itemIsInCartImageView.setOnClickListener(this);
            itemIsInCartImageView.setTag(R.id.item_cart_added);

        }

        public void bind(int position) {
            if (elements.size() > 0) {
//                if (elements.get(position).isSelected()) {
                    itemTitleTextView.setText(elements.get(position).getTitle());
                    itemPriceTextView.setText(String.valueOf(elements.get(position).getPrice()) + "p");

            }
        }

    }



}