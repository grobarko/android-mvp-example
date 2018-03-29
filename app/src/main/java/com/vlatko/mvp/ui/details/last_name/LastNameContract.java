package com.vlatko.mvp.ui.details.last_name;

import com.vlatko.mvp.ui.base.BaseContract;

public interface LastNameContract {
    interface View extends BaseContract.View {
        void setLastName(String lastName);
    }

    interface Presenter extends BaseContract.Presenter {
        void onGoToSummaryClicked(String lastNameExtra);
    }
}
