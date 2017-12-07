package com.odinuts.booksearch.data.response;

import com.squareup.moshi.Json;

public class ReadingModes {

    @Json(name = "text")
    private boolean text;
    @Json(name = "image")
    private boolean image;

    public boolean isText() {
        return text;
    }

    public void setText(boolean text) {
        this.text = text;
    }

    public boolean isImage() {
        return image;
    }

    public void setImage(boolean image) {
        this.image = image;
    }
}