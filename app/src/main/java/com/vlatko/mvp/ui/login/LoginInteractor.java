package com.vlatko.mvp.ui.login;

import com.vlatko.mvp.data.api.Api;
import com.vlatko.mvp.data.api.models.LoginResponse;
import com.vlatko.mvp.data.api.models.UserCredentials;
import com.vlatko.mvp.data.prefs.PrefsManager;
import com.vlatko.mvp.di.PerActivity;
import com.vlatko.mvp.ui.base.BaseInteractor;

import javax.inject.Inject;

import io.reactivex.Observable;

@PerActivity
public class LoginInteractor extends BaseInteractor implements LoginContract.Interactor {

    @Inject
    LoginInteractor(Api api, PrefsManager prefsManager) {
        super(api, prefsManager);
    }

    @Override
    public Observable<LoginResponse> login(UserCredentials userCredentials) {
        return api.login(userCredentials);
    }
}
