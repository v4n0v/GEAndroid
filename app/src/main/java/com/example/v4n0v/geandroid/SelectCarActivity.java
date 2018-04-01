package com.example.v4n0v.geandroid;

import android.os.Bundle;

import android.support.v7.widget.Toolbar;

import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import com.arellomobile.mvp.MvpAppCompatActivity;
import com.arellomobile.mvp.presenter.InjectPresenter;
import com.arellomobile.mvp.presenter.ProvidePresenter;
import com.example.v4n0v.geandroid.presenters.SelectCarPresenter;

import butterknife.BindView;
import butterknife.ButterKnife;

public class SelectCarActivity extends MvpAppCompatActivity implements SelectCarView{
    // todo когда вводится текст, должен фильтроваться список
    @BindView(R.id.select_mark_edittext) EditText selectMarkEditText;
    @BindView(R.id.select_mark_list_view) ListView selectMarkListView;
    @BindView(R.id.mark_text) TextView selectMarkTextView;
    @BindView(R.id.car_toolbar) Toolbar toolbar;

    @InjectPresenter
    SelectCarPresenter presenter;

    @ProvidePresenter
    public SelectCarPresenter provideMainPresenter() {
        String string = "hello";
        return new SelectCarPresenter(string);
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_car);
        setSupportActionBar(toolbar);
        ButterKnife.bind(this);

        init();
    }

    @Override
    public void init() {
        presenter.initMarksList();
    }

    @Override
    public void fillMarksList(String string){
        selectMarkTextView.setText(string);
   }


}
