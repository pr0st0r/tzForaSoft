package com.example.myalbum;

import android.app.Application;

import com.example.myalbum.core.dagger.component.AppComponent;
import com.example.myalbum.core.dagger.component.DaggerAppComponent;

public class App extends Application {

    public static String ALBUM_TRANSFER = "album transfer";
    private static AppComponent sComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        sComponent = DaggerAppComponent.create();
    }

    public static AppComponent getComponent() {
        return sComponent;
    }
}
