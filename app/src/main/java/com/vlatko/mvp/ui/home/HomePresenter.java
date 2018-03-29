package com.vlatko.mvp.ui.home;


import android.os.Bundle;
import android.support.annotation.Nullable;

import com.vlatko.mvp.data.api.models.User;
import com.vlatko.mvp.di.PerActivity;
import com.vlatko.mvp.ui.base.BaseContract;
import com.vlatko.mvp.ui.base.BasePresenter;
import com.vlatko.mvp.ui.login.LoginActivity;
import com.vlatko.mvp.utils.rx.SchedulerProvider;

import javax.inject.Inject;

import io.reactivex.disposables.CompositeDisposable;

@PerActivity
public class HomePresenter extends
        BasePresenter<HomeContract.View, HomeContract.Interactor, BaseContract.Navigator>
        implements HomeContract.Presenter {

    @Inject
    HomePresenter(HomeContract.View view,
            HomeContract.Interactor interactor, BaseContract.Navigator navigator,
            SchedulerProvider schedulerProvider,
            CompositeDisposable compositeDisposable) {
        super(view, interactor, navigator, schedulerProvider, compositeDisposable);
    }

    @Override
    public void initialize(@Nullable Bundle savedInstanceState) {
        super.initialize(savedInstanceState);
        if (!interactor.isLoggedIn()) {
            goToLoginAndFinish();
            return;
        }

        User user = interactor.getSession().getUser();
        view.setMessage(String.format("Welcome %s %s!", user.getFirstName(), user.getLastName()));
    }

    @Override
    public void onGoToDetailsClicked() {
        // TODO: Add one more module
    }

    @Override
    public void onLogoutClicked() {
        interactor.setSession(null);
        goToLoginAndFinish();
    }

    private void goToLoginAndFinish() {
        navigator.startActivity(LoginActivity.class);
        navigator.finishActivity();
    }
}
