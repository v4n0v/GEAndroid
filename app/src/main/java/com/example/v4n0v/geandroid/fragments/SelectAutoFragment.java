package com.example.v4n0v.geandroid.fragments;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.v4n0v.geandroid.Order;
import com.example.v4n0v.geandroid.R;
import com.example.v4n0v.geandroid.recycler_adapters.RecyclerOrderAdapter;

import java.text.SimpleDateFormat;
import java.util.List;

public class SelectAutoFragment extends Fragment {
    private RecyclerView recyclerView;
    private RecyclerOrderAdapter adapter;
//    MyAdapter adapter;
    public List<Order> getOrderList() {
        return orderList;
    }

    public void setOrderList(List<Order> orderList) {
        this.orderList = orderList;
    }
   private  View view;
    private List<Order> orderList;
    private SimpleDateFormat dateFormat ;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_orders, container, false);
        initViews();
        addItem();
        return view;
    }


    private void initViews() {


        initRecyclerView();


    }
    public  void addItem(){
        orderList.add(new Order(1000 + (int) (Math.random() * 40000)));
        adapter.notifyDataSetChanged();
    }

    public void  initRecyclerView(){
        recyclerView=view.findViewById(R.id.recycler_cart);

        recyclerView.setHasFixedSize(true);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity().getApplicationContext());
        recyclerView.setLayoutManager(layoutManager);

         adapter = new RecyclerOrderAdapter(orderList);

        recyclerView.setAdapter(adapter);

    }



}
