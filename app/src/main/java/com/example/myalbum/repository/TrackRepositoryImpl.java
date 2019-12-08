package com.example.myalbum.repository;

import com.example.myalbum.core.entity.Track;
import com.example.myalbum.core.retrofit.dto.ResponseItunesApi;
import com.example.myalbum.core.retrofit.itunesApi.ItunesApi;

import java.io.IOException;

import javax.inject.Inject;
import retrofit2.Response;

public class TrackRepositoryImpl implements TrackRepository{

    private ItunesApi mItunesApi;

    @Inject
    TrackRepositoryImpl(ItunesApi itunesApi){
        this.mItunesApi = itunesApi;
    }

    @Override
    public Response<ResponseItunesApi<Track>> getTracks(long id) throws IOException {
        return mItunesApi.getTracks(id, "song").execute();
    }
}
