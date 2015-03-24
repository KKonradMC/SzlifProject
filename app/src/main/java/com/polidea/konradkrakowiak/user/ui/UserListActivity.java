package com.polidea.konradkrakowiak.user.ui;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import butterknife.ButterKnife;
import butterknife.InjectView;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.octo.android.robospice.persistence.exception.SpiceException;
import com.polidea.konradkrakowiak.R;
import com.polidea.konradkrakowiak.SzlifApplication;
import com.polidea.konradkrakowiak.common.ui.RetrofitBaseActivity;
import com.polidea.konradkrakowiak.user.model.Order;
import com.polidea.konradkrakowiak.user.model.Sort;
import com.polidea.konradkrakowiak.user.model.UserList;
import com.polidea.konradkrakowiak.user.network.UsersRequest;
import javax.inject.Inject;

public class UserListActivity extends RetrofitBaseActivity<UserList> {

    @Inject
    ImageLoader imageLoader;

    @InjectView(R.id.user_list)
    RecyclerView userList;

    UserListAdapter userListAdapter;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        SzlifApplication.component(this).inject(this);
        spiceManager.execute(new UsersRequest.Builder(Order.desc, Sort.reputation).build(), this);

        setContentView(R.layout.activity_user_list);
        ButterKnife.inject(this);
        prepareUserList();
    }

    private void prepareUserList(){
        userListAdapter = new UserListAdapter(imageLoader);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        userList.setLayoutManager(layoutManager);
        userList.setAdapter(userListAdapter);
    }

    @Override
    public void onRequestFailure(SpiceException spiceException) {

    }

    @Override
    public void onRequestSuccess(UserList users) {
        userListAdapter.addUserListAndRefresh(users);
    }
}