package com.example.myalbum.listener;

import android.widget.SearchView;

public class SearchToolbarListener implements SearchView.OnQueryTextListener{
    @Override
    public boolean onQueryTextSubmit(String s) {
        return false;
    }

    @Override
    public boolean onQueryTextChange(String s) {
        return false;
    }
}
