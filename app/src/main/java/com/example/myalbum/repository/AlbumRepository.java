package com.example.myalbum.repository;

import com.example.myalbum.core.entity.Album;
import com.example.myalbum.core.retrofit.dto.ResponseItunesApi;

import java.io.IOException;

import retrofit2.Response;

public interface AlbumRepository {
    /**
     * Загрузка альбомов
     * @param term - чей альбом ищем
     * @return
     */
    Response<ResponseItunesApi<Album>> getAlbum(String term) throws IOException;
}
