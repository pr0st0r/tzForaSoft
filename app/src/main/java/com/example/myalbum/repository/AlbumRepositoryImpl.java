package com.example.myalbum.repository;

import com.example.myalbum.core.entity.Album;
import com.example.myalbum.core.retrofit.dto.ResponseItunesApi;
import com.example.myalbum.core.retrofit.itunesApi.ItunesApi;

import java.io.IOException;

import javax.inject.Inject;

import retrofit2.Response;


public class AlbumRepositoryImpl implements AlbumRepository{

    private ItunesApi itunesApi;

    @Inject
    AlbumRepositoryImpl(ItunesApi itunesApi){
        this.itunesApi = itunesApi;
    }

    @Override
    public Response<ResponseItunesApi<Album>> getAlbum(String term) throws IOException {
        return itunesApi.getAlbums(term, "album", "ru").execute();
    }
}
