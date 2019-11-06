package com.example.myalbum;

import android.os.Bundle;
import android.view.Menu;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.appcompat.widget.Toolbar;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myalbum.core.entity.Album;
import com.example.myalbum.core.rv.adapter.AlbumAdapter;
import com.example.myalbum.listener.SearchToolbarListener;
import com.example.myalbum.ui.MainViewModel;

import java.util.List;

public class MainActivity extends AppCompatActivity{

    private AlbumAdapter mAlbumAdapter;
    private MainViewModel mMainViewModel;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);
        setSupportActionBar((Toolbar) findViewById(R.id.toolbar));

        RecyclerView mAlbumList = findViewById(R.id.album_list);
        mAlbumAdapter = new AlbumAdapter();
        mAlbumList.setAdapter(mAlbumAdapter);

        mMainViewModel = ViewModelProviders.of(this).get(MainViewModel.class);

        mMainViewModel.getAlbums().observe(this, new Observer<List<Album>>(){
            @Override
            public void onChanged(List<Album> albums) {
                mAlbumAdapter.setAlbumList(albums);
                mAlbumAdapter.notifyDataSetChanged();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        SearchView searchView = (SearchView) menu.findItem(R.id.action_search).getActionView();
        searchView.setOnQueryTextListener(new SearchToolbarListener(mMainViewModel));
        return true;
    }
}
