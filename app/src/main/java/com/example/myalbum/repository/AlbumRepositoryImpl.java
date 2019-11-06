package com.example.myalbum.repository;

import com.example.myalbum.core.entity.Album;
import com.example.myalbum.core.retrofit.dto.ResponseItunesApi;
import com.example.myalbum.core.retrofit.itunesApi.ItunesApi;

import java.io.IOException;

import javax.inject.Inject;

import retrofit2.Response;


public class AlbumRepositoryImpl implements AlbumRepository{

    private ItunesApi mItunesApi;

    @Inject
    AlbumRepositoryImpl(ItunesApi itunesApi){
        this.mItunesApi = itunesApi;
    }

    @Override
    public Response<ResponseItunesApi<Album>> getAlbum(String term) throws IOException {
        return mItunesApi.getAlbums(term, "album", "ru").execute();
    }
}
