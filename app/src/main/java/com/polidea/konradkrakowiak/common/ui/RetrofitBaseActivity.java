package com.polidea.konradkrakowiak.common.ui;

import com.octo.android.robospice.SpiceManager;
import com.octo.android.robospice.request.listener.RequestListener;
import javax.inject.Inject;

public abstract class RetrofitBaseActivity<RESULT> extends BaseActivity implements RequestListener<RESULT> {

    @Inject
    protected SpiceManager spiceManager;

    @Override
    protected void onStart() {
        super.onStart();
        spiceManager.start(this);
    }

    @Override
    protected void onStop() {
        super.onStop();
        spiceManager.shouldStop();
    }
}
