package com.example.vldattractions.factory;

public class VldObject {
    private String coordinates;
    private String mapPointCaption;
    private String address;
    private String urlInfo;
    private int descriptionTextRes;
    private String[] contentPics;

    public VldObject(String coordinates, String mapPointTitle, String address, int descriptionTextRes, String[] contentPics, String urlInfo) {
        this.coordinates = coordinates;
        this.mapPointCaption = mapPointTitle;
        this.address = address;
        this.descriptionTextRes = descriptionTextRes;
        this.contentPics = contentPics;
        this.urlInfo = urlInfo;
    }

    public String getCoordinates() {
        return coordinates;
    }

    public String getMapPointCaption() {
        return mapPointCaption;
    }

    public String getAddress() {
        return address;
    }

    public int getDescriptionTextRes() {
        return descriptionTextRes;
    }

    public String[] getContentPics() {
        return contentPics;
    }

    public String getUrlInfo() {
        return urlInfo;
    }


}
