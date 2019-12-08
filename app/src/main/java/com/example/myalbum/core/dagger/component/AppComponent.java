package com.example.myalbum.core.dagger.component;

import com.example.myalbum.core.dagger.module.ItunesApiModule;
import com.example.myalbum.core.viewmodel.MainViewModel;
import com.example.myalbum.core.viewmodel.TrackViewModel;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = ItunesApiModule.class)
public interface AppComponent {
    void inject(MainViewModel mainViewModel);
    void injectTrack(TrackViewModel trackViewModel);
}
