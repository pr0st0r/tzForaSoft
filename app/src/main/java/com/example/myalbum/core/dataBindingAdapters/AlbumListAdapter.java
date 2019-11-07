package com.example.myalbum.core.dataBindingAdapters;

import android.widget.ImageButton;

import androidx.databinding.BindingAdapter;

import com.bumptech.glide.Glide;

public class AlbumListAdapter {
    @BindingAdapter("android:src")
    public static void loadImage(ImageButton imageView, String imageUrl) {
        Glide.with(imageView.getContext())
                .load(imageUrl)
                .into(imageView);
    }
}
