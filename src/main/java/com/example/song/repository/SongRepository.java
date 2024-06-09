package com.example.song.repository;

import java.util.*;
import com.example.song.model.Song;

public interface SongRepository {
    ArrayList<Song> getSongs();

    Song getSongById(int id);

    Song addSong(Song song);

    Song updateSong(Song song, int id);

    void deleteSong(int id);
}