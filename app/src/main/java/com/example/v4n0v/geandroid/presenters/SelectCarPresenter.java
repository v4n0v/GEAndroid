package com.example.v4n0v.geandroid.presenters;

import android.util.Log;

import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;
import com.example.v4n0v.geandroid.SelectCarView;
import com.example.v4n0v.geandroid.models.SelectCarModel;
import com.example.v4n0v.geandroid.recycler_adapters.IListCarRawView;
import com.example.v4n0v.geandroid.recycler_adapters.IListPresenter;

import java.util.ArrayList;
import java.util.List;

@InjectViewState
public class SelectCarPresenter extends MvpPresenter<SelectCarView> {


    public ListPresenter getListPresenter() {
        return listPresenter;
    }

    private ListPresenter listPresenter = new ListPresenter();

    class ListPresenter implements IListPresenter {
        List<String> items = new ArrayList<>();

        @Override
        public void bindView(IListCarRawView view) {
            view.setText(items.get(view.getPos()));
        }

        @Override
        public int getViewCount() {
            return items.size();
        }
    }

    @Override
    protected void onFirstViewAttach() {
        super.onFirstViewAttach();
        getViewState().init();
        listPresenter.items =selectCarModel.getMarksList();
        getViewState().updateList();
    }

    private SelectCarModel selectCarModel = new SelectCarModel();
    private static final String TAG = "MainPresenter";

    public SelectCarPresenter(String str){
        Log.d(TAG, str);
    }
    // передаем в данные с сервера и связываем с актививти
    public void initMarksList(){
        // если данные еще не получены, тогда получить, если получены берем из модели
        if (selectCarModel.getMarksList()==null || selectCarModel.getMarksList().size()==0) {
            selectCarModel.setMarksList(getMarksFromServer());
        }
       // getViewState().fillMarksList(selectCarModel.getMarksList().get(0));
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
