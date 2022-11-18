package com.ascentcore.onboarding.model;

import android.graphics.Bitmap;
import android.media.Image;

public class Song {
    private String songName;
    private String songArtist;
    private long duration;
    private int albumArt;

    public Song(String songName, String songArtist, long duration, int albumArt) {
        this.songName = songName;
        this.songArtist = songArtist;
        this.duration = duration;
        this.albumArt = albumArt;
    }

    public String getSongName() {
        return songName;
    }

    public void setSongName(String songName) {
        this.songName = songName;
    }

    public String getSongArtist() {
        return songArtist;
    }

    public void setSongArtist(String songArtist) {
        this.songArtist = songArtist;
    }

    public long getDuration() {
        return duration;
    }

    public void setDuration(long duration) {
        this.duration = duration;
    }

    public int getAlbumArt() {
        return albumArt;
    }

    public void setAlbumArt(int albumArt) {
        this.albumArt = albumArt;
    }
}
