package com.stharzun.apptesting.repositories;

import androidx.lifecycle.MutableLiveData;

import com.stharzun.apptesting.ApiClient;
import com.stharzun.apptesting.models.Users;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Arjun Shrestha on 9/10/19.
 * arjunshrestha.com.np
 * stharzun@gmail.com
 */
public class UserRepository {
    private static UserRepository instance;

    public static UserRepository getInstance() {
        if (instance == null) {
            instance = new UserRepository();
        }
        return instance;
    }

    public MutableLiveData<List<Users>> getUsers() {
        final MutableLiveData<List<Users>> m = new MutableLiveData<>();
        String baseUrl = "https://api.github.com/";
        Retrofit retrofit = new Retrofit.Builder().baseUrl(baseUrl).addConverterFactory(GsonConverterFactory.create()).build();
        ApiClient apiClient = retrofit.create(ApiClient.class);
        Call<List<Users>> call = apiClient.getUsers();
        call.enqueue(new Callback<List<Users>>() {
            @Override
            public void onResponse(Call<List<Users>> call, Response<List<Users>> response) {
                if (!response.isSuccessful()) {
                    return;
                }
                m.setValue(response.body());
            }

            @Override
            public void onFailure(Call<List<Users>> call, Throwable t) {
                t.printStackTrace();
            }
        });

        return m;
    }
}
