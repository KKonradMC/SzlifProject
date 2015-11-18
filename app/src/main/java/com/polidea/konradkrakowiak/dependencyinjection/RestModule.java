package com.polidea.konradkrakowiak.dependencyinjection;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.polidea.konradkrakowiak.BuildConfig;
import com.squareup.okhttp.HttpUrl;
import com.squareup.okhttp.OkHttpClient;
import dagger.Module;
import dagger.Provides;
import javax.inject.Singleton;
import retrofit.CallAdapter;
import retrofit.Converter;
import retrofit.GsonConverterFactory;
import retrofit.Retrofit;
import retrofit.RxJavaCallAdapterFactory;

@Module
public class RestModule {

    @Singleton
    @Provides
    Retrofit provideRetrofit(Retrofit.Builder builder) {
        return builder.build();
    }

    @Provides
    Retrofit.Builder provideRetrofitBuilder(
            OkHttpClient okHttpClient,
            Converter.Factory converterFactory,
            CallAdapter.Factory callAdapterFactory) {
        return new Retrofit
                .Builder()
                .baseUrl(BuildConfig.API_URL)
                .client(okHttpClient)
                .addConverterFactory(converterFactory)
                .addCallAdapterFactory(callAdapterFactory);
    }

    @Provides
    HttpUrl.Builder provideHttpUrlBuilder() {
        return new HttpUrl.Builder();
    }

    @Provides
    OkHttpClient provideOkHttpClient() {
        final OkHttpClient result = new OkHttpClient();
        return result;
    }

    @Provides
    CallAdapter.Factory provideRxCallAdapterFactory() {
        return RxJavaCallAdapterFactory.create();
    }

    @Provides
    Converter.Factory provideConverterFactory(Gson gson) {
        return GsonConverterFactory.create(gson);
    }

    @Provides
    Gson provideGson(GsonBuilder gsonBuilder) {
        return gsonBuilder.create();
    }

    @Provides
    GsonBuilder provideGsonBuilder() {
        return new GsonBuilder();
    }
}
