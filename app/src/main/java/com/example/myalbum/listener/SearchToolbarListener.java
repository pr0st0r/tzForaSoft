package com.example.myalbum.listener;

import androidx.appcompat.widget.SearchView;

public class SearchToolbarListener implements SearchView.OnQueryTextListener{
    @Override
    public boolean onQueryTextSubmit(String s) {
        return false;
    }

    @Override
    public boolean onQueryTextChange(String s) {
        return true;
    }
}
