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

import com.example.v4n0v.geandroid.R;
import com.example.v4n0v.geandroid.custom.SpaceItemDecorator;
import com.example.v4n0v.geandroid.goods.Product;
import com.example.v4n0v.geandroid.goods.Service;
import com.example.v4n0v.geandroid.recycler_adapters.RecycleServiceAdapter;

import java.util.List;

/**
 * Created by v4n0v on 16.03.18.
 */

public class ServiceFragment extends Fragment {
//        implements View.OnClickListener{

    public static ServiceFragment newInstance(Bundle bundle) {
        ServiceFragment currentFragment = new ServiceFragment();
        Bundle args = new Bundle();
        args.putBundle("gettedArgs", bundle);
        currentFragment.setArguments(args);
        return currentFragment;
    }


    public void setElements(List<Service> elements, List<Product> selectedElements) {
        this.elements = elements;
        this.selectedElements = selectedElements;
    }

    private RecyclerView recyclerView;
    RecycleServiceAdapter adapter;


    private List<Service> elements;
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
        for (Service service :elements){
            if (service.isSelected()){
                total+= service.getPrice();
            }
        }

    }

    private void initViews(View view) {

        recyclerView=view.findViewById(R.id.recycler_cart);

        recyclerView.setHasFixedSize(true);
        int numberOfColumns = 1;
        recyclerView.setLayoutManager(new GridLayoutManager(getActivity().getApplicationContext(), numberOfColumns));
//        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity().getApplicationContext());
        GridLayoutManager layoutManager = new GridLayoutManager(getActivity().getApplicationContext(),numberOfColumns);


        int spacingInPixels = 10;
        recyclerView.addItemDecoration(new SpaceItemDecorator(spacingInPixels));
        recyclerView.setLayoutManager(layoutManager);


        adapter = new RecycleServiceAdapter(elements, selectedElements);

        recyclerView.setAdapter(adapter);
    }


//
//    @Override
//    public void onClick(View view) {
//        int cnt=0;
//        for (Glass product:productsElements){
//            if (product.isSelected()) cnt++;
//        }
//
//        if (cnt>0) {
//           createOrder();
//        } else {
//            Toast.makeText(getActivity(), "Выбирите товар", Toast.LENGTH_SHORT).show();
//        }
//    }
}
