package com.ascentcore.onboarding.adapter;

import static com.ascentcore.onboarding.ui.playlists.Constants.PLAYLIST_NAME;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;

import com.ascentcore.onboarding.R;
import com.ascentcore.onboarding.model.Playlist;
import com.ascentcore.onboarding.ui.playlists.PlaylistDetailsActivity;

import java.util.ArrayList;

public class PlaylistsAdapter extends RecyclerView.Adapter<PlaylistsAdapter.PlaylistViewHolder> {

    private ArrayList<Playlist> items;
    private Context context;

    public void setItems(@Nullable ArrayList<Playlist> items) {
        this.items = items;
        notifyDataSetChanged();
    }

    public void setContext(Context context) {
        this.context = context;
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
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, PlaylistDetailsActivity.class);
                intent.putExtra(PLAYLIST_NAME, holder.playlistName.getText());
                context.startActivity(intent);
            }
        });
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
