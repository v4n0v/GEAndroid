package com.example.v4n0v.geandroid;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.design.widget.TabLayout;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.example.v4n0v.geandroid.custom.CustomFragmentPA;
import com.example.v4n0v.geandroid.data.Preferences;
import com.example.v4n0v.geandroid.fragments.AddToCartFragment;
import com.example.v4n0v.geandroid.fragments.CartFragment;
import com.example.v4n0v.geandroid.fragments.FragmentTemp;
import com.example.v4n0v.geandroid.goods.Glass;
import com.example.v4n0v.geandroid.goods.Product;
import com.example.v4n0v.geandroid.goods.Service;

import java.util.ArrayList;
import java.util.List;

public class ProductsActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    final String TAG = "ProductsActivity";

    AddToCartFragment addToCartFragment;
    CartFragment cartFragment;


    /**
     * The {@link android.support.v4.view.PagerAdapter} that will provide
     * fragments for each of the sections. We use a
     * {@link FragmentPagerAdapter} derivative, which will keep every
     * loaded fragment in memory. If this becomes too memory intensive, it
     * may be best to switch to a
     * {@link android.support.v4.app.FragmentStatePagerAdapter}.
     */
    // private SectionsPagerAdapter mSectionsPagerAdapter;

    /**
     * The {@link ViewPager} that will host the section contents.
     */
    private ViewPager mViewPager;
    CustomFragmentPA customFragmentPA;

    List<Glass> elements;
    List<Service> serviceElements;
    List<Product> selectedElements;
    Toolbar toolbar;
    FragmentTemp fragmentTemp;
    SharedPreferences sharedPreferences;
DrawerLayout drawer;

    NavigationView navigationView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        applyTheme();
        setContentView(R.layout.activity_products);
        initTollbar();
        String addition = getResources().getString(R.string.my_orders);
       // String title = getResources().getString(R.string.app_name) + ": ";
        toolbar.setTitle(addition);
        elements = new ArrayList<>();
        serviceElements=new ArrayList<>();
        selectedElements = new ArrayList<>();

        Glass glass1 = new Glass(100, "Спектргласс", "Лобовое", 2000, 1500);
        Glass glass2 = new Glass(101, "XYG", "Лобовое", 1000, 1250);
        Glass glass3 = new Glass(102, "Спектргласс", "Заднее", 2500, 1000);
        Glass glass4 = new Glass(103, "Спектргласс", "Боковое", 2550, 1000);
        Glass glass5 = new Glass(105, "Спектргласс", "Заднее", 3500, 1000);
        Glass glass6 = new Glass(106, "XYG", "Заднее", 3500, 1000);

        elements.add(glass1);
        elements.add(glass2);
        elements.add(glass3);
        elements.add(glass4);
        elements.add(glass5);
        elements.add(glass6);

        Service service1 = new Service(10, "Засверлить скол", 1000, 30);
        Service service2 = new Service(11, "Протереть пыль", 5000, 10);
        Service service3 = new Service(12, "Разбить лобарь", 1000, 2);

        serviceElements.add(service1);
        serviceElements.add(service2);
        serviceElements.add(service3);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        customFragmentPA = new CustomFragmentPA(getSupportFragmentManager());
        // initViewPager();
        initFragments();

        // Set up the ViewPager with the sections adapter.
        mViewPager = (ViewPager) findViewById(R.id.container_tabs);
        mViewPager.setAdapter(customFragmentPA);

        TabLayout tabLayout = findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(mViewPager);

        mViewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
        tabLayout.addOnTabSelectedListener(new TabLayout.ViewPagerOnTabSelectedListener(mViewPager));
        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                Log.e(TAG, "onTabSelected: " + tab.getText());


            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
                Log.w(TAG, "onTabUnselected: " + tab.getText());
            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {
                Log.i(TAG, "onTabReselected: " + tab.getText());
            }
        });

//        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab_products);
//        fab.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                if (elements.size()>0) {
//                    createOrder();
//                } else {
//                    Toast.makeText(getApplicationContext(), "Выбирите товар", Toast.LENGTH_SHORT).show();
//                }
//            }
//        });

        drawer = findViewById(R.id.drawer_layout_products);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }
    private void initTollbar() {
     //   bottomIco = findViewById(R.id.bottom_header_ico);
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
    }
    private void initFragments() {

        fragmentTemp = FragmentTemp.newInstance(null);
        fragmentTemp.setLists(elements, serviceElements, selectedElements);

        cartFragment = CartFragment.newInstance(null);
        cartFragment.setElements(selectedElements);

        customFragmentPA.addFragment(fragmentTemp, "Товары");
        customFragmentPA.addFragment(cartFragment, "Корзина");
    }
    void applyTheme() {
        sharedPreferences = getSharedPreferences(Preferences.APP_PREFERENCES, Context.MODE_PRIVATE);
        boolean isDarkTheme = sharedPreferences.getBoolean(Preferences.NAV_THEME_DARK, false);
        if (isDarkTheme) {
            setTheme (R.style.ThemeStandart);
        } else {
            setTheme (R.style.ThemeStandart_Green);
        }
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_products, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void createOrder(MenuItem item) {
        if (selectedElements.size()>0)
        Toast.makeText(this, "Оформление заказа", Toast.LENGTH_SHORT).show();
        else
            Toast.makeText(this, "Выбирите товар", Toast.LENGTH_SHORT).show();
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        String title= getResources().getString(R.string.app_name)+": ";
        String addition = null;
        if (id == R.id.nav_new_order) {
            Intent intent1 = new Intent(ProductsActivity.this, MainActivity.class);
            intent1.putExtra("nav", "new_order");
            startActivity(intent1);

        } else if (id == R.id.nav_my_orders) {


        } else if (id == R.id.nav_registration) {
            Intent intent1 = new Intent(ProductsActivity.this, MainActivity.class);
            intent1.putExtra("nav", "reg");
            startActivity(intent1);


        } else if (id == R.id.nav_share) {
            Toast.makeText(ProductsActivity.this, "Поделиться", Toast.LENGTH_SHORT).show();

        } else if (id == R.id.nav_about) {
            Intent intent1 = new Intent(ProductsActivity.this, AboutActivity.class);

            startActivity(intent1);

        }
       // title+= addition;
        toolbar.setTitle(addition);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
