package com.stharzun.apptesting.viewmodels;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.stharzun.apptesting.models.Users;
import com.stharzun.apptesting.repositories.UserRepository;

import java.util.List;

/**
 * Created by Arjun Shrestha on 9/10/19.
 * arjunshrestha.com.np
 * stharzun@gmail.com
 */
public class MainActivityViewModel extends ViewModel {
    private MutableLiveData<List<Users>> mUsers;
    private UserRepository mUserRepository;

    public void init() {
        if (mUsers != null) {
            return;
        }
        mUserRepository = UserRepository.getInstance();
        mUsers = mUserRepository.getUsers();
    }

    public LiveData<List<Users>> getUsers() {
        return mUsers;
    }
}
