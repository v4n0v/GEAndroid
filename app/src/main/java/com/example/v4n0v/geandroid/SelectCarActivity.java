package com.example.v4n0v.geandroid;

import android.os.Bundle;

import android.support.v7.widget.Toolbar;

import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import com.arellomobile.mvp.MvpAppCompatActivity;
import com.arellomobile.mvp.presenter.InjectPresenter;
import com.example.v4n0v.geandroid.presenters.SelectCarPresenter;

import butterknife.BindView;
import butterknife.ButterKnife;

public class SelectCarActivity extends MvpAppCompatActivity implements SelectCarView{
    // todo когда вводится текст, должен фильтроваться список
    @BindView(R.id.select_mark_edittext)
    EditText selectMarkEditText;

    @BindView(R.id.select_mark_list_view)
    ListView selectMarkListView;
    @BindView(R.id.mark_text)
    TextView selectMarkTextView;

    @InjectPresenter
    SelectCarPresenter presenter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_car);
        Toolbar toolbar = (Toolbar) findViewById(R.id.car_toolbar);
        setSupportActionBar(toolbar);
        ButterKnife.bind(this);

        init();
    }

    @Override
    public void fillMarksList(String string){
        selectMarkTextView.setText(string);
   }

    @Override
    public void init() {
        presenter.initMarksList();
    }
}
