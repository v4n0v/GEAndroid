package com.example.v4n0v.geandroid;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;

import com.example.v4n0v.geandroid.fragments.AddToCartFragment;
import com.example.v4n0v.geandroid.fragments.FragmentTemp;
import com.example.v4n0v.geandroid.fragments.ServiceFragment;
import com.example.v4n0v.geandroid.goods.Glass;
import com.example.v4n0v.geandroid.goods.Product;
import com.example.v4n0v.geandroid.goods.Service;

import java.util.ArrayList;
import java.util.List;

public class TempActivity extends AppCompatActivity {

    FragmentTemp fragmentTemp;
    FragmentTransaction fragmentTransaction;
    FragmentManager fragmentManager;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_temp);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        fragmentTemp=FragmentTemp.newInstance(null);
        fragmentManager = getSupportFragmentManager();
        fillOutFragment(fragmentTemp);





        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });



    }
    void fillOutFragment(Fragment fragment){
        fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.out_temp_container, fragment);
        fragmentTransaction.commit();
    }



}
