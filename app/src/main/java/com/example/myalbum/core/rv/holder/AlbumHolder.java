package com.example.myalbum.core.rv.holder;

import android.view.View;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myalbum.core.entity.Album;
import com.example.myalbum.databinding.AlbumBinding;

public class AlbumHolder extends RecyclerView.ViewHolder {

    private AlbumBinding mBinding;

    public AlbumHolder(@NonNull View itemView) {
        super(itemView);
        mBinding = DataBindingUtil.bind(itemView);
    }

    public void bind(Album album){
        mBinding.setAlbum(album);
        mBinding.executePendingBindings();
    }
}
