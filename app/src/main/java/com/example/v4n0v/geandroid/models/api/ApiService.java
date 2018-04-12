package com.example.v4n0v.geandroid.models.api;



import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Path;


public interface ApiService {
    @GET ("/users/{user}")
    Observable<User> getUser(@Path("user") String username);
}
