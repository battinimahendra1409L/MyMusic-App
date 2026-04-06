package com.music.app.service;

import com.music.app.model.SongDocument;
import com.music.app.repository.SongSearchRepository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;

@Service
public class SearchService {

    @Autowired
    private SongSearchRepository repository;

    public Page<SongDocument> searchSongs(
            String keyword,
            String language,
            String genre,
            int page,
            int size
    ) {

        Pageable pageable = PageRequest.of(page, size,
                Sort.by("playCount").descending());

        Page<SongDocument> allSongs = repository.findAll(pageable);

        List<SongDocument> filtered = allSongs.getContent().stream()
                .filter(song ->
                        (keyword == null || song.getTitle().toLowerCase().contains(keyword.toLowerCase())
                                || song.getArtist().toLowerCase().contains(keyword.toLowerCase())
                                || song.getTags().toString().toLowerCase().contains(keyword.toLowerCase()))
                                &&
                        (language == null || song.getLanguage().equalsIgnoreCase(language))
                                &&
                        (genre == null || song.getGenre().equalsIgnoreCase(genre))
                )
                .toList();

        return new PageImpl<>(filtered, pageable, filtered.size());
    }
}