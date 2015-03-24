package com.polidea.konradkrakowiak.user.ui;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.ButterKnife;
import butterknife.InjectView;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.polidea.konradkrakowiak.R;
import com.polidea.konradkrakowiak.user.model.User;
import com.polidea.konradkrakowiak.user.model.UserList;
import java.util.LinkedList;
import java.util.List;

public class UserListAdapter extends RecyclerView.Adapter<UserListAdapter.ViewHolder> {


    private final List<User> list;

    private final ImageLoader imageLoader;

    OnUserItemClickListener onUserItemClickListener = OnUserItemClickListener.NULL;

    public UserListAdapter(ImageLoader imageLoader) {
        list = new LinkedList<>();
        this.imageLoader = imageLoader;
    }

    public void addUserListAndRefresh(UserList userList) {
        for (final User user : userList) {
            list.add(user);
        }
        notifyDataSetChanged();
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        final View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.view_user_list_item, viewGroup, false);
        final ViewHolder viewHolder = new ViewHolder(view, imageLoader);
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onUserItemClickListener.onUserItemClick(list.get(viewHolder.getPosition()));
                ;
            }
        });
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, int i) {

        viewHolder.bind(list.get(i));
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public void setOnUserItemClickListener(OnUserItemClickListener onUserItemClickListener) {
        this.onUserItemClickListener = onUserItemClickListener != null ? onUserItemClickListener : OnUserItemClickListener.NULL;
    }

    static class ViewHolder extends RecyclerView.ViewHolder {

        private final Context context;

        @InjectView(R.id.user_item_photo)
        ImageView photo;

        @InjectView(R.id.user_item_name)
        TextView name;

        @InjectView(R.id.user_item_reputation)
        TextView reputation;

        @InjectView(R.id.user_item_badges)
        BadgeView badgeView;

        private final ImageLoader imageLoader;

        ViewHolder(View itemView, ImageLoader imageLoader) {
            super(itemView);
            this.imageLoader = imageLoader;
            ButterKnife.inject(this, itemView);
            context = itemView.getContext();
        }

        void bind(User user) {
            name.setText(user.getDisplayName());
            imageLoader.displayImage(user.getProfileImage(), photo);
            reputation.setText(String.format(context.getString(R.string.reputation), user.getReputation()));
            badgeView.setBadges(user.getBadgeCounts());
        }
    }

    public interface OnUserItemClickListener {

        OnUserItemClickListener NULL = new OnUserItemClickListener() {
            @Override
            public void onUserItemClick(User user) {

            }
        };

        public void onUserItemClick(User user);
    }
}
