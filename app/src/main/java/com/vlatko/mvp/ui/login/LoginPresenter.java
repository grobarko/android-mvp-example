package com.vlatko.mvp.ui.login;


import android.widget.Toast;

import com.vlatko.mvp.data.api.models.LoginResponse;
import com.vlatko.mvp.data.api.models.UserCredentials;
import com.vlatko.mvp.data.model.Session;
import com.vlatko.mvp.di.PerActivity;
import com.vlatko.mvp.ui.base.BaseContract;
import com.vlatko.mvp.ui.base.BasePresenter;
import com.vlatko.mvp.ui.home.HomeActivity;
import com.vlatko.mvp.utils.rx.SchedulerProvider;

import javax.inject.Inject;

import io.reactivex.disposables.CompositeDisposable;

@PerActivity
public class LoginPresenter extends
        BasePresenter<LoginContract.View, LoginContract.Interactor, BaseContract.Navigator>
        implements LoginContract.Presenter {

    @Inject
    LoginPresenter(LoginContract.View view,
            LoginContract.Interactor interactor,
            BaseContract.Navigator navigator,
            SchedulerProvider schedulerProvider,
            CompositeDisposable compositeDisposable) {
        super(view, interactor, navigator, schedulerProvider, compositeDisposable);
    }

    @Override
    public void onLoginClicked(String username, String password) {
        UserCredentials userCredentials = new UserCredentials(username, password);
        compositeDisposable.add(interactor.login(userCredentials)
                .subscribeOn(schedulerProvider.io())
                .observeOn(schedulerProvider.ui())
                .subscribe(this::onLoginSuccess, this::onLoginError));
    }

    private void onLoginSuccess(LoginResponse loginResponse) {
        Session session = interactor.getSession();
        session.setUser(loginResponse.getUser());
        session.setAccessToken(loginResponse.getId());
        interactor.setSession(session);
        goToHomeAndFinish();
    }

    private void onLoginError(Throwable throwable) {
        view.clearPassword();
        view.showToast(throwable.getMessage(), Toast.LENGTH_LONG);
    }

    private void goToHomeAndFinish() {
        navigator.startActivity(HomeActivity.class);
        navigator.finishActivity();
    }
}
