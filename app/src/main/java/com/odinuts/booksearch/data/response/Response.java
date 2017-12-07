package com.odinuts.booksearch.data.response;

import com.squareup.moshi.Json;

import java.util.List;

public class Response {

    @Json(name = "kind")
    private String kind;
    @Json(name = "totalItems")
    private int totalItems;
    @Json(name = "items")
    private List<Item> items = null;

    public String getKind() {
        return kind;
    }

    public void setKind(String kind) {
        this.kind = kind;
    }

    public int getTotalItems() {
        return totalItems;
    }

    public void setTotalItems(int totalItems) {
        this.totalItems = totalItems;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }
}