package com.goit.practice.http.practice;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.ArrayList;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class YoutubeChannelList {
    private String kind;
    private String etag;
    private String nextPageToken;
    private String regionCode;
    List<Items> items = new ArrayList<>();

    public String getKind() {
        return kind;
    }

    public String getEtag() {
        return etag;
    }

    public String getNextPageToken() {
        return nextPageToken;
    }

    public String getRegionCode() {
        return regionCode;
    }

    public void setKind(String kind) {
        this.kind = kind;
    }

    public void setEtag(String etag) {
        this.etag = etag;
    }

    public void setNextPageToken(String nextPageToken) {
        this.nextPageToken = nextPageToken;
    }

    public void setRegionCode(String regionCode) {
        this.regionCode = regionCode;
    }
}
