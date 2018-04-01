package com.example.v4n0v.geandroid.presenters;

import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;
import com.example.v4n0v.geandroid.SelectCarView;
import com.example.v4n0v.geandroid.models.SelectCarModel;

import java.util.ArrayList;
import java.util.List;

@InjectViewState
public class SelectCarPresenter extends MvpPresenter<SelectCarView> {
    private SelectCarModel selectCarModel = new SelectCarModel();

    public SelectCarPresenter(){

    }
    // передаем в данные с сервера и связываем с актививти
    public void initMarksList(){
        selectCarModel.setMarksList(getMarksFromServer());
        getViewState().fillMarksList(selectCarModel.getMarksList().get(0));
    }

    // полуаем список марок с сервера
    private List<String> getMarksFromServer(){

        // пока просто забью строками
        List<String> list = new ArrayList<>();
        list.add("ЗАЗ");
        list.add("ВАЗ");
        list.add("ГАЗ");
        list.add("УАЗ");
        list.add("МАЗ");
        list.add("КРАЗ");
        list.add("АЗАЗА");
        return list;
    }
}
