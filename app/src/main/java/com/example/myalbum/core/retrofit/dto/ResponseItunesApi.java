package com.example.myalbum.core.retrofit.dto;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

/**
 * Класс ответа от itunes api
 * resultCount - количество элементов
 * results - список элеметов
 * @param <T> - получаймый объект
 */
public class ResponseItunesApi<T> implements Serializable {
    @SerializedName("resultCount")
    @Expose
    private int mResultCount;
    @SerializedName("results")
    @Expose
    private List<T> mResults;

    public int getResultCount() {
        return mResultCount;
    }

    public void setResultCount(int resultCount) {
        mResultCount = resultCount;
    }

    public List<T> getResults() {
        return mResults;
    }

    public void setResults(List<T> results) {
        mResults = results;
    }
}