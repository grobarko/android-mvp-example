package com.vlatko.mvp.ui.details;

import android.os.Bundle;
import android.support.annotation.Nullable;

import com.vlatko.mvp.R;
import com.vlatko.mvp.di.PerActivity;
import com.vlatko.mvp.ui.base.BasePresenter;
import com.vlatko.mvp.utils.rx.SchedulerProvider;

import javax.inject.Inject;

import io.reactivex.disposables.CompositeDisposable;

@PerActivity
public class DetailsPresenter extends
        BasePresenter<DetailsContract.View, DetailsContract.Interactor, DetailsContract.Navigator>
        implements DetailsContract.Presenter {

    @Inject
    DetailsPresenter(DetailsContract.View view,
            DetailsContract.Interactor interactor,
            DetailsContract.Navigator navigator,
            SchedulerProvider schedulerProvider,
            CompositeDisposable compositeDisposable) {
        super(view, interactor, navigator, schedulerProvider, compositeDisposable);
    }

    @Override
    public void initialize(@Nullable Bundle savedInstanceState) {
        super.initialize(savedInstanceState);
        navigator.goToFirstName(R.id.flContainer, false);
    }
}
