package com.vlatko.mvp.di.module;

import com.vlatko.mvp.di.PerActivity;
import com.vlatko.mvp.ui.home.HomeActivity;
import com.vlatko.mvp.ui.home.HomeModule;
import com.vlatko.mvp.ui.login.LoginActivity;
import com.vlatko.mvp.ui.login.LoginModule;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class ActivityBindingModule {

    @PerActivity
    @ContributesAndroidInjector(modules = HomeModule.class)
    abstract HomeActivity homeActivity();

    @PerActivity
    @ContributesAndroidInjector(modules = LoginModule.class)
    abstract LoginActivity loginActivity();

}
