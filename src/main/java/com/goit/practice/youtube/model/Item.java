package com.goit.practice.youtube.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Item {
    private Snippet snippet;
    private VideoId id;

    public Snippet getSnippet() {
        return snippet;
    }

    public void setSnippet(Snippet snippet) {
        this.snippet = snippet;
    }

    public VideoId getId() {
        return id;
    }

    public void setId(VideoId id) {
        this.id = id;
    }
}
