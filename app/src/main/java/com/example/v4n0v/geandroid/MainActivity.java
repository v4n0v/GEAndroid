package com.example.v4n0v.geandroid;

import android.app.AlertDialog;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.ColorStateList;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomSheetBehavior;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.Switch;
import android.widget.Toast;

import com.example.v4n0v.geandroid.data.Preferences;
import com.example.v4n0v.geandroid.fragments.AddToCartFragment;
import com.example.v4n0v.geandroid.fragments.RegisterFragment;
import com.example.v4n0v.geandroid.fragments.SelectAutoFragment;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    FloatingActionButton fab;
    BottomSheetBehavior<View> sheetBehavior;
    SelectAutoFragment selectAutoFragment;
    RegisterFragment registerFragment;
    Toolbar toolbar;
    ImageView bottomPicker;
    FragmentManager fragmentManager;
    FragmentTransaction fragmentTransaction;
    AddToCartFragment orderFragment;
    DrawerLayout drawer;
    SharedPreferences sharedPreferences;

    NavigationView navigationView;
    private ImageView bottomIco;
    private List<Order> orderList;


    String TAG = "MyTag";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       // setTheme (R.style.ThemeStandart_Green);
        applyTheme();
        init();
        applyColors();
    }

    private void init(){ setContentView(R.layout.activity_main);

        selectAutoFragment = new SelectAutoFragment();
        orderList = new ArrayList<>();
        initUI();
        initTollbar();
        initFAB();
        showElementsUI();

        toolbar.setTitle( getResources().getString(R.string.orders));
        Intent intent = getIntent();
        if (intent != null) {
            String target = intent.getStringExtra("nav");
            if (target != null) {
                switch (target) {
                    case "new_order":
                        fillFragment(selectAutoFragment);
                        break;
                    case "reg":
                        if (registerFragment == null) {
                            registerFragment = new RegisterFragment();
                        }
                        toolbar.setTitle( getResources().getString(R.string.registration));
                        fillFragment(registerFragment);
                        hideElementsUI();
                        break;
                    default:
                        break;
                }

            }else {

                Log.d(TAG, "target = null");
                fillFragment(selectAutoFragment);
            }

        } else {
            Log.d(TAG, "intent = null");
            fillFragment(selectAutoFragment);
        }

        selectAutoFragment.setOrderList(orderList);




        // fillFragment(selectAutoFragment);

        drawer = findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();


        navigationView.setNavigationItemSelectedListener(this);

    }

    @Override
    public void onBackPressed() {

        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    private void initFAB() {
        fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                selectAutoFragment.addItem();
            }
        });
    }

    private void initTollbar() {
        bottomIco = findViewById(R.id.bottom_header_ico);
        toolbar = findViewById(R.id.my_toolbar);
        setSupportActionBar(toolbar);
    }

    private void initUI() {
        navigationView = (NavigationView) findViewById(R.id.nav_view);
        View bottomView = findViewById(R.id.bottom_sheet);
        sheetBehavior = BottomSheetBehavior.from(bottomView);
        sheetBehavior.setState(BottomSheetBehavior.STATE_COLLAPSED);

        sheetBehavior.setBottomSheetCallback(new BottomSheetBehavior.BottomSheetCallback() {
            @Override
            public void onStateChanged(@NonNull View bottomSheet, int newState) {
                // этот код скрывает кнопку сразу же
// и отображает после того как нижний экран полностью свернется

                if (BottomSheetBehavior.STATE_DRAGGING == newState) {
                    fab.animate().scaleX(0).scaleY(0).setDuration(300).start();
                } else if (BottomSheetBehavior.STATE_COLLAPSED == newState) {

                    fab.animate().scaleX(1).scaleY(1).setDuration(300).start();
                }
            }

            @Override
            public void onSlide(@NonNull View bottomSheet, float slideOffset) {
                // fab.animate().scaleX(1 - slideOffset).scaleY(1 - slideOffset).setDuration(0).start();
            }

        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
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

    public void showRegistrationActivity(MenuItem item) {
        final AlertDialog.Builder builder = new AlertDialog.Builder(this);
        LayoutInflater li = LayoutInflater.from(this);
        builder.setTitle(R.string.action_settings);
        final View additionView = li.inflate(R.layout.options_layout, null);

        // получаю настройки, узнаю, какя тема выбрана
        sharedPreferences = getSharedPreferences(Preferences.APP_PREFERENCES, Context.MODE_PRIVATE);
        final SharedPreferences.Editor ed = sharedPreferences.edit();
        builder.setView(additionView);
        builder.setCancelable(true);

        // переключаю в выбранное состояние
        boolean isSwitched = sharedPreferences.getBoolean(Preferences.NAV_THEME_DARK, false);
        if (isSwitched) {
            Switch themeSwitch = additionView.findViewById(R.id.switch_theme);
            themeSwitch.setChecked(true);
        }

        builder.setPositiveButton("Save", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                final Switch themeSwitch = additionView.findViewById(R.id.switch_theme);
                if (themeSwitch.isChecked()) {
                    Toast.makeText(MainActivity.this, "Теменая тема", Toast.LENGTH_SHORT).show();
                    ed.putBoolean(Preferences.NAV_THEME_DARK, true);


                } else {
                    Toast.makeText(MainActivity.this, "Светлая тема", Toast.LENGTH_SHORT).show();
                    ed.putBoolean(Preferences.NAV_THEME_DARK, false);
                }

                ed.apply();
                Intent reloadIntent = new Intent(MainActivity.this, MainActivity.class);
                startActivity(reloadIntent);
//
            }
        });
        builder.show();
    }


    void applyColors() {
        sharedPreferences = getSharedPreferences(Preferences.APP_PREFERENCES, Context.MODE_PRIVATE);

        boolean isDarkTheme = sharedPreferences.getBoolean(Preferences.NAV_THEME_DARK, false);
        int colorIntText;
        int colorIntIco;

        int colorBG;
        int colorGroupText;
        if (isDarkTheme) {
            colorIntText = getResources().getColor(R.color.colorWhite);
            colorBG = getResources().getColor(R.color.colorDarkGray);
            colorGroupText = getResources().getColor(R.color.colorGrayLight);

        } else {
            colorIntText = getResources().getColor(R.color.colorDarkGray);
            colorGroupText = getResources().getColor(R.color.colorGrayDark);
            colorBG = getResources().getColor(R.color.colorWhite);

        }

        MenuItem menuItem = navigationView.getMenu().getItem(4);
        SpannableString s = new SpannableString(menuItem.getTitle());
        s.setSpan(new ForegroundColorSpan(colorGroupText), 0, s.length(), 0);
        menuItem.setTitle(s);

        ColorStateList csl = ColorStateList.valueOf(colorIntText);
        navigationView.setItemTextColor(csl);
        navigationView.setItemIconTintList(csl);
        navigationView.setBackgroundColor(colorBG);
    //    init();

    }
    void applyTheme() {
        sharedPreferences = getSharedPreferences(Preferences.APP_PREFERENCES, Context.MODE_PRIVATE);
        boolean isDarkTheme = sharedPreferences.getBoolean(Preferences.NAV_THEME_DARK, false);
        int color;
        if (isDarkTheme) {
            setTheme (R.style.ThemeStandart);
            color=R.color.colorPrimaryDark;
        } else {
            setTheme (R.style.ThemeStandart_Green);
            color=R.color.colorPrimaryDarkGreen;
        }

        if (Build.VERSION.SDK_INT >= 21) {
            Window window = getWindow();
            // clear FLAG_TRANSLUCENT_STATUS flag:
            window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            // add FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS flag to the window
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            // finally change the color
            window.setStatusBarColor(getResources().getColor(color));
        }




    }

    public void saveCar(View view) {
        Toast.makeText(MainActivity.this, "Сохранение данных об авто", Toast.LENGTH_SHORT).show();
        // Snackbar.make(view, "Сохранение данных об авто", Snackbar.LENGTH_SHORT).show();
        sheetBehavior.setState(BottomSheetBehavior.STATE_COLLAPSED);
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        String title = getResources().getString(R.string.app_name) + ": ";
        String addition = null;
        if (id == R.id.nav_new_order) {
            addition = getResources().getString(R.string.orders);
            Toast.makeText(MainActivity.this, addition, Toast.LENGTH_SHORT).show();
            fillFragment(selectAutoFragment);
            showElementsUI();

        } else if (id == R.id.nav_my_orders) {

            Intent inten = new Intent(MainActivity.this, ProductsActivity.class);
            startActivity(inten);

        } else if (id == R.id.nav_registration) {

            if (registerFragment == null) {
                registerFragment = new RegisterFragment();
            }
            addition = getResources().getString(R.string.registration);
            Toast.makeText(MainActivity.this, addition, Toast.LENGTH_SHORT).show();
            fillFragment(registerFragment);

            hideElementsUI();
        } else if (id == R.id.nav_share) {
            Toast.makeText(MainActivity.this, "Поделиться", Toast.LENGTH_SHORT).show();

        } else if (id == R.id.nav_about) {
            Intent intent1 = new Intent(MainActivity.this, AboutActivity.class);
            startActivity(intent1);

        }

        toolbar.setTitle(addition);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }


    void hideElementsUI() {
        sheetBehavior.setHideable(true);
        sheetBehavior.setState(BottomSheetBehavior.STATE_HIDDEN);

        fab.setVisibility(View.INVISIBLE);
        bottomIco.setVisibility(View.INVISIBLE);
    }

    void showElementsUI() {
        sheetBehavior.setHideable(false);
        sheetBehavior.setState(BottomSheetBehavior.STATE_COLLAPSED);

        fab.setVisibility(View.VISIBLE);
        bottomIco.setVisibility(View.VISIBLE);
    }

    void fillFragment(Fragment fragment) {
        fragmentManager = getFragmentManager();
        fragmentTransaction = fragmentManager.beginTransaction();

        fragmentTransaction.replace(R.id.container_frame, fragment);
        fragmentTransaction.commit();
    }


}
