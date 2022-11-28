package com.ascentcore.onboarding.ui.playlists;

import static com.ascentcore.onboarding.ui.playlists.Constants.FROM_PLAYLISTS;
import static com.ascentcore.onboarding.ui.playlists.Constants.PLAYLIST_NAME;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.ascentcore.onboarding.R;
import com.ascentcore.onboarding.adapter.SongAdapter;
import com.ascentcore.onboarding.repository.Repository;

import java.util.Objects;

public class PlaylistDetailsActivity extends AppCompatActivity {

    Repository repository;
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

        if (Objects.nonNull(intent) && Objects.nonNull(intent.getExtras())) {
            Fragment fragment = new PlaybackSongsFragment();
            String playlistName = (String) intent.getExtras().get(PLAYLIST_NAME);
            Bundle bundle = new Bundle();
            bundle.putString(PLAYLIST_NAME, playlistName);
            bundle.putBoolean(FROM_PLAYLISTS, true);
            fragment.setArguments(bundle);
            getSupportFragmentManager().beginTransaction().replace(R.id.fragmentContainer,
                    fragment).commit();
        } else {
            Toast.makeText(this, "Songs could not be loaded", Toast.LENGTH_SHORT).show();
        }
    }

}
