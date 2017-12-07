package com.odinuts.booksearch.data.response;

import com.squareup.moshi.Json;

public class Item {

    @Json(name = "kind")
    private String kind;
    @Json(name = "id")
    private String id;
    @Json(name = "etag")
    private String etag;
    @Json(name = "selfLink")
    private String selfLink;
    @Json(name = "volumeInfo")
    private VolumeInfo volumeInfo;
    @Json(name = "saleInfo")
    private SaleInfo saleInfo;
    @Json(name = "accessInfo")
    private AccessInfo accessInfo;
    @Json(name = "searchInfo")
    private SearchInfo searchInfo;

    public String getKind() {
        return kind;
    }

    public void setKind(String kind) {
        this.kind = kind;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getEtag() {
        return etag;
    }

    public void setEtag(String etag) {
        this.etag = etag;
    }

    public String getSelfLink() {
        return selfLink;
    }

    public void setSelfLink(String selfLink) {
        this.selfLink = selfLink;
    }

    public VolumeInfo getVolumeInfo() {
        return volumeInfo;
    }

    public void setVolumeInfo(VolumeInfo volumeInfo) {
        this.volumeInfo = volumeInfo;
    }

    public SaleInfo getSaleInfo() {
        return saleInfo;
    }

    public void setSaleInfo(SaleInfo saleInfo) {
        this.saleInfo = saleInfo;
    }

    public AccessInfo getAccessInfo() {
        return accessInfo;
    }

    public void setAccessInfo(AccessInfo accessInfo) {
        this.accessInfo = accessInfo;
    }

    public SearchInfo getSearchInfo() {
        return searchInfo;
    }

    public void setSearchInfo(SearchInfo searchInfo) {
        this.searchInfo = searchInfo;
    }
}