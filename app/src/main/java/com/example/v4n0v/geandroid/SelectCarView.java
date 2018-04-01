package com.example.v4n0v.geandroid;

import com.arellomobile.mvp.MvpView;
import com.arellomobile.mvp.viewstate.strategy.AddToEndSingleStrategy;
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType;

@StateStrategyType(value = AddToEndSingleStrategy.class)
public interface SelectCarView extends MvpView{
    void init();

    void fillMarksList(String string);

    void updateList();

    void onMarkSelect(String title);
}
