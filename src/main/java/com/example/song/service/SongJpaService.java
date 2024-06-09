package com.example.song.service;

import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.song.model.Song;
import com.example.song.repository.SongJpaRepository;
import com.example.song.repository.SongRepository;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.http.HttpStatus;

@Service
public class SongJpaService implements SongRepository {

	@Autowired
	private SongJpaRepository songJpaRepository;

	@Override
	public ArrayList<Song> getSongs() {
		List<Song> songList = songJpaRepository.findAll();
		ArrayList<Song> arrList = new ArrayList<>(songList);
		return arrList;
	}

	@Override
	public Song getSongById(int id) {
		try {
			Song song = songJpaRepository.findById(id).get();
			return song;
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		}
	}

	@Override
	public Song addSong(Song song) {
		songJpaRepository.save(song);
		return song;
	}

	@Override
	public Song updateSong(Song song, int id) {

		try {
			Song songNew = songJpaRepository.findById(id).get();

			if (song.getSongName() != null) {
				songNew.setSongName(song.getSongName());
			}

			if (song.getLyricist() != null) {
				songNew.setLyricist(song.getLyricist());
			}

			if (song.getSinger() != null) {
				songNew.setSinger(song.getSinger());
			}

			if (song.getMusicDirector() != null) {
				songNew.setMusicDirector(song.getMusicDirector());
			}

			return songNew;
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		}
	}

	@Override
	public void deleteSong(int id) {
		try {
			songJpaRepository.deleteById(id);
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		}
	}

}