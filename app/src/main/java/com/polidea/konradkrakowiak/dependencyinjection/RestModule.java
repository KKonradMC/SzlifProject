package com.polidea.konradkrakowiak.dependencyinjection;

import com.octo.android.robospice.SpiceManager;
import com.polidea.konradkrakowiak.BuildConfig;
import com.polidea.konradkrakowiak.network.SzlifSpiceManagerService;
import dagger.Module;
import dagger.Provides;
import javax.inject.Singleton;
import retrofit.RestAdapter;

@Module
public class RestModule {

    @Provides
    SpiceManager provideSpiceManager() {
        return new SpiceManager(SzlifSpiceManagerService.class);
    }

    @Provides
    @Singleton
    RestAdapter.Builder provideRestAdapterBuilder() {

        return new RestAdapter.Builder()
                .setLogLevel(BuildConfig.DEBUG ? RestAdapter.LogLevel.FULL : RestAdapter.LogLevel.NONE)
                .setEndpoint(BuildConfig.API_URL);
    }
}
