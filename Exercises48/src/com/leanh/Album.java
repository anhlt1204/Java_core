package com.leanh;

import java.util.ArrayList;
import java.util.LinkedList;

public class Album {
    private String name;
    private String artist;
    private SongList songs;

    public Album(String name, String artist) {
        this.name = name;
        this.artist = artist;
        this.songs = new SongList();
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
        for (Song s : songs.songs) {
            if (s.getTitle().equals(title))
                return s;
        }
        return null;
    }

    // Thêm bài hát vào playlist theo track
    public boolean addToPlayList(int track, LinkedList<Song> playlist) {
        if (track <= 0 || track > songs.songs.size()) {
            return false;
        }
        Song checkedSong = this.songs.findSong(track);
        if(checkedSong != null) {
            playlist.add(checkedSong);
            return true;
        }
        return false;
    }

    // Thêm bài hát vào playlist theo tiêu đề
    public boolean addToPlayList(String title, LinkedList<Song> playlist) {
        Song song = this.songs.findSong(title);
        if(song != null) {
            playlist.add(song);
            return true;
        }
        return false;
    }

    public static class SongList {
        private ArrayList<Song> songs;

        public ArrayList<Song> getSongs() {
            return songs;
        }

        private SongList() {
            this.songs = new ArrayList<Song>();
        }

        private boolean add(Song song) {
            if(songs.contains(song)) {
                return false;
            }
            this.songs.add(song);
            return true;
        }

        private Song findSong(String title) {
            for(Song checkingSong: this.songs){
                if(checkingSong.getTitle().equals(title)) {
                    return checkingSong;
                }
            }
            System.out.println("The song " + title + " is not in this album");
            return null;
        }

        private Song findSong(int track) {
            int index = track -1;
            if((index > 0) && (index<songs.size())) {
                return songs.get(index);
            }
            System.out.println("This album does not have a track " + track);
            return null;
        }

    }

    public SongList getSongs() {
        return songs;
    }

    public String getName() {
        return name;
    }

    public String getArtist() {
        return artist;
    }
}
