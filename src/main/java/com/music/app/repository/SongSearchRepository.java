package com.music.app.repository;

import com.music.app.model.SongDocument;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

public interface SongSearchRepository extends ElasticsearchRepository<SongDocument, String> {
}