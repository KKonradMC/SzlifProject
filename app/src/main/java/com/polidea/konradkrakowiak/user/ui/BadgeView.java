package com.polidea.konradkrakowiak.user.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.LinearLayout;
import android.widget.TextView;
import butterknife.Bind;
import butterknife.ButterKnife;
import com.polidea.konradkrakowiak.R;
import com.polidea.konradkrakowiak.user.model.BadgeCounts;

public class BadgeView extends LinearLayout {

    @Bind(R.id.gold_badge_view)
    TextView goldBadge;

    @Bind(R.id.silver_badge_view)
    TextView silverBadge;

    @Bind(R.id.bronze_badge_view)
    TextView bronzeBadge;

    public BadgeView(Context context, AttributeSet attrs) {
        super(context, attrs);
        initView(context);
        ButterKnife.bind(this);
    }

    private void initView(Context context) {
        LayoutInflater.from(context).inflate(R.layout.view_bagdes, this);
    }

    public void setBadges(BadgeCounts badges) {
        if (badges == null) {
            return;
        }
        goldBadge.setText(String.valueOf(badges.getGold()));
        silverBadge.setText(String.valueOf(badges.getSilver()));
        bronzeBadge.setText(String.valueOf(badges.getBronze()));
    }
}
