package com.example.v4n0v.geandroid.models.api;


import io.reactivex.Observable;


public class UserRepo {
    public Observable<User> getUser(String username){

        return ApiHolder.getApi().getUser(username);
    }
}
