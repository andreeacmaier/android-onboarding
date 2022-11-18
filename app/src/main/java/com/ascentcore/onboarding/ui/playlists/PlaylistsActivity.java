package com.ascentcore.onboarding.ui.playlists;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.ascentcore.onboarding.R;
import com.ascentcore.onboarding.adapter.PlaylistsAdapter;
import com.ascentcore.onboarding.repository.Repository;

public class PlaylistsActivity extends AppCompatActivity {

    Repository repository;
    RecyclerView recyclerView;
    PlaylistsAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        repository = new Repository();
        initUi();
    }


    private void initUi() {
        recyclerView = findViewById(R.id.rvPlaylists);
        recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        adapter = new PlaylistsAdapter();
        recyclerView.setAdapter(adapter);
        adapter.setItems(repository.getAllPlaylists());
    }
}