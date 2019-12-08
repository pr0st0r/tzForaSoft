package com.example.myalbum.core.listAdapter;

import android.view.View;

import com.example.myalbum.core.entity.Track;
import com.example.myalbum.databinding.TrackBinding;

class TrackListHolder {
    private View mView;
    private TrackBinding mBinding;

    TrackListHolder(TrackBinding binding) {
        mView = binding.getRoot();
        mBinding = binding;
    }

    void bind(Track track){
            mBinding.setTrack(track);
    }

    View getView() {
        return mView;
    }
}
