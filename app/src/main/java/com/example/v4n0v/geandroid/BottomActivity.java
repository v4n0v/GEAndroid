package com.example.v4n0v.geandroid;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.example.v4n0v.geandroid.fragments.AddToCartFragment;
import com.example.v4n0v.geandroid.fragments.CartFragment;
import com.example.v4n0v.geandroid.fragments.ServiceFragment;
import com.example.v4n0v.geandroid.goods.Glass;
import com.example.v4n0v.geandroid.goods.Product;
import com.example.v4n0v.geandroid.goods.Service;

import java.util.ArrayList;
import java.util.List;

public class BottomActivity extends AppCompatActivity {

    private TextView mTextMessage;

    AddToCartFragment addToCartFragment;
    CartFragment cartFragment;
    FragmentManager fragmentManager;
    FrameLayout container;
    ServiceFragment serviceFragment;
    FragmentTransaction fragmentTransaction;

    List<Glass> elements;
    List<Service> serviceElements;
    List<Product> selectedElements;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_products:
                    mTextMessage.setText("Товары");

                    fillFrgment(addToCartFragment);
                    return true;
                case R.id.navigation_services:

                    mTextMessage.setText("Услуги");
                    fillFrgment(serviceFragment);
                    return true;

            }
            return false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bottom);

        elements = new ArrayList<>();
        serviceElements=new ArrayList<>();
        selectedElements=new ArrayList<>();

        Glass glass1 = new Glass(100,"Спектргласс", "Лобовое",2000, 1500);
        Glass glass2 = new Glass(101, "XYG","Лобовое", 1000, 1250);
        Glass glass3 = new Glass(102, "Спектргласс", "Заднее",2500, 1000);

        Service service1 = new Service(10, "Засверлить скол", 1000, 30);
        Service service2 = new Service(11, "Протереть пыль", 5000, 10);
        Service service3 = new Service(12, "Разбить лобарь", 1000, 2);
        elements.add(glass1);
        elements.add(glass2);
        elements.add(glass3);

        serviceElements.add(service1);
        serviceElements.add(service2);
        serviceElements.add(service3);

        initViews();
        initFragments();

        fillFrgment(addToCartFragment);
        mTextMessage = (TextView) findViewById(R.id.message);
        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
    }

    void initViews() {
        container = findViewById(R.id.frame_bottom_container);
    }

    private void initFragments() {
        addToCartFragment = AddToCartFragment.newInstance(null);
        addToCartFragment.setElements(elements, selectedElements);
        cartFragment = CartFragment.newInstance(null);

        serviceFragment=ServiceFragment.newInstance(null);
        serviceFragment.setElements(serviceElements, selectedElements);
        fragmentManager = getSupportFragmentManager();
    }


    void fillFrgment(Fragment fragment){
        fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.frame_bottom_container, fragment);
        fragmentTransaction.commit();
    }

}
