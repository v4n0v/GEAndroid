package com.example.v4n0v.geandroid;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

public class AboutActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTheme (R.style.ThemeStandart);
        setContentView(R.layout.activity_about);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
                final CollapsingToolbarLayout layout = findViewById(R.id.toolbar_layout);
                AppBarLayout.LayoutParams params = (AppBarLayout.LayoutParams) layout.getLayoutParams();

                params.setScrollFlags(AppBarLayout.LayoutParams.SCROLL_FLAG_SCROLL|
                        AppBarLayout.LayoutParams.SCROLL_FLAG_ENTER_ALWAYS|
                        AppBarLayout.LayoutParams.SCROLL_FLAG_ENTER_ALWAYS_COLLAPSED);

                layout.setLayoutParams(params);
            }
        });
    }

    public void returnDefaultFlag(View view) {
        final CollapsingToolbarLayout layout = findViewById(R.id.toolbar_layout);
        AppBarLayout.LayoutParams params = (AppBarLayout.LayoutParams) layout.getLayoutParams();

                    params.setScrollFlags(AppBarLayout.LayoutParams.SCROLL_FLAG_SCROLL|
                    AppBarLayout.LayoutParams.SCROLL_FLAG_ENTER_ALWAYS);
//
        layout.setLayoutParams(params);

    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent(AboutActivity.this, MainActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
    }

}
