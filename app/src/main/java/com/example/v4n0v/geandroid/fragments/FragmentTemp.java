package com.example.v4n0v.geandroid.fragments;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;

import com.example.v4n0v.geandroid.R;
import com.example.v4n0v.geandroid.goods.Glass;
import com.example.v4n0v.geandroid.goods.Product;
import com.example.v4n0v.geandroid.goods.Service;

import java.util.List;


public class FragmentTemp extends Fragment {
    FragmentTransaction fragmentTransaction;
    FragmentManager fragmentManager;
    FrameLayout container;
    ServiceFragment serviceFragment;
    AddToCartFragment addToCartFragment;


    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_products:
                    fillInnerFragment(addToCartFragment);
                    return true;
                case R.id.navigation_services:
                    fillInnerFragment(serviceFragment);
                    return true;

            }
            return false;
        }
    };

    public static FragmentTemp newInstance(Bundle bundle) {
        FragmentTemp currentFragment = new FragmentTemp();
        Bundle args = new Bundle();
        args.putBundle("gettedArgs", bundle);
        currentFragment.setArguments(args);
        return currentFragment;
    }

    public void setLists(List<Glass> productsElements,
                         List<Service> serviceElements,
                         List<Product> selectedElements) {

        this.productsElements = productsElements;
        this.selectedElements = selectedElements;
        this.serviceElements = serviceElements;

    }


    List<Glass> productsElements;
    List<Service> serviceElements;
    List<Product> selectedElements;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_bottom, container, false);

        initViews(view);

        initFragments(view);
        fillInnerFragment(addToCartFragment);

        BottomNavigationView navigation = (BottomNavigationView) view.findViewById(R.id.navigation_inner);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

        return view;
    }

    private void initViews(View view) {

        container = view.findViewById(R.id.in_temp_container);

    }

    private void initFragments(View view) {
        addToCartFragment = AddToCartFragment.newInstance(null);
        addToCartFragment.setElements(productsElements, selectedElements);

        serviceFragment = ServiceFragment.newInstance(null);
        serviceFragment.setElements(serviceElements, selectedElements);
        fragmentManager = getChildFragmentManager();

    }

    void fillInnerFragment(Fragment fragment) {

        fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.in_temp_container, fragment);
        fragmentTransaction.commit();
    }

}
