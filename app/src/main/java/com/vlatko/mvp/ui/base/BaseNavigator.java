package com.vlatko.mvp.ui.base;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;

import com.vlatko.mvp.di.PerActivity;

import javax.inject.Inject;

@PerActivity
public class BaseNavigator implements BaseContract.Navigator {

    private final AppCompatActivity activity;

    @Inject
    public BaseNavigator(AppCompatActivity activity) {
        this.activity = activity;
    }

    @Override
    public void startActivity(@NonNull Class<?> cls) {
        activity.startActivity(new Intent(activity, cls));
    }

    @Override
    public void finishActivity() {
        activity.finish();
    }
}
