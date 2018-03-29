package com.vlatko.mvp.ui.details.last_name;

import android.support.v4.app.Fragment;

import com.vlatko.mvp.di.PerFragment;
import com.vlatko.mvp.di.module.BaseFragmentModule;

import dagger.Binds;
import dagger.Module;

@Module(includes = BaseFragmentModule.class)
public abstract class LastNameModule {

    @PerFragment
    @Binds
    abstract Fragment fragment(LastNameFragment fragment);

    @PerFragment
    @Binds
    abstract LastNameContract.View lastNameView(LastNameFragment fragment);

    @PerFragment
    @Binds
    abstract LastNameContract.Presenter lastNamePresenter(LastNamePresenter presenter);
}
