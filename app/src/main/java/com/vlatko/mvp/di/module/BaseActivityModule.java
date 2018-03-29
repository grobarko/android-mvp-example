package com.vlatko.mvp.di.module;

import android.content.Context;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;

import com.vlatko.mvp.di.ActivityContext;
import com.vlatko.mvp.di.ActivityFragmentManager;
import com.vlatko.mvp.di.PerActivity;

import dagger.Binds;
import dagger.Module;
import dagger.Provides;

@Module
public abstract class BaseActivityModule {

    @Binds
    @PerActivity
    @ActivityContext
    abstract Context activityContext(AppCompatActivity activity);

    @Provides
    @PerActivity
    @ActivityFragmentManager
    static FragmentManager activityFragmentManager(AppCompatActivity activity) {
        return activity.getSupportFragmentManager();
    }
}
