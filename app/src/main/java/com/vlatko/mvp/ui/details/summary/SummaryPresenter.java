package com.vlatko.mvp.ui.details.summary;

import android.os.Bundle;
import android.support.annotation.Nullable;

import com.vlatko.mvp.R;
import com.vlatko.mvp.data.api.models.User;
import com.vlatko.mvp.di.PerFragment;
import com.vlatko.mvp.ui.base.BasePresenter;
import com.vlatko.mvp.ui.details.DetailsContract;
import com.vlatko.mvp.utils.rx.SchedulerProvider;

import javax.inject.Inject;

import io.reactivex.disposables.CompositeDisposable;

@PerFragment
public class SummaryPresenter extends
        BasePresenter<SummaryContract.View, DetailsContract.Interactor, DetailsContract.Navigator>
        implements SummaryContract.Presenter {

    @Inject
    SummaryPresenter(SummaryContract.View view,
            DetailsContract.Interactor interactor,
            DetailsContract.Navigator navigator,
            SchedulerProvider schedulerProvider,
            CompositeDisposable compositeDisposable) {
        super(view, interactor, navigator, schedulerProvider, compositeDisposable);
    }

    @Override
    public void initialize(@Nullable Bundle savedInstanceState) {
        super.initialize(savedInstanceState);

        User user = interactor.getSession().getUser();
        view.setMessage(String.format("Full Details:\nFirst name: %s (%s)\nLast name: %s (%s)",
                user.getFirstName(), interactor.getFirstNameExtra(),
                user.getLastName(), interactor.getLastNameExtra()));
    }

    @Override
    public void onResetClicked() {
        interactor.setFirstNameExtra(null);
        interactor.setLastNameExtra(null);
        navigator.goToFirstName(R.id.flContainer, true);
    }
}
