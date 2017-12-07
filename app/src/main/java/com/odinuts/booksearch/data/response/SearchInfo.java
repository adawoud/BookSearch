package com.odinuts.booksearch.data.response;

import com.squareup.moshi.Json;

public class SearchInfo {

    @Json(name = "textSnippet")
    private String textSnippet;

    public String getTextSnippet() {
        return textSnippet;
    }

    public void setTextSnippet(String textSnippet) {
        this.textSnippet = textSnippet;
    }
}