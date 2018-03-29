package com.vlatko.mvp.ui.home;

import com.vlatko.mvp.data.api.Api;
import com.vlatko.mvp.data.prefs.PrefsManager;
import com.vlatko.mvp.di.PerActivity;
import com.vlatko.mvp.ui.base.BaseInteractor;

import javax.inject.Inject;

@PerActivity
public class HomeInteractor extends BaseInteractor implements HomeContract.Interactor {

    @Inject
    public HomeInteractor(Api api, PrefsManager prefsManager) {
        super(api, prefsManager);
    }
}
