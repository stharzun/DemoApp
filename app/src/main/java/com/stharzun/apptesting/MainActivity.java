package com.stharzun.apptesting;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.stharzun.apptesting.adapters.UserListAdapter;
import com.stharzun.apptesting.models.Users;
import com.stharzun.apptesting.viewmodels.MainActivityViewModel;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements SearchView.OnQueryTextListener {
    private RecyclerView mRecyclerView;
    private SearchView mSearchView;

    private MainActivityViewModel mainActivityViewModel;

    private UserListAdapter mAdapter;
    private List<Users> mUsers = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mRecyclerView = findViewById(R.id.recycler_view);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mSearchView = findViewById(R.id.search_view);
        mSearchView.setOnQueryTextListener(this);

        mainActivityViewModel = ViewModelProviders.of(this).get(MainActivityViewModel.class);
        mainActivityViewModel.init();
        mainActivityViewModel.getUsers().observe(this, new Observer<List<Users>>() {
            @Override
            public void onChanged(List<Users> users) {
                mUsers.addAll(users);
                mAdapter = new UserListAdapter(mainActivityViewModel.getUsers().getValue());
                mRecyclerView.setAdapter(mAdapter);
            }
        });

    }

    @Override
    public boolean onQueryTextSubmit(String query) {
        return false;
    }

    @Override
    public boolean onQueryTextChange(String newText) {
        String s = newText.toLowerCase();
        List<Users> newList = new ArrayList<>();
        for (Users u : mUsers) {
            String uL = u.getName().toLowerCase();
            if (uL.contains(s))
                newList.add(u);
        }
        mAdapter = new UserListAdapter(newList);
        mRecyclerView.setAdapter(mAdapter);
        return false;
    }
}
