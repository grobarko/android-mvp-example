package com.vlatko.mvp.ui.details.last_name;

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
public class LastNamePresenter extends
        BasePresenter<LastNameContract.View, DetailsContract.Interactor, DetailsContract.Navigator>
        implements LastNameContract.Presenter {

    @Inject
    LastNamePresenter(LastNameContract.View view,
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
        view.setLastName(String.format("Your last name: %s!", user.getLastName()));
    }

    @Override
    public void onGoToSummaryClicked(String lastNameExtra) {
        interactor.setLastNameExtra(lastNameExtra);
        navigator.goToSummary(R.id.flContainer);
    }
}
