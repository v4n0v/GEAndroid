package com.example.v4n0v.geandroid.recycler_adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.v4n0v.geandroid.R;

import butterknife.BindView;
import butterknife.ButterKnife;


public class RecyclerSelectCarAdapter extends RecyclerView.Adapter<RecyclerSelectCarAdapter.ViewHolder> {


    IListPresenter presenter;

    public RecyclerSelectCarAdapter(IListPresenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_car, parent, false));
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.pos = position;
        presenter.bindView(holder);
    }

    @Override
    public int getItemCount() {
        return presenter.getViewCount();
    }

    class ViewHolder extends RecyclerView.ViewHolder implements IListCarRawView {
        int pos = -1;
        @BindView(R.id.car_title_tv)
        TextView carTitleTextView;

        ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        @Override
        public int getPos() {
            return pos;
        }

        @Override
        public void setText(String text) {
            carTitleTextView.setText(text);
        }
    }
}
