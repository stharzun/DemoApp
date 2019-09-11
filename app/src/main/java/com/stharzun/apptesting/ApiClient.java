package com.stharzun.apptesting;

import com.stharzun.apptesting.models.Users;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by Arjun Shrestha on 9/10/19.
 * arjunshrestha.com.np
 * stharzun@gmail.com
 */
public interface ApiClient {

    @GET("users")
    Call<List<Users>> getUsers();
}
