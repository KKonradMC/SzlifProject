package com.polidea.konradkrakowiak.common.ui;

import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import butterknife.InjectView;
import butterknife.Optional;
import com.polidea.konradkrakowiak.R;

public abstract class BaseActivity extends ActionBarActivity {

    @Optional
    @InjectView(R.id.toolbar)
    protected Toolbar toolbar;

    @Override
    public final void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        inOnCreate(savedInstanceState);
        if (toolbar != null) {
            setSupportActionBar(toolbar);
        }

        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(item.getItemId() == android.R.id.home){
            onBackPressed();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    protected abstract void inOnCreate(Bundle savedInstanceState);
}
