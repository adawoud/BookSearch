package com.odinuts.booksearch.data.response;

import com.squareup.moshi.Json;

public class ImageLinks {

    @Json(name = "smallThumbnail")
    private String smallThumbnail;
    @Json(name = "thumbnail")
    private String thumbnail;

    public String getSmallThumbnail() {
        return smallThumbnail;
    }

    public void setSmallThumbnail(String smallThumbnail) {
        this.smallThumbnail = smallThumbnail;
    }

    public String getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }
}