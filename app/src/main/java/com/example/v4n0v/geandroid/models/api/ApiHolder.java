package com.example.v4n0v.geandroid.models.api;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by avetc on 11.04.2018.
 */

public class ApiHolder {
    private static ApiHolder instance =new ApiHolder();

    public static ApiHolder getInstance() {
        if (instance==null) {
            return new ApiHolder();
        } else {
            return instance;
        }
    }

    public static ApiService getApi() {
        return getInstance().api;
    }

    private  ApiService api;
    private ApiHolder(){

            Gson gson =new GsonBuilder()
                    .setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
                    .create();

          api = new Retrofit.Builder()
                    .baseUrl("https://api.github.com")
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .addConverterFactory(GsonConverterFactory.create(gson))
                    .build()
                    .create(ApiService.class);

    }
}
