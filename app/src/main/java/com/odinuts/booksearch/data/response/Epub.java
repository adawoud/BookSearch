package com.odinuts.booksearch.data.response;

import com.squareup.moshi.Json;

public class Epub {

    @Json(name = "isAvailable")
    private boolean isAvailable;

    public boolean isIsAvailable() {
        return isAvailable;
    }

    public void setIsAvailable(boolean isAvailable) {
        this.isAvailable = isAvailable;
    }
}