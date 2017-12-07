package com.odinuts.booksearch.data.response;

import com.squareup.moshi.Json;

import java.util.List;

public class SaleInfo {

    @Json(name = "country")
    private String country;
    @Json(name = "saleability")
    private String saleability;
    @Json(name = "isEbook")
    private boolean isEbook;

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getSaleability() {
        return saleability;
    }

    public void setSaleability(String saleability) {
        this.saleability = saleability;
    }

    public boolean isIsEbook() {
        return isEbook;
    }

    public void setIsEbook(boolean isEbook) {
        this.isEbook = isEbook;
    }
}