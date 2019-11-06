package com.example.myalbum.ui;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.myalbum.App;
import com.example.myalbum.core.entity.Album;
import com.example.myalbum.core.retrofit.dto.ResponseItunesApi;
import com.example.myalbum.repository.AlbumRepositoryImpl;

import java.io.IOException;
import java.util.List;

import javax.inject.Inject;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Response;

public class MainViewModel extends ViewModel {

    @Inject
    AlbumRepositoryImpl albumRepository;

    private MutableLiveData<List<Album>> mAlbums = new MutableLiveData<>();

    public MainViewModel() {
        App.getComponent().inject(this);
    }

    public LiveData<List<Album>> getAlbums() {
        return mAlbums;
    }

    public void loadAlbumList(final String term) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    mAlbums.postValue(albumRepository.getAlbum(term).body().getResults());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }
}
