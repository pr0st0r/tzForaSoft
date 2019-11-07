package com.example.myalbum.core.viewmodel;

import android.app.Application;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.myalbum.App;
import com.example.myalbum.R;
import com.example.myalbum.core.entity.Album;
import com.example.myalbum.core.retrofit.dto.ResponseItunesApi;
import com.example.myalbum.repository.AlbumRepositoryImpl;

import java.io.IOException;
import java.util.List;

import javax.inject.Inject;

import retrofit2.Response;

public class MainViewModel extends AndroidViewModel {

    @Inject
    AlbumRepositoryImpl albumRepository;

    private MutableLiveData<List<Album>> mAlbums = new MutableLiveData<>();

    public MainViewModel(@NonNull Application application) {
        super(application);
        App.getComponent().inject(this);
    }

    public LiveData<List<Album>> getAlbums() {
        return mAlbums;
    }

    public void loadAlbumList(final String term) {
        new Thread(() -> {
            try {
                Response<ResponseItunesApi<Album>> response =  albumRepository.getAlbum(term);
                if(response.isSuccessful()){

                    if(response.body() != null && response.body().getResultCount() > 0){
                        mAlbums.postValue(response.body().getResults());
                    }else{
                        Toast.makeText(getApplication().getApplicationContext(), R.string.nothing_found, Toast.LENGTH_SHORT).show();
                    }
                }else {
                    Toast.makeText(getApplication().getApplicationContext(), R.string.error_search, Toast.LENGTH_SHORT).show();
                }
            } catch (IOException e) {
                Toast.makeText(getApplication(), R.string.connection_error, Toast.LENGTH_SHORT).show();
            }
        }).start();
    }
}
