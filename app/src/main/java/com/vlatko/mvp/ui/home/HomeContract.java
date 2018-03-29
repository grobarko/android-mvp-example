package com.vlatko.mvp.ui.home;

import com.vlatko.mvp.ui.base.BaseContract;

public interface HomeContract {
    interface View extends BaseContract.View {
        void setMessage(String message);
    }

    interface Presenter extends BaseContract.Presenter {
        void onGoToDetailsClicked();

        void onLogoutClicked();
    }

    interface Interactor extends BaseContract.Interactor {

    }
}
