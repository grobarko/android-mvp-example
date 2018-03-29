package com.vlatko.mvp.ui.details.first_name;

import com.vlatko.mvp.ui.base.BaseContract;

public interface FirstNameContract {
    interface View extends BaseContract.View {
        void setFirstName(String firstName);
    }

    interface Presenter extends BaseContract.Presenter {
        void onGoToLastNameClicked(String firstNameExtra);
    }
}
