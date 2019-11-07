package com.example.myalbum;

import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.view.Menu;

import androidx.annotation.Nullable;
import androidx.annotation.StringRes;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myalbum.core.rv.adapter.AlbumAdapter;
import com.example.myalbum.listener.SearchToolbarListener;
import com.example.myalbum.core.viewmodel.MainViewModel;


public class MainActivity extends AppCompatActivity{

    private AlbumAdapter mAlbumAdapter;
    private MainViewModel mMainViewModel;
    private AlertDialog alert;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);
        setSupportActionBar(findViewById(R.id.toolbar));

        //Диалоговое окно
        if(isConnectInternet()){
            builderAlert(R.string.alert_title, R.string.alert_message);
            alert.setIcon(R.drawable.alert_succes);
        }else{
            builderAlert(R.string.alert_title_error, R.string.alert_message_error);
            alert.setIcon(R.drawable.alert_error);
        }

        //Список
        RecyclerView mAlbumList = findViewById(R.id.album_list);
        mAlbumAdapter = new AlbumAdapter();
        mAlbumList.setAdapter(mAlbumAdapter);

        mMainViewModel = ViewModelProviders.of(this).get(MainViewModel.class);

        mMainViewModel.getAlbums().observe(this, albums -> {
            mAlbumAdapter.setAlbumList(albums);
            mAlbumAdapter.notifyDataSetChanged();
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        alert.show();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        SearchView searchView = (SearchView) menu.findItem(R.id.action_search).getActionView();
        searchView.setOnQueryTextListener(new SearchToolbarListener(mMainViewModel));
        return true;
    }

    /**
     * Проверяем подключение к интернету
     * @return - true если интернет есть
     * иначе false
     */
    private boolean isConnectInternet(){
        ConnectivityManager connectivityManager = (ConnectivityManager)getSystemService(CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();
        return networkInfo != null && networkInfo.isConnectedOrConnecting();
    }

    /**
     * Диалоговое окно
     * @param title - заголовок
     * @param message - сообщение
     */
    private void builderAlert(@StringRes int title, @StringRes int message){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(title)
                .setMessage(message)
                .setCancelable(false)
                .setNegativeButton("OK",(dialog, id) -> dialog.cancel());

        alert = builder.create();
    }
}
