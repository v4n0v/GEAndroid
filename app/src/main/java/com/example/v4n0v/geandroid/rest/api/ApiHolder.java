package com.example.v4n0v.geandroid.rest.api;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by avetc on 12.04.2018.
 */

public class ApiHolder {
    private static ApiHolder instance = new ApiHolder();

    public static ApiHolder getInstance() {
        if (instance == null) {
            return new ApiHolder();
        } else {
            return instance;
        }
    }

    public static ApiService getApi() {
        return getInstance().api;
    }

    private ApiService api;

    private ApiHolder() {

//        Gson gson = new GsonBuilder()
//                .setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
//                .create();
        Gson GSON =    new GsonBuilder().setPrettyPrinting().create();
        api = new Retrofit.Builder()
                .baseUrl("http://46.229.213.157:8080/controller/")
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create(GSON))
                .build()
                .create(ApiService.class);

    }

}