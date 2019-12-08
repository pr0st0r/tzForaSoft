package com.example.myalbum.repository;

import com.example.myalbum.core.entity.Track;
import com.example.myalbum.core.retrofit.dto.ResponseItunesApi;

import java.io.IOException;

import retrofit2.Response;

public interface TrackRepository {
    /**
     * Получение списка треков
     * @param id - айди альбома
     * @return
     */
    Response<ResponseItunesApi<Track>> getTracks(long id) throws IOException;
}
