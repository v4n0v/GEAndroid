package com.example.v4n0v.geandroid.utils;

import android.util.Log;

import java.io.IOException;
import java.util.logging.Level;

import okhttp3.OkHttpClient;
import okhttp3.Request;


public class ConnectionManager {
    String TAG = "ConnectionManager";
    private String responseBody;
    String request;

    static final String ADRESS_URL = "http://46.229.213.157:8080";

    static final String SERVLET = "/controller";

    private ConnectionManager() {
    }

    public static ConnectionManager getInstance() {
        return manager;
    }

    static ConnectionManager manager = new ConnectionManager();

    public ConnectionManager setRequest(String request) {
        this.request = request;
        return this;
    }

    public String getResp() throws Exception {
        OkHttpClient client = new OkHttpClient();
        Request req = new Request.Builder()
                .url(ADRESS_URL + SERVLET + request)
                .build();
        String s = client.newCall(req).execute().body().string();
        Log.d(TAG, s);
        return s;
    }

}
