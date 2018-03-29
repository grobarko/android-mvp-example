package com.vlatko.mvp.ui.details;

import android.support.annotation.IdRes;

import com.vlatko.mvp.ui.base.BaseContract;

public interface DetailsContract {
    interface View extends BaseContract.View {

    }

    interface Presenter extends BaseContract.Presenter {

    }

    interface Interactor extends BaseContract.Interactor {
        void setFirstNameExtra(String firstNameExtra);

        String getFirstNameExtra();

        void setLastNameExtra(String lastNameExtra);

        String getLastNameExtra();
    }

    interface Navigator extends BaseContract.Navigator {
        void goToFirstName(@IdRes int containerViewId, boolean clearBackStack);

        void goToLastName(@IdRes int containerViewId);

        void goToSummary(@IdRes int containerViewId);
    }
}
