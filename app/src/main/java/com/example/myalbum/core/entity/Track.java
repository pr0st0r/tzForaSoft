package com.example.myalbum.core.entity;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Сущность песня
 * trackName - название песни
 * trackPrice - цена песни
 * previewUrl - прослушивание песни
 * trackTimeMillis - время песни в миллисекундах
 */
public class Track implements Serializable {
    @SerializedName("trackName")
    @Expose
    private String mTrackName;
    @SerializedName("trackPrice")
    @Expose
    private double mTrackPrice;
    @SerializedName("previewUrl")
    @Expose
    private String mPreviewUrl;
    @SerializedName("trackTimeMillis")
    @Expose
    private int mTrackTimeMillis;

    public String getTrackName() {
        return mTrackName;
    }

    public void setTrackName(String trackName) {
        mTrackName = trackName;
    }

    public double getTrackPrice() {
        return mTrackPrice;
    }

    public void setTrackPrice(double trackPrice) {
        mTrackPrice = trackPrice;
    }

    public String getPreviewUrl() {
        return mPreviewUrl;
    }

    public void setPreviewUrl(String previewUrl) {
        mPreviewUrl = previewUrl;
    }

    public int getTrackTimeMillis() {
        return mTrackTimeMillis;
    }

    public void setTrackTimeMillis(int trackTimeMillis) {
        mTrackTimeMillis = trackTimeMillis;
    }
}