package com.ascentcore.onboarding.repository;

import com.ascentcore.onboarding.model.Playlist;
import com.ascentcore.onboarding.model.Song;

import java.util.ArrayList;
import java.util.Arrays;


public class Repository {
    // class which mocks a repository which should contain all data for the a
    private ArrayList<Song> songsInPlaylistOne = new ArrayList<>(Arrays.asList(
            new Song("Test song one name", "Test song one artist", 00332L, android.R.drawable.btn_star),
            new Song("Test song two name", "Test song two artist", 00332L, android.R.drawable.btn_plus),
            new Song("Test song three name", "Test song three artist", 00332L, android.R.drawable.btn_minus),
            new Song("Test song four name", "Test song four artist", 00332L, android.R.drawable.btn_radio))
    );

    private ArrayList<Playlist> playlists = new ArrayList<>(Arrays.asList(
            new Playlist("Test playlist one", "This is a playlist description", songsInPlaylistOne),
            new Playlist("Test playlist two", "This is playlist 2 description", songsInPlaylistOne),
            new Playlist("Test playlist 3", "Playlist 3 desc", songsInPlaylistOne)
    ));

    public Repository() {
    }

    public ArrayList<Playlist> getAllPlaylists() {
        return playlists;
    }

    public Playlist findPlaylistByName(String name) {
        return playlists.stream().filter(playlist -> name.equals(playlist.getPlaylistName())).findFirst().orElse(null);
    }

    public ArrayList<Song> getAllSongsInPlaylist(String playlistName) {
        return findPlaylistByName(playlistName).getSongs();
    }

    public Song findSongByName(String name) {
        return songsInPlaylistOne.stream().filter(song -> name.equals(song.getSongName())).findFirst().orElse(null);
    }
}
