package com.vlatko.mvp.ui.login;

import android.support.v7.app.AppCompatActivity;

import com.vlatko.mvp.di.PerActivity;
import com.vlatko.mvp.di.module.BaseActivityModule;
import com.vlatko.mvp.ui.base.BaseContract;
import com.vlatko.mvp.ui.base.BaseNavigator;

import dagger.Binds;
import dagger.Module;

@Module(includes = BaseActivityModule.class)
public abstract class LoginModule {
    @PerActivity
    @Binds
    abstract AppCompatActivity appCompatActivity(LoginActivity activity);

    @PerActivity
    @Binds
    abstract LoginContract.View loginView(LoginActivity activity);

    @PerActivity
    @Binds
    abstract LoginContract.Presenter loginPresenter(LoginPresenter presenter);

    @PerActivity
    @Binds
    abstract LoginContract.Interactor loginInteractor(LoginInteractor interactor);

    @PerActivity
    @Binds
    abstract BaseContract.Navigator baseNavigator(BaseNavigator navigator);
}
