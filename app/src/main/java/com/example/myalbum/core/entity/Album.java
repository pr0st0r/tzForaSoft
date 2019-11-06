package com.example.myalbum.core.entity;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Сущность альбом
 * collectionId - id альбома
 * artistName - имя артиста альбома
 * collectionName - название альбома
 * collectionPrice - цена альбома
 * trackCount - колличество треков в альбоме
 * currency - валюта
 * releaseDate - дата выхода
 * primaryGenreName - тип альбома
 * cover - обложка
 */
public class Album implements Serializable {
    @SerializedName("collectionId")
    @Expose
    private long mCollectionId;
    @SerializedName("artistName")
    @Expose
    private String mArtistName;
    @SerializedName("collectionName")
    @Expose
    private String mCollectionName;
    @SerializedName("collectionPrice")
    @Expose
    private double mCollectionPrice;
    @SerializedName("trackCount")
    @Expose
    private int mTrackCount;
    @SerializedName("currency")
    @Expose
    private String mCurrency;
    @SerializedName("releaseDate")
    @Expose
    private String mReleaseDate;
    @SerializedName("primaryGenreName")
    @Expose
    private String mPrimaryGenreName;
    @SerializedName("artworkUrl100")
    @Expose
    private String mCover;

    public long getCollectionId() {
        return mCollectionId;
    }

    public void setCollectionId(long collectionId) {
        mCollectionId = collectionId;
    }

    public String getArtistName() {
        return mArtistName;
    }

    public void setArtistName(String artistName) {
        mArtistName = artistName;
    }

    public String getCollectionName() {
        return mCollectionName;
    }

    public void setCollectionName(String collectionName) {
        mCollectionName = collectionName;
    }

    public double getCollectionPrice() {
        return mCollectionPrice;
    }

    public void setCollectionPrice(double collectionPrice) {
        mCollectionPrice = collectionPrice;
    }

    public int getTrackCount() {
        return mTrackCount;
    }

    public void setTrackCount(int trackCount) {
        mTrackCount = trackCount;
    }

    public String getCurrency() {
        return mCurrency;
    }

    public void setCurrency(String currency) {
        mCurrency = currency;
    }

    public String getReleaseDate() {
        return mReleaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        mReleaseDate = releaseDate;
    }

    public String getPrimaryGenreName() {
        return mPrimaryGenreName;
    }

    public void setPrimaryGenreName(String primaryGenreName) {
        mPrimaryGenreName = primaryGenreName;
    }

    public String getCover() {
        return mCover;
    }

    public void setCover(String cover) {
        mCover = cover;
    }
}