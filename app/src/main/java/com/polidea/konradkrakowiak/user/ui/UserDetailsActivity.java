package com.polidea.konradkrakowiak.user.ui;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import butterknife.Bind;
import butterknife.ButterKnife;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.polidea.konradkrakowiak.R;
import com.polidea.konradkrakowiak.SzlifApplication;
import com.polidea.konradkrakowiak.common.ui.BaseActivity;
import com.polidea.konradkrakowiak.common.ui.ToastFactory;
import com.polidea.konradkrakowiak.user.model.User;
import javax.inject.Inject;
import org.parceler.Parcels;

public class UserDetailsActivity extends BaseActivity {

    static final String USER_KEY = "USER_KEY";

    @Inject
    ToastFactory toastFactory;

    @Inject
    ImageLoader imageLoader;

    @Bind(R.id.user_details_img)
    ImageView mUserDetailsImg;

    @Bind(R.id.user_details_name)
    TextView mUserDetailsName;

    @Bind(R.id.user_details_reputation)
    TextView mUserDetailsReputation;

    @Bind(R.id.user_details_badges)
    BadgeView mUserDetailsBadges;

    @Bind(R.id.photo_container)
    LinearLayout mPhotoContainer;

    @Bind(R.id.user_details_website)
    TextView mUserDetailsWebsite;

    @Bind(R.id.user_details_age)
    TextView mUserDetailsAge;

    @Bind(R.id.user_details_location)
    TextView mUserDetailsLocation;

    @Bind(R.id.user_details_reputation_change_year)
    TextView mUserDetailsReputationChangeYear;

    @Bind(R.id.user_details_reputation_change_quarter)
    TextView mUserDetailsReputationChangeQuarter;

    @Bind(R.id.user_details_reputation_change_month)
    TextView mUserDetailsReputationChangeMonth;

    @Bind(R.id.user_details_reputation_change_week)
    TextView mUserDetailsReputationChangeWeek;

    @Bind(R.id.user_details_reputation_change_day)
    TextView mUserDetailsReputationChangeDay;

    @Override
    protected void inOnCreate(Bundle savedInstanceState) {
        setContentView(R.layout.activity_user_details);
        ButterKnife.bind(this);
        SzlifApplication.component(this).inject(this);
        Intent intent = getIntent();
        if (intent != null) {
            User user = Parcels.unwrap(intent.getParcelableExtra(USER_KEY));

            imageLoader.displayImage(user.getProfileImage(), mUserDetailsImg);
            mUserDetailsName.setText(user.getDisplayName());
        }
        toastFactory.showInfo(this, "Testowa wiadomosc");
    }


    public static class IntentFactory {

        public static Intent forStart(Context context, User user) {
            Intent intent = new Intent(context, UserDetailsActivity.class);
            //TODO put User as extra
            intent.putExtra(USER_KEY, Parcels.wrap(user));
            return intent;
        }
    }
}
