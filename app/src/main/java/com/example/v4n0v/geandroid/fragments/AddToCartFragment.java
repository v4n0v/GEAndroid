package com.example.v4n0v.geandroid.fragments;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.example.v4n0v.geandroid.goods.Glass;
import com.example.v4n0v.geandroid.R;
import com.example.v4n0v.geandroid.custom.SpaceItemDecorator;
import com.example.v4n0v.geandroid.goods.Product;
import com.example.v4n0v.geandroid.recycler_adapters.RecyclerProductsAdaper;

import java.util.List;


public class AddToCartFragment extends Fragment{
//        implements View.OnClickListener{

    public static AddToCartFragment newInstance(Bundle bundle) {
        AddToCartFragment currentFragment = new AddToCartFragment();
        Bundle args = new Bundle();
        args.putBundle("gettedArgs", bundle);
        currentFragment.setArguments(args);
        return currentFragment;
    }


    public void setElements(List<Glass> elements, List<Product> selectedElements) {
        this.elements = elements;
        this.selectedElements = selectedElements;
    }

    RecyclerProductsAdaper adapter;
    private List<Glass> elements;
    private List<Product> selectedElements;

    float total;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_products, container, false);
        initViews(view);
        return view;
    }

    private void createOrder(){
        Toast.makeText(getActivity(), "Оформление заказа", Toast.LENGTH_SHORT).show();
    }

    private void totalCounter(){
        total=0;
        for (Glass glass :elements){
            if (glass.isSelected()){
                total+= glass.getPrice();
            }
        }

    }

    private void initViews(View view) {

        RecyclerView recyclerView = view.findViewById(R.id.recycler_cart);

        recyclerView.setHasFixedSize(true);
        int numberOfColumns = 1;
        recyclerView.setLayoutManager(new GridLayoutManager(getActivity().getApplicationContext(), numberOfColumns));
//        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity().getApplicationContext());
        GridLayoutManager layoutManager = new GridLayoutManager(getActivity().getApplicationContext(),numberOfColumns);


        int spacingInPixels = 10;
        recyclerView.addItemDecoration(new SpaceItemDecorator(spacingInPixels));
        recyclerView.setLayoutManager(layoutManager);


        adapter = new RecyclerProductsAdaper(elements, selectedElements);

        recyclerView.setAdapter(adapter);
    }

}
