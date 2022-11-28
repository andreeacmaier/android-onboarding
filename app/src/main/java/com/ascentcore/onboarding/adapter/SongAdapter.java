package com.ascentcore.onboarding.adapter;

import static com.ascentcore.onboarding.ui.playlists.Constants.PLAYLIST_NAME;
import static com.ascentcore.onboarding.ui.playlists.Constants.SONG_NAME;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import com.ascentcore.onboarding.R;
import com.ascentcore.onboarding.model.Song;
import com.ascentcore.onboarding.ui.playlists.PlaybackFullscreenFragment;
import com.ascentcore.onboarding.ui.playlists.PlaylistDetailsActivity;

import java.util.ArrayList;

public class SongAdapter extends RecyclerView.Adapter<SongAdapter.SongViewHolder> {

    private ArrayList<Song> songs;
    private Context context;
    private String playlistName;

    public void setSongs(@Nullable ArrayList<Song> songs) {
        this.songs = songs;
        notifyDataSetChanged();
    }

    public void setContext(Context context) {
        this.context = context;
    }

    public void setPlaylistName(String playlistName) {
        this.playlistName = playlistName;
    }

    @NonNull
    @Override
    public SongViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        return new SongViewHolder(inflater.inflate(R.layout.item_song, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull SongViewHolder holder, int position) {
        holder.songName.setText(songs.get(position).getSongName());
        holder.itemView.setOnClickListener(v -> {
            // open PlaybackFullscreenFragment
            Fragment fragment = new PlaybackFullscreenFragment();
            Bundle bundle = new Bundle();
            bundle.putString(SONG_NAME, songs.get(position).getSongName());
            bundle.putString(PLAYLIST_NAME, playlistName);
            fragment.setArguments(bundle);

            ((PlaylistDetailsActivity) context).getSupportFragmentManager().beginTransaction()
                    .setCustomAnimations(R.anim.fade_in, R.anim.slide_out)
                    .replace(R.id.fragmentContainer,
                    fragment).commit();
        });
    }

    @Override
    public int getItemCount() {
        return songs.size();
    }


    class SongViewHolder extends RecyclerView.ViewHolder {
        private final TextView songName;

        public SongViewHolder(@NonNull View itemView) {
            super(itemView);
            songName = itemView.findViewById(R.id.songName);
        }
    }
}
