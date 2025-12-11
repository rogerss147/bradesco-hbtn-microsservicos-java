package com.example.demo;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

@Repository
public class SongRepository {

    private final List<Song> list = new ArrayList<>();

    public SongRepository() {
        list.add(new Song(1, "Bohemian Rhapsody", "Queen", "A Night at the Opera", "1975"));
        list.add(new Song(2, "Imagine", "John Lennon", "Imagine", "1971"));
    }

    public List<Song> getAllSongs() {
        return list;
    }

    public Song getSongById(Integer id) {
        if (id == null) {
            return null;
        }
        Optional<Song> song = list.stream()
                .filter(s -> id.equals(s.getId()))
                .findFirst();
        return song.orElse(null);
    }

    public Song addSong(Song song) {
        list.add(song);
        return song;
    }

    public Song updateSong(Song song) {
        if (song == null || song.getId() == null) {
            return null;
        }
        for (int i = 0; i < list.size(); i++) {
            if (song.getId().equals(list.get(i).getId())) {
                list.set(i, song);
                return song;
            }
        }
        list.add(song);
        return song;
    }

    public void removeSong(Song song) {
        if (song == null || song.getId() == null) {
            return;
        }
        list.removeIf(existing -> song.getId().equals(existing.getId()));
    }
}
