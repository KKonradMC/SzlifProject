package com.polidea.konradkrakowiak.user.ui;

import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.polidea.konradkrakowiak.R;
import com.polidea.konradkrakowiak.SzlifApplication;
import com.polidea.konradkrakowiak.common.ui.BaseActivity;
import com.polidea.konradkrakowiak.common.ui.ToastFactory;
import com.polidea.konradkrakowiak.user.model.Order;
import com.polidea.konradkrakowiak.user.model.Sort;
import com.polidea.konradkrakowiak.user.model.User;
import com.polidea.konradkrakowiak.user.model.UserList;
import com.polidea.konradkrakowiak.user.network.UsersRequest;
import javax.inject.Inject;
import javax.inject.Provider;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class UserListActivity extends BaseActivity implements SwipeRefreshLayout.OnRefreshListener, Callback<UserList> {

    @Inject
    ToastFactory toastFactory;

    @Inject
    ImageLoader imageLoader;

    @BindView(R.id.user_list)
    RecyclerView userList;

    UserListAdapter userListAdapter;

    @BindView(R.id.swipe_to_refresh)
    SwipeRefreshLayout swipeRefreshLayout;

    @Inject
    Provider<UsersRequest> usersRequestProvider;

    @Override
    public void inOnCreate(Bundle savedInstanceState) {
        SzlifApplication.component(this).inject(this);
        usersRequestProvider.get().setOrder(Order.desc).setSort(Sort.reputation).callUserReqquest().enqueue(this);

        setContentView(R.layout.activity_user_list);
        ButterKnife.bind(this);
        prepareUserList();
        swipeRefreshLayout.setOnRefreshListener(this);
    }

    private void prepareUserList() {
        userListAdapter = new UserListAdapter(imageLoader);
        userListAdapter.setOnUserItemClickListener(new UserListAdapter.OnUserItemClickListener() {
            @Override
            public void onUserItemClick(User user) {
                startActivity(UserDetailsActivity.IntentFactory.forStart(UserListActivity.this, user));
            }
        });
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        userList.setLayoutManager(layoutManager);
        userList.setAdapter(userListAdapter);
    }

    @Override
    public void onRefresh() {
        usersRequestProvider.get().setOrder(Order.desc).setSort(Sort.reputation).setInName("Konrad").callUserReqquest().enqueue(this);
    }

    @Override
    public void onResponse(Call<UserList> call, Response<UserList> response) {
        userListAdapter.clearAndAddUserListAndRefresh(response.body());
        swipeRefreshLayout.setRefreshing(false);
    }

    @Override
    public void onFailure(Call<UserList> call, Throwable t) {
        swipeRefreshLayout.setRefreshing(false);
        toastFactory.showError(this, t.getMessage());

    }
}
