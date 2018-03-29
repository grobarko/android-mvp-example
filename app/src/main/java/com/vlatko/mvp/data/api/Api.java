package com.vlatko.mvp.data.api;

import com.vlatko.mvp.data.api.models.LoginResponse;
import com.vlatko.mvp.data.api.models.UserCredentials;

import io.reactivex.Observable;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface Api {

    @POST("Users/login")
    Observable<LoginResponse> login(@Body UserCredentials userCredentials);
}
