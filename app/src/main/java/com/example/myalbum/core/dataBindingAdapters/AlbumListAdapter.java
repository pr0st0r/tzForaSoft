package com.example.myalbum.core.dataBindingAdapters;

import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.databinding.BindingAdapter;

import com.bumptech.glide.Glide;

import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AlbumListAdapter {
    @BindingAdapter("android:src")
    public static void loadImageButton(ImageButton imageView, String imageUrl) {
        Glide.with(imageView.getContext())
                .load(imageUrl)
                .into(imageView);
    }

    @BindingAdapter("android:src")
    public static void loadImageView(ImageView imageView, String imageUrl) {
        Glide.with(imageView.getContext())
                .load(imageUrl)
                .into(imageView);
    }

    @BindingAdapter("app:price")
    public static void loadPrice(TextView textView, Double price){
        textView.setText(String.format(Locale.getDefault(),"%d Руб.", price.intValue()));
    }

    @BindingAdapter("app:date")
    public static void loadDate(TextView textView, String date){
            Pattern pattern = Pattern.compile("^\\d{4}-\\d{2}-\\d{2}");
            Matcher matcher = pattern.matcher(date);
            if (matcher.find())
                textView.setText(date.substring(matcher.start(), matcher.end()));
    }

    @BindingAdapter("app:duration")
    public static void loadTimeTrack(TextView textView, int timeMillis){
        int minut = timeMillis / 1000 / 60;
        int second = timeMillis / 1000 - minut * 60;
        String resultSecond = second < 10 ? "0" + second : Integer.toString(second);

       textView.setText("Продолжительность: " + minut + ":" + resultSecond);
    }
}
