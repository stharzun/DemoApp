package com.stharzun.apptesting.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.stharzun.apptesting.R;
import com.stharzun.apptesting.models.Users;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

/**
 * Created by Arjun Shrestha on 9/10/19.
 * arjunshrestha.com.np
 * stharzun@gmail.com
 */
public class UserListAdapter extends RecyclerView.Adapter<UserListAdapter.MyViewHolder> {

    private List<Users> mUsers;

    public UserListAdapter(List<Users> users) {
        this.mUsers = users;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new MyViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.adapter_user_list, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        Glide.with(holder.itemView.getContext()).load(this.mUsers.get(position).getAvatar()).into(holder.avatar);
        holder.name.setText(this.mUsers.get(position).getName());
    }

    @Override
    public int getItemCount() {
        if (this.mUsers == null)
            return 0;
        else
            return this.mUsers.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {
        private CircleImageView avatar;
        private TextView name;

        MyViewHolder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.user_name);
            avatar = itemView.findViewById(R.id.user_avatar);
        }
    }
}
