package com.vlatko.mvp.ui.base;

import com.vlatko.mvp.data.api.Api;
import com.vlatko.mvp.data.model.Session;
import com.vlatko.mvp.data.prefs.PrefsManager;

public class BaseInteractor implements BaseContract.Interactor {

    protected final Api api;
    protected final PrefsManager prefsManager;

    public BaseInteractor(Api api, PrefsManager prefsManager) {
        this.api = api;
        this.prefsManager = prefsManager;
    }

    @Override
    public Session getSession() {
        return prefsManager.getSession();
    }

    @Override
    public void setSession(Session session) {
        prefsManager.setSession(session);
    }

    @Override
    public boolean isLoggedIn() {
        return prefsManager.isLoggedIn();
    }
}
