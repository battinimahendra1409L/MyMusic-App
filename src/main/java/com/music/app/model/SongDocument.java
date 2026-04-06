package com.music.app.model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(indexName = "songs")
public class SongDocument {

    @Id   
    private String id;

    private String title;
    private String artist;
    private String language;
    private String genre;
    private List<String> tags;
    private long playCount;
}