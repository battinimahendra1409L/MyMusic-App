package com.music.app.controller;

import com.music.app.model.Song;
import com.music.app.model.SongDocument;
import com.music.app.service.SearchService;
import com.music.app.service.SongService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class SongController {

    @Autowired
    private SongService songService;

    @Autowired
    private SearchService searchService;

 
    @PostMapping("/songs")
    public Song addSong(@RequestBody Song song) {
        return songService.addSong(song);
    }
    @GetMapping("/songs")
    public List<Song> getAllSongs() {
        return songService.getAllSongs();
    }

 
    @GetMapping("/search")
    public Page<SongDocument> searchSongs(
            @RequestParam(value = "keyword", required = false) String keyword,
            @RequestParam(value = "language", required = false) String language,
            @RequestParam(value = "genre", required = false) String genre,
            @RequestParam(value = "page", defaultValue = "0") int page,
            @RequestParam(value = "size", defaultValue = "5") int size
    ) {
        return searchService.searchSongs(keyword, language, genre, page, size);
    }
    @DeleteMapping("/songs/{id}")
    public String deleteSong(@PathVariable("id") String id) {
        songService.deleteSong(id);
        return "Song deleted";
    }
}