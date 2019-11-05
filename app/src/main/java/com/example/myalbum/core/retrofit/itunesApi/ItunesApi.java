package com.example.myalbum.core.retrofit.itunesApi;

import com.example.myalbum.core.entity.Album;
import com.example.myalbum.core.entity.Track;
import com.example.myalbum.core.retrofit.dto.ResponseItunesApi;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ItunesApi {
    /**
     * Поиск альбомов по исполнителю
     * @param term - имя исполнителя
     * @param entity - сущность
     * @return ResponseItunesApi
     */
    @GET("/search")
    Call<ResponseItunesApi<Album>> getAlbums(@Query("term") String term, @Query("entity") String entity, @Query("country") String country);

    /**
     * Поиск треков
     * @param id - альбома
     * @param entity - сущность
     * @return ResponseItunesApi
     */
    @GET("/lookup")
    Call<ResponseItunesApi<Track>> getTracks(@Query("id") long id, @Query("entity") String entity);
}

