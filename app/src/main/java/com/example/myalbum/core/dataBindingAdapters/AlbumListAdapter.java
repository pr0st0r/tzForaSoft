package com.example.myalbum.core.dataBindingAdapters;

import android.widget.ImageButton;
import android.widget.TextView;

import androidx.databinding.BindingAdapter;

import com.bumptech.glide.Glide;

import java.util.Locale;

public class AlbumListAdapter {
    @BindingAdapter("android:src")
    public static void loadImage(ImageButton imageView, String imageUrl) {
        Glide.with(imageView.getContext())
                .load(imageUrl)
                .into(imageView);
    }

    @BindingAdapter("app:price")
    public static void loadPrice(TextView textView, Double price){
        textView.setText(String.format(Locale.getDefault(),"%f", price));
    }
}
