package com.example.myalbum.core.listAdapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;

import com.example.myalbum.R;
import com.example.myalbum.core.entity.Track;

import java.util.List;

public class TrackListAdapter extends BaseAdapter {

    private List<Track> mTracks;

    @Override
    public View getView(int i, View view,@NonNull ViewGroup viewGroup) {
        LayoutInflater inflater = LayoutInflater.from(viewGroup.getContext());
        TrackListHolder holder = new TrackListHolder(DataBindingUtil.inflate(inflater, R.layout.track, viewGroup, false));
        holder.bind(mTracks.get(i));
        return holder.getView();
    }

    @Override
    public int getCount() {
        if (mTracks != null)
            return mTracks.size();
        return 0;
    }

    @Override
    public Object getItem(int i) {
        return mTracks.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    public void setTracks(List<Track> tracks) {
        mTracks = tracks;
    }
}
