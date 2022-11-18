package com.ascentcore.onboarding.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;

import com.ascentcore.onboarding.R;
import com.ascentcore.onboarding.model.Playlist;

import java.util.ArrayList;

public class PlaylistsAdapter extends RecyclerView.Adapter<PlaylistsAdapter.PlaylistViewHolder> {

    private ArrayList<Playlist> items;

    public void setItems(@Nullable ArrayList<Playlist> items) {
        this.items = items;
        notifyDataSetChanged();
    }


    @NonNull
    @Override
    public PlaylistViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        return new PlaylistViewHolder(inflater.inflate(R.layout.item_playlist, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull PlaylistViewHolder holder, int position) {
        holder.playlistName.setText(items.get(position).getPlaylistName());
    }

    @Override
    public int getItemCount() {
        return items.size();
    }



    class PlaylistViewHolder extends RecyclerView.ViewHolder {
        private final TextView playlistName;

        public PlaylistViewHolder(@NonNull View itemView) {
            super(itemView);
            playlistName = itemView.findViewById(R.id.playlistName);
        }
    }
}
