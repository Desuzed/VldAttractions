package com.example.vldattractions.factory;

import android.os.Parcel;
import android.os.Parcelable;
import android.util.Log;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class VldObject implements Comparable<VldObject> {
    private static final String TAG = "VldObject";
    private String caption;
    private String previewImage;
    private int descriptionTextRes;
    private String[] contentPics;
    private String coordinates;
    private String address;
    private String urlInfo;
    private boolean isBookmarked = false;

    public VldObject(String caption, int descriptionTextRes, String[] contentPics, String coordinates, String address, String urlInfo) {
        this.caption = caption;
        this.descriptionTextRes = descriptionTextRes;
        this.contentPics = contentPics;
        this.coordinates = coordinates;
        this.address = address;
        this.urlInfo = urlInfo;
        this.previewImage = contentPics[0];
    }

    @Override
    public int compareTo(VldObject object) {
        //  int i = (int) (this.getDate().getTime() - object.getDate().getTime());
//        int i = this.getCalendar().compareTo(object.getCalendar());
//        Log.i(TAG, "compareTo: "+ this.getCalendar()+ ";\n " + object.getCalendar() + ", \n i=" + i);
        return this.getCaption().compareTo(object.getCaption());
    }

    public boolean isBookmarked (){
        return isBookmarked;
    }

    public void setBookmarked(boolean bookmarked){
        this.isBookmarked = bookmarked;
    }

    public String getCoordinates() {
        return coordinates;
    }

    public String getCaption() {
        return caption;
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

    public String getPreviewImage() {
        return previewImage;
    }

}
