package com.vlatko.mvp.ui.base;

import android.os.Bundle;
import android.support.annotation.CallSuper;
import android.support.annotation.Nullable;

import com.vlatko.mvp.utils.rx.SchedulerProvider;

import io.reactivex.disposables.CompositeDisposable;

public abstract class BasePresenter<T extends BaseContract.View, I extends BaseContract.Interactor,
        N extends BaseContract.Navigator> implements BaseContract.Presenter {

    protected final T view;
    protected final I interactor;
    protected final N navigator;
    protected final SchedulerProvider schedulerProvider;
    protected final CompositeDisposable compositeDisposable;

    protected BasePresenter(T view, I interactor, N navigator,
            SchedulerProvider schedulerProvider,
            CompositeDisposable compositeDisposable) {
        this.view = view;
        this.interactor = interactor;
        this.navigator = navigator;
        this.schedulerProvider = schedulerProvider;
        this.compositeDisposable = compositeDisposable;
    }

    @CallSuper
    @Override
    public void initialize(@Nullable Bundle savedInstanceState) {
    }

    @CallSuper
    @Override
    public void start() {
    }

    @CallSuper
    @Override
    public void stop() {
    }

    @CallSuper
    @Override
    public void destroy() {
        compositeDisposable.dispose();
    }
}
