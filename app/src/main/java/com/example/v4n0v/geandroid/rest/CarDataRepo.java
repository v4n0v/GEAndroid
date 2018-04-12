package com.example.v4n0v.geandroid.rest;

import com.example.v4n0v.geandroid.data.Preferences;
import com.example.v4n0v.geandroid.entities.Composite;
import com.example.v4n0v.geandroid.rest.api.ApiHolder;

import io.reactivex.Observable;


public class CarDataRepo {
    public Observable<Composite> getMarks(){
        return ApiHolder.getApi().getMarkList("list", "mark", Preferences.GUEST_KEY);
    }

}
