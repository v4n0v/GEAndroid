package com.example.v4n0v.geandroid;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.arellomobile.mvp.MvpAppCompatActivity;
import com.arellomobile.mvp.presenter.InjectPresenter;
import com.arellomobile.mvp.presenter.ProvidePresenter;
import com.example.v4n0v.geandroid.entities.IdTitleObj;
import com.example.v4n0v.geandroid.presenters.SelectCarPresenter;
import com.example.v4n0v.geandroid.recycler_adapters.RecyclerSelectCarAdapter;
import com.jakewharton.rxbinding2.widget.RxTextView;
import com.jakewharton.rxbinding2.widget.TextViewAfterTextChangeEvent;

import butterknife.BindView;
import butterknife.ButterKnife;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.subjects.PublishSubject;

public class SelectCarActivity extends MvpAppCompatActivity implements SelectCarView {
    // todo когда вводится текст, должен фильтроваться список
    @BindView(R.id.select_mark_edittext) EditText selectMarkEditText;
    @BindView(R.id.select_mark_recycler_view)  RecyclerView selectMarkRecyclerView;


    @BindView(R.id.car_toolbar) Toolbar toolbar;

    @InjectPresenter
    SelectCarPresenter presenter;

    RecyclerSelectCarAdapter adapter;

    @ProvidePresenter
    public SelectCarPresenter provideMainPresenter() {

        return new SelectCarPresenter(AndroidSchedulers.mainThread());
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_car);
        setSupportActionBar(toolbar);
        ButterKnife.bind(this);
    }

    @Override
    public void init() {
        presenter.initMarksList();
        selectMarkRecyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        adapter= new RecyclerSelectCarAdapter(presenter.getListPresenter());
        selectMarkRecyclerView.setAdapter(adapter);


        PublishSubject<String> subject = PublishSubject.create();
        presenter.setSubject(subject);

        RxTextView.afterTextChangeEvents(selectMarkEditText)
                .subscribe(new Consumer<TextViewAfterTextChangeEvent>() {
                    @Override
                    public void accept(TextViewAfterTextChangeEvent s) throws Exception {
                        subject.onNext(selectMarkEditText.getText().toString());
                    }
                });
    }

    @Override
    public void fillMarksList(String string) {
   }

    @Override
    public void updateList() {
        adapter.notifyDataSetChanged();
    }

    @Override
    public void onItemSelect(IdTitleObj object) {
        Toast.makeText(this, "Выбран "+object.getTitle()+", id="+object.getId(), Toast.LENGTH_SHORT).show();

    }



}
