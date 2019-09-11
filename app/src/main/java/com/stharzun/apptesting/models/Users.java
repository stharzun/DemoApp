package com.stharzun.apptesting.models;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Arjun Shrestha on 9/10/19.
 * arjunshrestha.com.np
 * stharzun@gmail.com
 */
public class Users {

    @SerializedName("login")
    private String name;

    @SerializedName("avatar_url")
    private String avatar;

    public String getName() {
        return name;
    }

    public String getAvatar() {
        return avatar;
    }
}
