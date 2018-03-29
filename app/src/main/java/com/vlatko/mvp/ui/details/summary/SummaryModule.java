package com.vlatko.mvp.ui.details.summary;

import android.support.v4.app.Fragment;

import com.vlatko.mvp.di.PerFragment;
import com.vlatko.mvp.di.module.BaseFragmentModule;

import dagger.Binds;
import dagger.Module;

@Module(includes = BaseFragmentModule.class)
public abstract class SummaryModule {

    @PerFragment
    @Binds
    abstract Fragment fragment(SummaryFragment fragment);

    @PerFragment
    @Binds
    abstract SummaryContract.View summaryView(SummaryFragment fragment);

    @PerFragment
    @Binds
    abstract SummaryContract.Presenter summaryPresenter(SummaryPresenter presenter);
}
