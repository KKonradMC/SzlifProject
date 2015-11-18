package com.polidea.konradkrakowiak;

import android.app.Application;
import android.content.Context;
import com.polidea.konradkrakowiak.dependencyinjection.SzlifAppComponent;

public class SzlifApplication extends Application{

    SzlifAppComponent appComponent;
    @Override
    public void onCreate() {
        super.onCreate();
        buildComponentAndInject();
    }

    public void buildComponentAndInject() {
        appComponent = SzlifAppComponent.Initializer.init(this);
    }

    public static SzlifAppComponent component(Context context) {
        return ((SzlifApplication) context.getApplicationContext()).appComponent;
    }
}
