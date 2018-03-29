package com.vlatko.mvp.ui.details;

import com.vlatko.mvp.data.api.Api;
import com.vlatko.mvp.data.prefs.PrefsManager;
import com.vlatko.mvp.di.PerActivity;
import com.vlatko.mvp.ui.base.BaseInteractor;

import javax.inject.Inject;

@PerActivity
public class DetailsInteractor extends BaseInteractor implements DetailsContract.Interactor {

    // Instead of here, these will be stored in DetailsRepository.
    private String firstNameExtra;
    private String lastNameExtra;

    @Inject
    DetailsInteractor(Api api, PrefsManager prefsManager) {
        super(api, prefsManager);
    }

    @Override
    public void setFirstNameExtra(String firstNameExtra) {
        this.firstNameExtra = firstNameExtra;
    }

    @Override
    public String getFirstNameExtra() {
        return firstNameExtra;
    }

    @Override
    public void setLastNameExtra(String lastNameExtra) {
        this.lastNameExtra = lastNameExtra;
    }

    @Override
    public String getLastNameExtra() {
        return lastNameExtra;
    }
}
