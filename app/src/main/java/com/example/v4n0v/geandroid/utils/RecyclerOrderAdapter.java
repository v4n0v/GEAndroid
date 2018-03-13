package com.example.v4n0v.geandroid.utils;

import android.app.Activity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.v4n0v.geandroid.Order;
import com.example.v4n0v.geandroid.R;

import java.text.SimpleDateFormat;
import java.util.List;


public class RecyclerOrderAdapter extends RecyclerView.Adapter<RecyclerOrderAdapter.ViewHolder> {

    private List<Order> elements;

    SimpleDateFormat dateFormat = new SimpleDateFormat("dd MM' at ' HH:mm");


    public RecyclerOrderAdapter(List<Order> elements) {
        this.elements = elements;

    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(viewGroup.getContext());
        return new ViewHolder(inflater, viewGroup);
    }

    @Override
    public void onBindViewHolder(RecyclerOrderAdapter.ViewHolder viewHolder, int position) {
        viewHolder.bind(position);

    }

    @Override
    public int getItemCount() {
        return (null != elements ? elements.size() : 0);
    }

    /**
     * View holder to display each RecylerView itemDate
     */
    protected class ViewHolder extends RecyclerView.ViewHolder  implements View.OnLongClickListener{
        private TextView itemDate;
        private TextView itemHeader;
        private TextView itemSumm;

        public ViewHolder(LayoutInflater inflater, ViewGroup parent) {
            super(inflater.inflate(R.layout.item_order, parent, false));
            itemView.setOnLongClickListener(this);
            itemHeader = (TextView) itemView.findViewById(R.id.order_header);
            itemDate = (TextView) itemView.findViewById(R.id.order_date);
            itemSumm = (TextView) itemView.findViewById(R.id.order_summ);
        }

        void bind(int position) {
            if (elements.size() > 0) {
                itemDate.setText(dateFormat.format(elements.get(position).getDate()));
                itemHeader.setText("Заказ №"+(position+1));
                itemSumm.setText(String.valueOf(elements.get(position).getSumm())+"p");
            }
        }



        @Override
        public boolean onLongClick(View view) {
            Toast.makeText(view.getContext(), itemHeader.getText()+" удален", Toast.LENGTH_SHORT).show();
            elements.remove(getLayoutPosition());
            notifyDataSetChanged();
            return false;
        }
    }




}