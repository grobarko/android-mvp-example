package com.vlatko.mvp.ui.login;

import com.vlatko.mvp.data.api.models.LoginResponse;
import com.vlatko.mvp.data.api.models.UserCredentials;
import com.vlatko.mvp.ui.base.BaseContract;

import io.reactivex.Observable;

public interface LoginContract {
    interface View extends BaseContract.View {
        void clearPassword();

        void setErrorMessage(String errorMessage);
    }

    interface Presenter extends BaseContract.Presenter {
        void onLoginClicked(String username, String password);
    }

    interface Interactor extends BaseContract.Interactor {
        Observable<LoginResponse> login(UserCredentials userCredentials);
    }
}
