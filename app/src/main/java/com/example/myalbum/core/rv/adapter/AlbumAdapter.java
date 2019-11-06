package com.example.myalbum.core.rv.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myalbum.R;
import com.example.myalbum.core.entity.Album;
import com.example.myalbum.core.rv.holder.AlbumHolder;
import com.example.myalbum.databinding.AlbumBinding;

import java.util.List;

public class AlbumAdapter extends RecyclerView.Adapter<AlbumHolder> {

    private List<Album> mAlbumList;

    @NonNull
    @Override
    public AlbumHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(viewGroup.getContext());
        AlbumBinding binding = DataBindingUtil.inflate(inflater, R.layout.album, viewGroup, false);
        return new AlbumHolder(binding.getRoot());
    }

    @Override
    public void onBindViewHolder(@NonNull AlbumHolder holder, int position) {
        holder.bind(mAlbumList.get(position));
    }

    @Override
    public int getItemCount() {
        return mAlbumList != null ? mAlbumList.size() : 0;
    }

    public void setAlbumList(List<Album> albumList) {
        mAlbumList = albumList;
    }
}
