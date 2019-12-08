package com.example.myalbum.core.rv.holder;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.ImageButton;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myalbum.App;
import com.example.myalbum.DetailAlbumActivity;
import com.example.myalbum.R;
import com.example.myalbum.core.entity.Album;
import com.example.myalbum.databinding.AlbumBinding;

public class AlbumHolder extends RecyclerView.ViewHolder {

    private AlbumBinding mBinding;
    private Context mContext;
    private ImageButton cover;

    public AlbumHolder(@NonNull View itemView) {
        super(itemView);
        mBinding = DataBindingUtil.bind(itemView);

        mContext = itemView.getContext();
        cover = itemView.findViewById(R.id.album_cover);
    }

    public void bind(@NonNull Album album){
        cover.setOnClickListener(v -> {
            Intent intent = new Intent(mContext, DetailAlbumActivity.class);
            intent.putExtra(App.ALBUM_TRANSFER, album);
            mContext.startActivity(intent);
        });
        mBinding.setAlbum(album);
        mBinding.executePendingBindings();
    }
}
