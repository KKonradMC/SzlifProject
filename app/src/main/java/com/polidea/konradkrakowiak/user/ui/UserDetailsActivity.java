package com.polidea.konradkrakowiak.user.ui;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.polidea.konradkrakowiak.R;
import com.polidea.konradkrakowiak.common.ui.BaseActivity;
import com.polidea.konradkrakowiak.user.model.User;

public class UserDetailsActivity extends BaseActivity {

    static final String USER_KEY = "USER_KEY";

    @Override
    protected void inOnCreate(Bundle savedInstanceState) {
        setContentView(R.layout.activity_user_details);
    }


    public static class IntentFactory {

        public static Intent forStart(Context context, User user) {
            Intent intent = new Intent(context, UserDetailsActivity.class);
            //TODO put User as extra
            //intent.putExtra(USER_KEY, user);
            return intent;
        }
    }
}
