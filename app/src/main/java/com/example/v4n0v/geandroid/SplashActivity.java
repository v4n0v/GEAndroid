package com.example.v4n0v.geandroid;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;


public class SplashActivity extends AppCompatActivity {

    final String TAG = "Splash";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        fillMarksListView();
        // пока тут лопата, будет заменена на загрузку данных
        Thread timer = new Thread(){
            @Override
            public void run() {
                try {
                    loadDataFromServer();
                    sleep(3000);

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                showNext();
            }
        };
        timer.start();

    }


    // логика загрузки данных
    private void loadDataFromServer() {
        Log.d(TAG, "Loading data from server");
    }

    // открываем сл. активность
    private void showNext() {
        Intent intent = new Intent(SplashActivity.this,MainActivity.class);

        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);

    }

    private void fillMarksListView() {


//        RequestController.OkHttpHandler httpHandler = new RequestController.OkHttpHandler();
//        httpHandler.execute("?target=mark&action=list");
//        System.out.println();
//        dataMap.setCarMarksList(getListOperator.getMarks());
//
//        System.out.println(dataMap.getCarMarksList().size());
//        fillObservableList(marksList, adapter.idTitleObjToString(dataMap.getCarMarksList()));
//        if (dataMap.getCarMarksList() != null && dataMap.getCarMarksList().size() > 0) {
//            markListView.getSelectionModel().selectFirst();
//
//            // формируется запрос на получение списка моделей
////            System.out.println(dataMap.getCarModelsList().size());
//            Log2File.writeLog("Список марок получен. Кол-во = " + dataMap.getCarMarksList().size());
//            fillModelsListView();
//        } else {
//            Log2File.writeLog("Список марок авто пуст");
//        }
//    }
    }
}
