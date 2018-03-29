package com.vlatko.mvp.ui.base;

import android.os.Bundle;
import android.support.annotation.CallSuper;
import android.support.annotation.StringRes;
import android.widget.Toast;

import javax.inject.Inject;

public abstract class BaseViewFragment<T extends BaseContract.Presenter> extends
        BaseFragment implements BaseContract.View {

    @Inject
    protected T presenter;

    private Toast toast;

    @CallSuper
    @Override
    public void onViewStateRestored(Bundle savedInstanceState) {
        super.onViewStateRestored(savedInstanceState);
        // Only start the presenter when the views have been bound.
        // See BaseFragment.onViewStateRestored
        presenter.initialize(savedInstanceState);
    }

    @Override
    public void onStart() {
        super.onStart();
        presenter.start();
    }

    @Override
    public void onStop() {
        presenter.stop();
        super.onStop();
    }

    @CallSuper
    @Override
    public void onDestroyView() {
        presenter.destroy();
        super.onDestroyView();
    }

    @Override
    public void showToast(String message, int duration) {
        if (toast != null) {
            toast.cancel();
        }
        toast = Toast.makeText(activityContext, message, duration);
        toast.show();
    }

    @Override
    public void showToast(@StringRes int message, int duration) {
        if (toast != null) {
            toast.cancel();
        }
        toast = Toast.makeText(activityContext, message, duration);
        toast.show();
    }
}
