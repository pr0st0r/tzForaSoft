package com.example.myalbum.core.viewmodel;

import android.app.Application;
import android.content.Context;
import android.os.Handler;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.myalbum.App;
import com.example.myalbum.R;
import com.example.myalbum.core.entity.Track;
import com.example.myalbum.core.retrofit.dto.ResponseItunesApi;
import com.example.myalbum.repository.TrackRepositoryImpl;

import java.io.IOException;
import java.util.List;

import javax.inject.Inject;

import retrofit2.Response;

public class TrackViewModel extends AndroidViewModel {

    private Context mContext;
    private Handler mHandler;
    private MutableLiveData<List<Track>> mTrack = new MutableLiveData<>();

    @Inject
    TrackRepositoryImpl mTrackRepository;

    public TrackViewModel(@NonNull Application application) {
        super(application);
        mContext = application.getBaseContext();
        mHandler = new Handler(mContext.getMainLooper());
        App.getComponent().injectTrack(this);
    }

    public LiveData<List<Track>> getTrack() {
        return mTrack;
    }

    public void loadTrack(final long id){
        new Thread(() -> {
            try {
                Response<ResponseItunesApi<Track>> response =  mTrackRepository.getTracks(id);
                if(response.isSuccessful()){
                    if(response.body() != null && response.body().getResultCount() > 0){
                        mTrack.postValue(response.body().getResults());
                    }else{
                        showToastMessage(R.string.nothing_found);
                    }
                }else {
                    showToastMessage(R.string.error_search);
                }
            } catch (IOException e) {
                showToastMessage(R.string.connection_error);
            }
        }).start();
    }

    private void showToastMessage(int msg){
        mHandler.post(() -> Toast.makeText(mContext, msg, Toast.LENGTH_SHORT).show());
    }
}
