package com.ascentcore.onboarding.model;

import java.util.ArrayList;

public class Playlist {
    private String playlistName;
    private String playlistDescription;
    private ArrayList<Song> songs;

    public Playlist(String playlistName, String playlistDescription, ArrayList<Song> songs) {
        this.playlistName = playlistName;
        this.playlistDescription = playlistDescription;
        this.songs = songs;
    }

    public String getPlaylistName() {
        return playlistName;
    }

    public void setPlaylistName(String playlistName) {
        this.playlistName = playlistName;
    }

    public String getPlaylistDescription() {
        return playlistDescription;
    }

    public void setPlaylistDescription(String playlistDescription) {
        this.playlistDescription = playlistDescription;
    }

    public ArrayList<Song> getSongs() {
        return songs;
    }

    public void setSongs(ArrayList<Song> songs) {
        this.songs = songs;
    }
}
