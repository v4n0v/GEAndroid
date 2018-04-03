package com.example.v4n0v.geandroid.presenters;

import android.util.Log;
import android.widget.Toast;

import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;
import com.example.v4n0v.geandroid.SelectCarView;
import com.example.v4n0v.geandroid.models.SelectCarModel;
import com.example.v4n0v.geandroid.recycler_adapters.IListCarRawView;
import com.example.v4n0v.geandroid.recycler_adapters.IListPresenter;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.subjects.PublishSubject;

@InjectViewState
public class SelectCarPresenter extends MvpPresenter<SelectCarView> {

    private SelectCarModel selectCarModel = new SelectCarModel();
    private static final String TAG = "MainPresenter";
    private PublishSubject<String> subject;

    public ListPresenter getListPresenter() {
        return listPresenter;
    }

    private ListPresenter listPresenter = new ListPresenter();

    public void setSubject(PublishSubject<String> subject) {
        this.subject = subject;
        this.subject.subscribe(observer);
    }
    List<String> filterderList;
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

        @Override
        public void selectItem(int pos) {
            String title = selectCarModel.getMarksList().get(pos);
            getViewState().onMarkSelect(title);
        }
    }
    Observer<String> observer;
    @Override
    protected void onFirstViewAttach() {
        super.onFirstViewAttach();
        filterderList=new ArrayList<>();
        initObserver();

        getViewState().init();
        listPresenter.items =selectCarModel.getMarksList();
        getViewState().updateList();
    }



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


    void initObserver(){
        observer = new Observer<String>() {
            @Override
            public void onSubscribe(Disposable d) {
                Log.d(TAG,"subscribed");
            }

            @Override
            public void onNext(String s) {
                // если стрка пуста, тогда заполняем исходным списком
                if (s.length()==0){
                    listPresenter.items = selectCarModel.getMarksList();
                } else {
                // иначе проверяем на совпадения
                    // обнуляем отфильтрованный список
                    filterderList.clear();
                    // спасиваем счетчик совпадений
                    int count = 0;
                    for (int i = 0; i < listPresenter.items.size(); i++) {
                        if (listPresenter.items.get(i).toLowerCase().contains(s.toLowerCase())) {
                            filterderList.add(listPresenter.items.get(i));
                            count++;
                        }
                    }
                    // если совпадения имеются, заменяем список на фильтрованный
                    if (count > 0) {
                        listPresenter.items = filterderList;
                    } else {
                       listPresenter.items = selectCarModel.getMarksList();
                    }
                }
                // обновляем состояние адаптера
                getViewState().updateList();
            }

            @Override
            public void onError(Throwable e) {
                Log.d(TAG,"error");
            }

            @Override
            public void onComplete() {

            }
        };
    }
}
