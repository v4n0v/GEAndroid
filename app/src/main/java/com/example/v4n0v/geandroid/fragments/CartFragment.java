package com.example.v4n0v.geandroid.fragments;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.example.v4n0v.geandroid.R;
import com.example.v4n0v.geandroid.custom.SpaceItemDecorator;
import com.example.v4n0v.geandroid.goods.Product;
import com.example.v4n0v.geandroid.recycler_adapters.RecyclerCartAdapter;

import java.util.List;

public class CartFragment extends Fragment
        implements View.OnClickListener{

    public static CartFragment newInstance(Bundle bundle) {
        CartFragment currentFragment = new CartFragment();
        Bundle args = new Bundle();
        args.putBundle("gettedArgs", bundle);
        currentFragment.setArguments(args);
        return currentFragment;
    }


    private RecyclerView recyclerView;
//    RecyclerCartAdapter adapter;
    RecyclerCartAdapter adapter;
    public void setElements(List<Product> elements) {
        this.elements = elements;
    }

    private List<Product> elements;
    Button btnCreateOrder;
    float total;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_cart, container, false);

        initViews(view);



        return view;
    }

    private void createOrder(){
        Toast.makeText(getActivity(), "Оформление заказа", Toast.LENGTH_SHORT).show();
    }

    private void totalCounter(){
        total=0;
        for (Product product :elements){
            if (product.isSelected()){
                total+= product.getPrice();
            }
        }

    }

    private void initViews(View view) {
//        btnCreateOrder=view.findViewById(R.id.btn_create_order);
//         btnCreateOrder.setOnClickListener(this);

        recyclerView=view.findViewById(R.id.recycler_cart);

        recyclerView.setHasFixedSize(true);
        int numberOfColumns = 1;
        recyclerView.setLayoutManager(new GridLayoutManager(getActivity().getApplicationContext(), numberOfColumns));
//        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity().getApplicationContext());
        GridLayoutManager layoutManager = new GridLayoutManager(getActivity().getApplicationContext(),numberOfColumns);


        int spacingInPixels = 10;
        recyclerView.addItemDecoration(new SpaceItemDecorator(spacingInPixels));
        recyclerView.setLayoutManager(layoutManager);


        adapter = RecyclerCartAdapter.getInstance();
        adapter.setElements(elements);

        recyclerView.setAdapter(adapter);
    }

    public void refresh() {
        adapter.notifyDataSetChanged();
    }

//
//
    @Override
    public void onClick(View view) {

        if (elements.size()>0) {
           createOrder();
        } else {
            Toast.makeText(getActivity(), "Выбирите товар", Toast.LENGTH_SHORT).show();
        }
    }


}
