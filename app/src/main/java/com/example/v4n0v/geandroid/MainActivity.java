package com.example.v4n0v.geandroid;

import android.app.AlertDialog;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Context;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomSheetBehavior;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Switch;
import android.widget.Toast;

import com.example.v4n0v.geandroid.fragments.MyOrderFragment;
import com.example.v4n0v.geandroid.fragments.RegisterFragment;
import com.example.v4n0v.geandroid.fragments.SelectGlassFragment;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    FloatingActionButton fab;
    BottomSheetBehavior<View> sheetBehavior;
    SelectGlassFragment selectGlassFragment;
    RegisterFragment registerFragment;
    Toolbar toolbar;
    ImageView bottomPicker;
    FragmentManager fragmentManager;
    FragmentTransaction fragmentTransaction;
    MyOrderFragment orderFragment;
    DrawerLayout drawer;
    SharedPreferences sharedPreferences;
    ImageView bottomIco;
    NavigationView navigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        selectGlassFragment = new SelectGlassFragment();


        initUI();
        initTollbar();
        initFAB();
        showElementsUI();

        applyColors();
        fillFragment(selectGlassFragment);

        drawer = findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();


        navigationView.setNavigationItemSelectedListener(this);

    }


    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
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
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    private void initTollbar() {

        toolbar = findViewById(R.id.my_toolbar);
        setSupportActionBar(toolbar);
    }

    private void initUI() {
        navigationView = (NavigationView) findViewById(R.id.nav_view);
        View bottomView = findViewById(R.id.bottom_sheet);
        sheetBehavior = BottomSheetBehavior.from(bottomView);
        sheetBehavior.setState(BottomSheetBehavior.STATE_COLLAPSED);
        bottomIco = findViewById(R.id.bottom_header_ico);
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
                    int colorIntText = getResources().getColor(R.color.colorWhite);
                    int colorIntIco = getResources().getColor(R.color.colorWhite);
                    ed.putBoolean(Preferences.NAV_THEME_DARK, false);
                }

                ed.apply();
                applyColors();
            }
        });
        builder.show();
    }


    void applyColors() {
        sharedPreferences = getSharedPreferences(Preferences.APP_PREFERENCES, Context.MODE_PRIVATE);

        boolean isDarkTheme = sharedPreferences.getBoolean(Preferences.NAV_THEME_DARK, false);
        int colorIntText;
        int colorIntIco;
        Drawable grad;
        if (isDarkTheme) {
            colorIntText = getResources().getColor(R.color.colorWhite);
            colorIntIco = getResources().getColor(R.color.colorWhite);
            grad = getResources().getDrawable(R.drawable.side_nav_bar_black);
        } else {
            grad = getResources().getDrawable(R.drawable.side_nav_bar_green);
            colorIntText = getResources().getColor(R.color.colorDarkGray);
            colorIntIco = getResources().getColor(R.color.colorDarkGray);
        }


        LinearLayout navGrad = findViewById(R.id.nav_gradient);


        ColorStateList csl = ColorStateList.valueOf(colorIntText);
        navigationView.setItemTextColor(csl);
        navigationView.setItemIconTintList(csl);



    }


    public void saveCar(View view) {
        Toast.makeText(MainActivity.this, "Сохранение данных об авто", Toast.LENGTH_SHORT).show();
        // Snackbar.make(view, "Сохранение данных об авто", Snackbar.LENGTH_SHORT).show();
        sheetBehavior.setState(BottomSheetBehavior.STATE_COLLAPSED);
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.nav_new_order) {
            Toast.makeText(MainActivity.this, "Новый заказ", Toast.LENGTH_SHORT).show();
            showElementsUI();
            fillFragment(selectGlassFragment);


        } else if (id == R.id.nav_my_orders) {
            if (orderFragment == null) {
                orderFragment = new MyOrderFragment();
            }

            hideElementsUI();

            fillFragment(orderFragment);
            Toast.makeText(MainActivity.this, "Мои заказы", Toast.LENGTH_SHORT).show();
        } else if (id == R.id.nav_registration) {

//            Intent intent1 = new Intent(MainActivity.this,RegisterActivity.class);
//            startActivity(intent1);


            if (registerFragment == null) {
                registerFragment = new RegisterFragment();
            }
            hideElementsUI();
            fillFragment(registerFragment);
            navigationView.setCheckedItem(R.id.nav_registration);

        } else if (id == R.id.nav_share) {
            Toast.makeText(MainActivity.this, "Поделиться", Toast.LENGTH_SHORT).show();
        }

        drawer.closeDrawer(GravityCompat.START);
        return true;
    }


    void hideElementsUI() {
        sheetBehavior.setHideable(true);
        sheetBehavior.setState(BottomSheetBehavior.STATE_HIDDEN);
        fab.hide();
        bottomIco.setVisibility(View.INVISIBLE);
    }

    void showElementsUI() {
        sheetBehavior.setHideable(false);
        sheetBehavior.setState(BottomSheetBehavior.STATE_COLLAPSED);
        fab.show();
        bottomIco.setVisibility(View.VISIBLE);
    }

    void fillFragment(Fragment fragment) {
        fragmentManager = getFragmentManager();
        fragmentTransaction = fragmentManager.beginTransaction();
        //   SelectGlassFragment fragment = new SelectGlassFragment();
        fragmentTransaction.replace(R.id.container_frame, fragment);
        fragmentTransaction.commit();
    }

}
