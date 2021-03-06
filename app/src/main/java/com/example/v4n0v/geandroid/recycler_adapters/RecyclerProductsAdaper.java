package com.example.v4n0v.geandroid.recycler_adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.v4n0v.geandroid.goods.Glass;
import com.example.v4n0v.geandroid.R;
import com.example.v4n0v.geandroid.data.Preferences;
import com.example.v4n0v.geandroid.goods.Product;

import java.util.List;

/**
 * Created by v4n0v on 16.03.18.
 */

public class RecyclerProductsAdaper extends RecyclerView.Adapter<RecyclerProductsAdaper.ViewHolder> {

        ListUpdateListener listUpdateListener;

        private List<Glass> elements;
         List<Product> selectedElements;

        public RecyclerProductsAdaper(List<Glass> elements, List<Product> selectedElements) {
            this.elements = elements;
            this.selectedElements = selectedElements;
            listUpdateListener=RecyclerCartAdapter.getInstance();
        }


    @Override
        public  ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {

            ViewHolder vh=null;
            View itemLayoutView;

            itemLayoutView = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_glass, viewGroup, false);
            vh = new  ViewHolder(itemLayoutView);
            return vh;

        }

        @Override
        public void onBindViewHolder( ViewHolder holder, int position) {

            holder.bind(position);


        }


        @Override
        public int getItemCount() {
            return (null != elements ? elements.size() : 0);
        }


        protected class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
            private TextView itemFactoryTextView;
            private TextView itemPriceTextView;
            private TextView itemInsertPriceTextView;
            private TextView itemtypeTextView;
            private ImageView itemIsInCartImageView;
            private int id;


            public ViewHolder(View v) {
                super(v);
//            super(inflater.inflate(R.layout.item_glass, parent, false));

                itemPriceTextView = itemView.findViewById(R.id.item_serv_time);
                itemFactoryTextView = itemView.findViewById(R.id.item_cart_factory);
                itemInsertPriceTextView = itemView.findViewById(R.id.item_cart_price);
                itemtypeTextView = itemView.findViewById(R.id.item_type_title);
                itemIsInCartImageView = itemView.findViewById(R.id.item_cart_added);
                itemIsInCartImageView.setOnClickListener(this);
                itemIsInCartImageView.setTag(R.id.item_cart_added);

            }

            public void bind(int position) {
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
                int id =elements.get(getLayoutPosition()).getId();
                String toast;
                if (tag == R.id.item_cart_added) {
                    if (elements.get(getLayoutPosition()).isSelected()) {
                        elements.get(getLayoutPosition()).setSelected(false);

                        int pos = getPosById(id, selectedElements);
                        if (pos!=-1) {
                            selectedElements.remove(pos);
                        }
                        toast = "удалено из корзины";
                    } else {
                        elements.get(getLayoutPosition()).setSelected(true);
                        selectedElements.add(elements.get(getLayoutPosition()));

                        toast = "добавлено в корзину";
                    }
                    listUpdateListener.update();
                   // Toast.makeText(view.getContext(), toast, Toast.LENGTH_SHORT).show();
                    notifyDataSetChanged();
                }
            }
        }

        int getPosById(int id, List<Product> list){
            for (int i = 0; i < list.size(); i++) {
                if (list.get(i).getId()==id){
                    return i;
                }
            }
            return -1;
        }

    }


