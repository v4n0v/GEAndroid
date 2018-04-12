package com.example.v4n0v.geandroid.presenters;

import android.util.Log;

import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;
import com.example.v4n0v.geandroid.SelectCarView;
import com.example.v4n0v.geandroid.entities.Composite;
import com.example.v4n0v.geandroid.entities.IdTitleObj;
import com.example.v4n0v.geandroid.models.SelectCarModel;
import com.example.v4n0v.geandroid.models.api.User;
import com.example.v4n0v.geandroid.models.api.UserRepo;
import com.example.v4n0v.geandroid.recycler_adapters.IListCarRawView;
import com.example.v4n0v.geandroid.recycler_adapters.IListPresenter;
import com.example.v4n0v.geandroid.rest.CarDataRepo;
import com.example.v4n0v.geandroid.utils.ConnectionManager;
import com.example.v4n0v.geandroid.utils.JsonController;
import com.google.gson.JsonObject;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Observer;
import io.reactivex.Scheduler;
import io.reactivex.Single;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import io.reactivex.subjects.PublishSubject;
import okhttp3.OkHttpClient;
import okhttp3.Request;

@InjectViewState
public class SelectCarPresenter extends MvpPresenter<SelectCarView> {

    private SelectCarModel selectCarModel = new SelectCarModel();
    private static final String TAG = "SelectCarPresenter";
    private PublishSubject<String> subject;
    JsonController jsonController;


    public SelectCarPresenter(Scheduler mainThreadScheduler) {
        this.mainThrearSheduler = mainThreadScheduler;
        carDataRepo=new CarDataRepo();
       jsonController=JsonController.getInstance();
       connectionManager=ConnectionManager.getInstance();
    }

    private Scheduler mainThrearSheduler;
    private CarDataRepo carDataRepo;
    public ListPresenter getListPresenter() {
        return listPresenter;
    }

    private ListPresenter listPresenter = new ListPresenter();

    public void setSubject(PublishSubject<String> subject) {
        this.subject = subject;
        this.subject.subscribe(observer);
    }

    List<IdTitleObj> filterderList;

    class ListPresenter implements IListPresenter {
        List<IdTitleObj> items = new ArrayList<>();

        @Override
        public void bindView(IListCarRawView view) {
            view.setText(items.get(view.getPos()).getTitle());
        }

        @Override
        public int getViewCount() {
            return items.size();
        }

        @Override
        public void selectItem(int pos) {
            IdTitleObj obj = (IdTitleObj) selectCarModel.getMarksList().get(pos);

            getViewState().onItemSelect(obj);
        }
    }

    Observer<String> observer;

    @Override
    protected void onFirstViewAttach() {
        super.onFirstViewAttach();
        //  getDataByOkHttp();
        loadMarksList();
       // loadUserData();
        filterderList = new ArrayList<>();
        initObserver();

        getViewState().init();
        listPresenter.items = selectCarModel.getMarksList();
        getViewState().updateList();
    }


    // передаем в данные с сервера и связываем с актививти
    public void initMarksList() {
        // если данные еще не получены, тогда получить, если получены берем из модели
        if (selectCarModel.getMarksList() == null || selectCarModel.getMarksList().size() == 0) {
            selectCarModel.setMarksList(getMarksFromServer());
        }
        // getViewState().fillMarksList(selectCarModel.getMarksList().get(0));
    }

    // полуаем список марок с сервера
    private List<IdTitleObj> getMarksFromServer() {

        // пока просто забью строками
        List<IdTitleObj> list = new ArrayList<>();
        list.add(new IdTitleObj(1, "Acura"));
        list.add(new IdTitleObj(2, "Audi"));
        list.add(new IdTitleObj(3, "Aston Martin"));
        list.add(new IdTitleObj(4, "BMW"));
        list.add(new IdTitleObj(5, "Buick"));
        list.add(new IdTitleObj(6, "Dodge"));
        list.add(new IdTitleObj(7, "Cadillac"));
        return list;
    }

    UserRepo userRepo = new UserRepo();

    public void loadUserData() {
        userRepo.getUser("v4n0v")
                .subscribeOn(Schedulers.io())
                .observeOn(mainThrearSheduler)
                .subscribe(new Observer<User>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(User user) {
                        Log.d(TAG, user.getLogin());

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

    public void loadMarksList(){
        carDataRepo.getMarks()
                .subscribeOn(Schedulers.io())
                .observeOn(mainThrearSheduler)
               .subscribe(new Observer<Composite>() {
                   @Override
                   public void onSubscribe(Disposable d) {

                   }

                   @Override
                   public void onNext(Composite composite) {

                       extractComposite(composite);
                   }

                   @Override
                   public void onError(Throwable e) {

                   }

                   @Override
                   public void onComplete() {

                   }
               });
    }

    private void extractComposite(Composite composite) {
        Log.d(TAG, "size = "+composite.getComponents().size());
//        for (int i = 0; i < arr.size(); i++) {
//            JsonObject arrayElement = (JsonObject) arr.get(i);
//            composite.addComponent(parseJson(arrayElement));
//        }

    }

ConnectionManager connectionManager;
    private void getDataByOkHttp(String request) {
        Single<String> single = Single.fromCallable(() -> connectionManager.setRequest(request).getResp());

        single
                .subscribeOn(Schedulers.io())
                .observeOn(mainThrearSheduler)
                .subscribe(s -> {
                    Log.d(TAG, s);
                });
    }

    void initObserver() {
        observer = new Observer<String>() {
            @Override
            public void onSubscribe(Disposable d) {
                Log.d(TAG, "subscribed");
            }

            @Override
            public void onNext(String s) {
                // если стрка пуста, тогда только заполняем исходным списком
                listPresenter.items = selectCarModel.getMarksList();
                if (s.length() != 0) {
                    // иначе проверяем на совпадения
                    // обнуляем отфильтрованный список
                    filterderList.clear();
                    // сбрасываем счетчик совпадений
                    int count = 0;
                    for (int i = 0; i < listPresenter.items.size(); i++) {
                        if (listPresenter.items.get(i).toString().toLowerCase().contains(s.toLowerCase())) {
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
                Log.d(TAG, "error");
            }

            @Override
            public void onComplete() {

            }
        };
    }
}
