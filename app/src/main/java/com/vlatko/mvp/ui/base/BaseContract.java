package com.vlatko.mvp.ui.base;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.StringRes;

import com.vlatko.mvp.data.model.Session;

public interface BaseContract {
    interface View {
        void showToast(String message, int duration);

        void showToast(@StringRes int message, int duration);
    }

    interface Presenter {
        void initialize(@Nullable Bundle bundle);

        void start();

        void stop();

        void destroy();
    }

    interface Interactor {
        Session getSession();

        void setSession(Session session);

        boolean isLoggedIn();
    }

    interface Navigator {
        void startActivity(@NonNull final Class<?> cls);

        void finishActivity();
    }
}
