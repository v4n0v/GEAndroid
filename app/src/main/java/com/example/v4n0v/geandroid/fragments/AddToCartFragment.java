package com.example.v4n0v.geandroid.fragments;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.example.v4n0v.geandroid.Product;
import com.example.v4n0v.geandroid.R;
import com.example.v4n0v.geandroid.recycler_adapters.RecyclerCartAdapter;
import com.example.v4n0v.geandroid.custom.SpaceItemDecorator;

import java.util.ArrayList;
import java.util.List;


public class AddToCartFragment extends Fragment implements View.OnClickListener{
    private RecyclerView recyclerView;
    RecyclerCartAdapter adapter;
    private List<Product> elements;
    Button btnCreateOrder;
    float total;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.add_to_cart_fragment, container, false);


        elements = new ArrayList<>();
        Product product1 = new Product("Спектргласс", "Лобовое",2000, 1500);
        Product product2 = new Product("XYG","Лобовое", 1000, 1250);
        Product product3 = new Product("Спектргласс", "Заднее",2500, 1000);
        elements.add(product1);
        elements.add(product2);
        elements.add(product3);
        elements.add(product3);
        initViews(view);

        return view;
    }

    private void createOrder(){
        Toast.makeText(getActivity(), "Оформление заказа", Toast.LENGTH_SHORT).show();
    }

    private void totalCounter(){
        total=0;
        for (Product product:elements){
            if (product.isSelected()){
                total+=product.getPrice();
            }
        }

    }

    private void initViews(View view) {
        btnCreateOrder=view.findViewById(R.id.btn_create_order);
        btnCreateOrder.setOnClickListener(this);

        recyclerView=view.findViewById(R.id.recycler_cart);

        recyclerView.setHasFixedSize(true);
        int numberOfColumns = 1;
        recyclerView.setLayoutManager(new GridLayoutManager(getActivity().getApplicationContext(), numberOfColumns));
//        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity().getApplicationContext());
        GridLayoutManager layoutManager = new GridLayoutManager(getActivity().getApplicationContext(),numberOfColumns);


        int spacingInPixels = 10;
        recyclerView.addItemDecoration(new SpaceItemDecorator(spacingInPixels));
         recyclerView.setLayoutManager(layoutManager);


        adapter = new RecyclerCartAdapter(elements);

        recyclerView.setAdapter(adapter);
    }



    @Override
    public void onClick(View view) {
        int cnt=0;
        for (Product product:elements){
            if (product.isSelected()) cnt++;
        }

        if (cnt>0) {
           createOrder();
        } else {
            Toast.makeText(getActivity(), "Выбирите товар", Toast.LENGTH_SHORT).show();
        }
    }
}
