package com.vlatko.mvp.ui.details.summary;

import com.vlatko.mvp.ui.base.BaseContract;

public interface SummaryContract {
    interface View extends BaseContract.View {
        void setMessage(String message);
    }

    interface Presenter extends BaseContract.Presenter {
        void onResetClicked();
    }
}
