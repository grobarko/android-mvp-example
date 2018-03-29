package com.vlatko.mvp.di.components;

import com.vlatko.mvp.MvpApp;
import com.vlatko.mvp.di.module.ActivityBindingModule;
import com.vlatko.mvp.di.module.AppModule;

import javax.inject.Singleton;

import dagger.BindsInstance;
import dagger.Component;
import dagger.android.AndroidInjector;
import dagger.android.support.AndroidSupportInjectionModule;

@Singleton
@Component(modules = {
        AppModule.class,
        ActivityBindingModule.class,
        AndroidSupportInjectionModule.class
})
public interface AppComponent extends AndroidInjector<MvpApp> {

    @Component.Builder
    interface Builder {

        @BindsInstance
        AppComponent.Builder application(MvpApp application);

        AppComponent build();
    }
}
