package com.vlatko.mvp.ui.home;

import android.support.v7.app.AppCompatActivity;

import com.vlatko.mvp.di.PerActivity;
import com.vlatko.mvp.di.module.BaseActivityModule;
import com.vlatko.mvp.ui.base.BaseContract;
import com.vlatko.mvp.ui.base.BaseNavigator;

import dagger.Binds;
import dagger.Module;

@Module(includes = BaseActivityModule.class)
public abstract class HomeModule {
    @PerActivity
    @Binds
    abstract AppCompatActivity appCompatActivity(HomeActivity activity);

    @PerActivity
    @Binds
    abstract HomeContract.View homeView(HomeActivity activity);

    @PerActivity
    @Binds
    abstract HomeContract.Presenter homePresenter(HomePresenter presenter);

    @PerActivity
    @Binds
    abstract HomeContract.Interactor homeInteractor(HomeInteractor interactor);

    @PerActivity
    @Binds
    abstract BaseContract.Navigator baseNavigator(BaseNavigator navigator);
}
