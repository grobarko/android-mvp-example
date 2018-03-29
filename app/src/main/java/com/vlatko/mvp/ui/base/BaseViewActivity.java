package com.vlatko.mvp.ui.base;

import android.os.Bundle;
import android.support.annotation.CallSuper;
import android.support.annotation.StringRes;
import android.widget.Toast;

import javax.inject.Inject;

public abstract class BaseViewActivity<T extends BaseContract.Presenter> extends
        BaseActivity implements BaseContract.View {

    @Inject
    protected T presenter;

    private Toast toast;

    @CallSuper
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
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
    public void onDestroy() {
        presenter.destroy();
        super.onDestroy();
    }

    @Override
    public void showToast(String message, int duration) {
        if (toast != null) {
            toast.cancel();
        }
        toast = Toast.makeText(this, message, duration);
        toast.show();
    }

    @Override
    public void showToast(@StringRes int message, int duration) {
        if (toast != null) {
            toast.cancel();
        }
        toast = Toast.makeText(this, message, duration);
        toast.show();
    }
}
