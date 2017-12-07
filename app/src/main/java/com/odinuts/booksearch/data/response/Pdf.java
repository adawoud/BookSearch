package com.odinuts.booksearch.data.response;

import com.squareup.moshi.Json;

public class Pdf {

    @Json(name = "isAvailable")
    private boolean isAvailable;
    @Json(name = "acsTokenLink")
    private String acsTokenLink;

    public boolean isIsAvailable() {
        return isAvailable;
    }

    public void setIsAvailable(boolean isAvailable) {
        this.isAvailable = isAvailable;
    }

    public String getAcsTokenLink() {
        return acsTokenLink;
    }

    public void setAcsTokenLink(String acsTokenLink) {
        this.acsTokenLink = acsTokenLink;
    }
}