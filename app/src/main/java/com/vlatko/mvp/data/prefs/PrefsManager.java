package com.vlatko.mvp.data.prefs;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.annotation.Nullable;

import com.google.gson.Gson;
import com.vlatko.mvp.data.model.Session;
import com.vlatko.mvp.di.ApplicationContext;
import com.vlatko.mvp.utils.AppConstants;
import com.vlatko.mvp.utils.StringUtils;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class PrefsManager {

    private static final String PREFS_KEY_SESSION = "PREFS_KEY_SESSION";

    private final SharedPreferences prefs;
    private final Gson gson;
    private final StringUtils stringUtils;

    @Inject
    public PrefsManager(@ApplicationContext Context context, Gson gson, StringUtils stringUtils) {
        this.prefs = context.getSharedPreferences(AppConstants.PREFS_NAME, Context.MODE_PRIVATE);
        this.gson = gson;
        this.stringUtils = stringUtils;
    }

    public Session getSession() {
        return gson.fromJson(prefs.getString(PREFS_KEY_SESSION, "{}"), Session.class);
    }

    public void setSession(@Nullable Session session) {
        String json = session == null ? "{}" : gson.toJson(session);
        prefs.edit().putString(PREFS_KEY_SESSION, json).apply();
    }

    public boolean isLoggedIn() {
        Session session = getSession();
        return session != null && !stringUtils.isEmpty(session.getAccessToken());
    }
}
