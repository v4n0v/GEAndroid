package com.example.v4n0v.geandroid.rest.api;

import com.example.v4n0v.geandroid.entities.Composite;
import com.example.v4n0v.geandroid.entities.IdTitleObj;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiService {

    @GET
    Observable<Composite> getMarkList(@Query("action") String action,
                                      @Query("target") String target,
                                      @Query("key") String key);
}
