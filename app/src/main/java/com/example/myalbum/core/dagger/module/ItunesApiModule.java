package com.example.myalbum.core.dagger.module;

import com.example.myalbum.core.retrofit.itunesApi.ItunesApi;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

@Module
public class ItunesApiModule {

    @Provides
    @Singleton
    Retrofit getRetrofit(){
        String apitunsLink = "https://itunes.apple.com";
        return new Retrofit.Builder()
                .baseUrl(apitunsLink)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    @Provides
    @Singleton
    ItunesApi getItunesApi(Retrofit retrofit){
        return retrofit.create(ItunesApi.class);
    }
}
