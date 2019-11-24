package com.example.myalbum;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import com.example.myalbum.core.entity.Album;
import com.example.myalbum.databinding.DetailAlbumBinding;

public class DetailAlbumActivity extends AppCompatActivity {


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.detail_album);

        setSupportActionBar(findViewById(R.id.toolbar));

        Intent intent = getIntent();
        Album album = (Album) intent.getSerializableExtra(App.ALBUM_TRANSFER);

        DetailAlbumBinding binding = DataBindingUtil.setContentView(this, R.layout.detail_album);
        binding.setAlbum(album);
    }
}
