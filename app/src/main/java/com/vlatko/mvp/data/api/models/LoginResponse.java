package com.vlatko.mvp.data.api.models;

import com.google.gson.annotations.SerializedName;

public class LoginResponse {

    @SerializedName("id")
    String id;

    @SerializedName("userId")
    String userId;

    @SerializedName("user")
    User user;

    public String getId() {
        return id;
    }

    public String getUserId() {
        return userId;
    }

    public User getUser() {
        return user;
    }
}
