package com.ascentcore.onboarding.ui.playlists;

import static com.ascentcore.onboarding.ui.playlists.Constants.FROM_PLAYLISTS;
import static com.ascentcore.onboarding.ui.playlists.Constants.IS_PLAYING;
import static com.ascentcore.onboarding.ui.playlists.Constants.PLAYLIST_NAME;
import static com.ascentcore.onboarding.ui.playlists.Constants.SONG_NAME;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.ascentcore.onboarding.R;
import com.ascentcore.onboarding.model.Song;
import com.ascentcore.onboarding.repository.Repository;

public class PlaybackFullscreenFragment extends Fragment {

    Repository repository;
    View view;
    String playlistName;
    String songName;
    boolean isPlaying = true;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_playback_full_screen, container, false);
        initUi();
        return view;
    }

    private void initUi() {
        repository = new Repository();
        Bundle bundle = getArguments();
        if (bundle != null) {
            songName = bundle.getString(SONG_NAME);
            playlistName = bundle.getString(PLAYLIST_NAME);
            Song song = repository.findSongByName(songName);
            populateScreenWithSongDetails(song);
            handleMinimize();
            handlePlayPause();
        } else {
            Toast.makeText(this.getContext(), "There was an error and song can not be played.", Toast.LENGTH_SHORT).show();
        }
    }

    private void populateScreenWithSongDetails(Song song) {
        TextView songName = view.findViewById(R.id.songName);
        TextView artist = view.findViewById(R.id.songArtist);
        ImageView albumCover = view.findViewById(R.id.albumCover);

        songName.setText(song.getSongName());
        artist.setText(song.getSongArtist());
        albumCover.setImageResource(song.getAlbumArt());
    }

    private void handleMinimize() {
        ImageButton minimizeButton = view.findViewById(R.id.minimizeButton);
        minimizeButton.setOnClickListener(view -> {
            Bundle bundle = new Bundle();
            bundle.putBoolean(FROM_PLAYLISTS, false);
            bundle.putString(PLAYLIST_NAME, playlistName);
            bundle.putString(SONG_NAME, songName);
            bundle.putBoolean(IS_PLAYING, isPlaying);
            Fragment fragment = new PlaybackSongsFragment();
            fragment.setArguments(bundle);
            //TODO: add animation (fade out/ to bottom)
            ((PlaylistDetailsActivity) getContext()).getSupportFragmentManager().beginTransaction()
                    .replace(R.id.fragmentContainer,
                            fragment).commit();
        });
    }

    private void handlePlayPause() {
        ImageButton imageButton =  view.findViewById(R.id.playPauseButton);
        imageButton.setOnClickListener(view -> {
            isPlaying = !isPlaying;
            int btnImage = isPlaying? R.drawable.button_play : R.drawable.pause;
            imageButton.setImageResource(btnImage);
        });
    }

}
