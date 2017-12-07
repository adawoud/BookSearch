package com.odinuts.booksearch.data.response;

import com.squareup.moshi.Json;

public class IndustryIdentifier {

    @Json(name = "type")
    private String type;
    @Json(name = "identifier")
    private String identifier;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getIdentifier() {
        return identifier;
    }

    public void setIdentifier(String identifier) {
        this.identifier = identifier;
    }
}