package com.example.myalbum.listener;

import androidx.appcompat.widget.SearchView;

import com.example.myalbum.core.viewmodel.MainViewModel;


public class SearchToolbarListener implements SearchView.OnQueryTextListener{

    private MainViewModel mViewModel;

    public SearchToolbarListener(MainViewModel viewModel) {
        mViewModel = viewModel;
    }

    @Override
    public boolean onQueryTextSubmit(String s) {
        return false;
    }

    @Override
    public boolean onQueryTextChange(String s) {
        if(!s.equals(""))
            mViewModel.loadAlbumList(s);

        return true;
    }
}
