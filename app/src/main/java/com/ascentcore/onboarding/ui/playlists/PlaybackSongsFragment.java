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
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.ascentcore.onboarding.R;
import com.ascentcore.onboarding.adapter.SongAdapter;
import com.ascentcore.onboarding.model.Song;
import com.ascentcore.onboarding.repository.Repository;

public class PlaybackSongsFragment extends Fragment {

    Repository repository;
    RecyclerView recyclerView;
    SongAdapter adapter;
    View view;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_playback_songs, container, false);
        initUi();
        return view;
    }

    private void initUi() {
        repository = new Repository();
        Bundle bundle = getArguments();
        if (bundle != null) {
            String playlistName = bundle.getString(PLAYLIST_NAME);
            boolean fromPlaylists = bundle.getBoolean(FROM_PLAYLISTS);

            recyclerView = view.findViewById(R.id.songs);
            recyclerView.setLayoutManager(new LinearLayoutManager(this.getContext(), LinearLayoutManager.VERTICAL, false));
            adapter = new SongAdapter();
            adapter.setSongs(repository.getAllSongsInPlaylist(playlistName));
            adapter.setContext(this.getContext());
            adapter.setPlaylistName(playlistName);
            recyclerView.setAdapter(adapter);

            LinearLayout bottomView = view.findViewById(R.id.bottomView);

            // fromPlaylists = true means fragment opened from playlist list => bottom view won't be displayed
            // fromPlaylist = false means is coming from fullscreen (minimize) => bottom view will be displayed
            if (fromPlaylists) {
                bottomView.setVisibility(View.GONE);
            } else {
                boolean isPlaying = bundle.getBoolean(IS_PLAYING);
                String songName = bundle.getString(SONG_NAME);
                if (songName != null) {
                    Song song = repository.findSongByName(songName);
                    TextView songTextView = view.findViewById(R.id.songName);
                    TextView artistTextView = view.findViewById(R.id.songArtist);
                    ImageButton imageButton =  view.findViewById(R.id.playPauseButton);

                    songTextView.setText(song.getSongName());
                    artistTextView.setText(song.getSongArtist());

                    int btnImage = isPlaying? R.drawable.button_play : R.drawable.pause;
                    imageButton.setImageResource(btnImage);
                }
                bottomView.setVisibility(View.VISIBLE);
            }
        }
    }
}
