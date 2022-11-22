package com.ascentcore.onboarding.ui.playlists;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.ascentcore.onboarding.R;
import com.ascentcore.onboarding.adapter.PlaylistsAdapter;
import com.ascentcore.onboarding.adapter.SongAdapter;
import com.ascentcore.onboarding.repository.Repository;

public class PlaylistsActivity extends AppCompatActivity {

    Repository repository;
    RecyclerView recyclerView;
    PlaylistsAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_playlist);
        repository = new Repository();
        initUi();
    }


    private void initUi() {
        recyclerView = findViewById(R.id.rvPlaylists);
        recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        adapter = new PlaylistsAdapter();
        adapter.setContext(PlaylistsActivity.this);
        adapter.setItems(repository.getAllPlaylists());
        recyclerView.setAdapter(adapter);
    }
}