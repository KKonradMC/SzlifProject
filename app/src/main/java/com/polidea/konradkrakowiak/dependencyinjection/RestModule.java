package com.polidea.konradkrakowiak.dependencyinjection;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.octo.android.robospice.SpiceManager;
import com.polidea.konradkrakowiak.BuildConfig;
import com.polidea.konradkrakowiak.network.SzlifSpiceManagerService;
import com.polidea.konradkrakowiak.user.model.UserType;
import com.polidea.konradkrakowiak.user.model.UserTypeDeserializer;
import dagger.Module;
import dagger.Provides;
import javax.inject.Singleton;
import retrofit.RestAdapter;
import retrofit.converter.GsonConverter;

@Module
public class RestModule {

    @Provides
    @Singleton
    GsonConverter provideGsonConverter(Gson gson) {
        return new GsonConverter(gson);
    }

    @Provides
    @Singleton
    Gson provideMainGson() {
        return new GsonBuilder()
                .registerTypeAdapter(UserType.class, new UserTypeDeserializer())
                .create();
    }

    @Provides
    SpiceManager provideSpiceManager() {
        return new SpiceManager(SzlifSpiceManagerService.class);
    }

    @Provides
    @Singleton
    RestAdapter.Builder provideRestAdapterBuilder(GsonConverter gsonConverter) {

        return new RestAdapter.Builder()
                .setConverter(gsonConverter)
                .setLogLevel(BuildConfig.DEBUG ? RestAdapter.LogLevel.FULL : RestAdapter.LogLevel.NONE)
                .setEndpoint(BuildConfig.API_URL);
    }
}
