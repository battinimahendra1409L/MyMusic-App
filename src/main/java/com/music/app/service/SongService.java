package com.music.app.service;

import com.music.app.model.Song;
import com.music.app.model.SongDocument;
import com.music.app.repository.SongRepository;
import com.music.app.repository.SongSearchRepository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SongService {

    @Autowired
    private SongRepository songRepository;

    @Autowired
    private SongSearchRepository songSearchRepository; 

    public Song addSong(Song song) {

   
        Song savedSong = songRepository.save(song);

      
        SongDocument doc = new SongDocument();
        doc.setId(savedSong.getId());
        doc.setTitle(savedSong.getTitle());
        doc.setArtist(savedSong.getArtist());
        doc.setLanguage(savedSong.getLanguage());
        doc.setGenre(savedSong.getGenre());
        doc.setTags(savedSong.getTags());
        doc.setPlayCount(savedSong.getPlayCount());

       
        songSearchRepository.save(doc);

        return savedSong;
    }
    
    public List<Song> getAllSongs() {
        return songRepository.findAll();
    }
    public void deleteSong(String id) {
        songRepository.deleteById(id);
    }
}