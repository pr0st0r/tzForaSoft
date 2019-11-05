package com.example.myalbum.core.dagger.component;

import com.example.myalbum.MainActivity;
import com.example.myalbum.core.dagger.module.ItunesApiModule;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = ItunesApiModule.class)
public interface AppComponent {
    void inject(MainActivity activity);
    //void injectDetail(DetailAlbum activity);
}
