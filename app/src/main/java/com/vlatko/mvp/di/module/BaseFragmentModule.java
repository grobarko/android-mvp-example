package com.vlatko.mvp.di.module;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;

import com.vlatko.mvp.di.ChildFragmentManager;
import com.vlatko.mvp.di.PerFragment;

import dagger.Module;
import dagger.Provides;

@Module
public abstract class BaseFragmentModule {

    @Provides
    @PerFragment
    @ChildFragmentManager
    static FragmentManager childFragmentManager(Fragment fragment) {
        return fragment.getChildFragmentManager();
    }
}
