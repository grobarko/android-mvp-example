package com.vlatko.mvp.ui.details.first_name;

import android.support.v4.app.Fragment;

import com.vlatko.mvp.di.PerFragment;
import com.vlatko.mvp.di.module.BaseFragmentModule;

import dagger.Binds;
import dagger.Module;

@Module(includes = BaseFragmentModule.class)
public abstract class FirstNameModule {

    @PerFragment
    @Binds
    abstract Fragment fragment(FirstNameFragment fragment);

    @PerFragment
    @Binds
    abstract FirstNameContract.View firstNameView(FirstNameFragment fragment);

    @PerFragment
    @Binds
    abstract FirstNameContract.Presenter firstNamePresenter(FirstNamePresenter presenter);
}
