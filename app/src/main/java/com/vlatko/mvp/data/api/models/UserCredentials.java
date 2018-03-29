package com.vlatko.mvp.data.api.models;

import com.google.gson.annotations.SerializedName;

public class UserCredentials {

    @SerializedName("email")
    String email;

    @SerializedName("password")
    String password;

    public UserCredentials(String email, String password) {
        this.email = email;
        this.password = password;
    }
}
