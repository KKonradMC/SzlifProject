package com.polidea.konradkrakowiak.network;

import com.octo.android.robospice.retrofit.RetrofitGsonSpiceService;
import com.polidea.konradkrakowiak.BuildConfig;
import com.polidea.konradkrakowiak.SzlifApplication;
import javax.inject.Inject;
import retrofit.RestAdapter;

public class SzlifSpiceManagerService extends RetrofitGsonSpiceService {

    @Inject
    RestAdapter.Builder restAdapterBuilder;

    @Override
    public void onCreate() {
        SzlifApplication.component(this).inject(this);
        super.onCreate();
    }

    @Override
    protected String getServerUrl() {
        throw new UnsupportedOperationException();
    }

    @Override
    protected RestAdapter.Builder createRestAdapterBuilder() {
        return restAdapterBuilder;
    }
}
