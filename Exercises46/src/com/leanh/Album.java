package com.leanh;

import java.util.ArrayList;
import java.util.LinkedList;

public class Album {
    private String name;
    private String artist;
    private ArrayList<Song> songs;

    public Album(String name, String artist) {
        this.name = name;
        this.artist = artist;
        this.songs = new ArrayList<Song>();
    }

    // Thêm bài hát mới
    public boolean addSong(String title, double duration) {
        if (findSong(title) != null) {
            return false;
        }
        Song song = new Song(title, duration);
        boolean isAdd = songs.add(song);
        return isAdd;
    }

    // Tìm bài hát theo tiêu đề
    private Song findSong(String title) {
        for (Song s : songs) {
            if (s.getTitle().equals(title))
                return s;
        }
        return null;
    }

    // Thêm bài hát vào playlist theo track
    public boolean addToPlayList(int track, LinkedList<Song> playlist) {
        if (track <= 0 || track > songs.size()) {
            return false;
        }
        Song song = songs.get(track - 1);
        boolean isAdd = playlist.add(song);

        System.out.println("Thêm " + isAdd);
        return isAdd;
    }

    // Thêm bài hát vào playlist theo tiêu đề
    public boolean addToPlayList(String title, LinkedList<Song> playlist) {
        Song song = findSong(title);
        if (song == null) {
            return false;
        }
        boolean isAdd = false;
        try {
            isAdd = playlist.add(song);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            System.out.println("Thêm " + isAdd);
            return isAdd;
        }
    }

    public ArrayList<Song> getSongs() {
        return songs;
    }

    public String getName() {
        return name;
    }

    public String getArtist() {
        return artist;
    }
}
