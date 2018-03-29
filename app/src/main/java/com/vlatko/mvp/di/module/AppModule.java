package com.vlatko.mvp.di.module;

import android.content.Context;

import com.google.gson.Gson;
import com.vlatko.mvp.MvpApp;
import com.vlatko.mvp.data.api.Api;
import com.vlatko.mvp.di.ApplicationContext;
import com.vlatko.mvp.utils.AppConstants;
import com.vlatko.mvp.utils.rx.SchedulerProvider;

import java.util.concurrent.TimeUnit;

import dagger.Binds;
import dagger.Module;
import dagger.Provides;
import io.reactivex.disposables.CompositeDisposable;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

@Module
public abstract class AppModule {

    @Binds
    @ApplicationContext
    abstract Context applicationContext(MvpApp application);

    @Provides
    static CompositeDisposable compositeDisposable() {
        return new CompositeDisposable();
    }

    @Provides
    static SchedulerProvider schedulerProvider() {
        return new SchedulerProvider();
    }

    @Provides
    static Gson gson() {
        return new Gson();
    }

    @Provides
    static OkHttpClient okHttpClient() {
        return new OkHttpClient.Builder()
                .readTimeout(AppConstants.API_TIMEOUT_SECONDS, TimeUnit.SECONDS)
                .connectTimeout(AppConstants.API_TIMEOUT_SECONDS, TimeUnit.SECONDS)
                .build();
    }

    @Provides
    static Retrofit retrofit(Gson gson, OkHttpClient okHttpClient) {
        return new Retrofit.Builder()
                .baseUrl(AppConstants.BASE_API_URL)
                .client(okHttpClient)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
    }

    @Provides
    static Api api(Retrofit retrofit) {
        return retrofit.create(Api.class);
    }
}
