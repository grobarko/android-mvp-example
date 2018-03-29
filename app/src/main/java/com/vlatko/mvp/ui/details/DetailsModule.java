package com.vlatko.mvp.ui.details;

import android.support.v7.app.AppCompatActivity;

import com.vlatko.mvp.di.PerActivity;
import com.vlatko.mvp.di.PerFragment;
import com.vlatko.mvp.di.module.BaseActivityModule;
import com.vlatko.mvp.ui.details.first_name.FirstNameFragment;
import com.vlatko.mvp.ui.details.first_name.FirstNameModule;
import com.vlatko.mvp.ui.details.last_name.LastNameFragment;
import com.vlatko.mvp.ui.details.last_name.LastNameModule;
import com.vlatko.mvp.ui.details.summary.SummaryFragment;
import com.vlatko.mvp.ui.details.summary.SummaryModule;

import dagger.Binds;
import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module(includes = BaseActivityModule.class)
public abstract class DetailsModule {

    @PerActivity
    @Binds
    abstract AppCompatActivity appCompatActivity(DetailsActivity activity);

    @PerActivity
    @Binds
    abstract DetailsContract.View detailsView(DetailsActivity activity);

    @PerActivity
    @Binds
    abstract DetailsContract.Presenter detailsPresenter(DetailsPresenter presenter);

    @PerActivity
    @Binds
    abstract DetailsContract.Interactor detailsInteractor(DetailsInteractor interactor);

    @PerActivity
    @Binds
    abstract DetailsContract.Navigator detailsNavigator(DetailsNavigator navigator);

    @PerFragment
    @ContributesAndroidInjector(modules = FirstNameModule.class)
    abstract FirstNameFragment firstNameFragment();

    @PerFragment
    @ContributesAndroidInjector(modules = LastNameModule.class)
    abstract LastNameFragment lastNameFragment();

    @PerFragment
    @ContributesAndroidInjector(modules = SummaryModule.class)
    abstract SummaryFragment summaryFragment();
}
