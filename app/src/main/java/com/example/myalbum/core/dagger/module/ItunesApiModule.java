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
        return new Retrofit.Builder()
                .baseUrl("https://itunes.apple.com")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    @Provides
    @Singleton
    ItunesApi getItunesApi(Retrofit retrofit){
        return retrofit.create(ItunesApi.class);
    }
}
