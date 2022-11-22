package com.ascentcore.onboarding.ui.playlists;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.ascentcore.onboarding.R;
import com.ascentcore.onboarding.adapter.SongAdapter;
import com.ascentcore.onboarding.repository.Repository;

import java.util.Objects;

public class PlaylistDetailsActivity extends AppCompatActivity {

    Repository repository;
    RecyclerView recyclerView;
    SongAdapter adapter;
    Intent intent;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_song);
        repository = new Repository();
        initUi();
    }

    private void initUi() {
        intent = getIntent();
        if (Objects.nonNull(intent.getExtras())) {
            String playlistName = (String) intent.getExtras().get("playlistName");
            recyclerView = findViewById(R.id.songs);
            recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
            adapter = new SongAdapter();
            recyclerView.setAdapter(adapter);
            adapter.setSongs(repository.getAllSongsInPlaylist(playlistName));
        } else {
            //intent = new Intent(PlaylistDetailsActivity.this)
            Toast.makeText(this, "Songs could not be loaded", Toast.LENGTH_SHORT).show();
        }
    }

}
