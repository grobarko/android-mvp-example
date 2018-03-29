package com.vlatko.mvp.data.model;

import com.vlatko.mvp.data.api.models.User;

public class Session {
    private User user;
    private String accessToken;

    public Session(User user, String accessToken) {
        this.user = user;
        this.accessToken = accessToken;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }
}
