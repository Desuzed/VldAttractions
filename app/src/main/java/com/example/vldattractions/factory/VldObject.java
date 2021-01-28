package com.example.vldattractions.factory;

public class VldObject {
    private double latitude;
    private double longitude;
    private String mapPointTitle;
    private String address;
    private int descriptionTextRes;
    private String [] contentPics;

    public VldObject(int descriptionTextRes, String[] contentPics) {
        this.descriptionTextRes = descriptionTextRes;
        this.contentPics = contentPics;
    }

    public double getLatitude() {
        return latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public String getMapPointTitle() {
        return mapPointTitle;
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


}
