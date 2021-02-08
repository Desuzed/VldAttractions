package com.example.vldattractions.factory;

import android.os.Parcel;
import android.os.Parcelable;

public class VldObject implements Parcelable, Comparable<VldObject> {
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

    protected VldObject(Parcel in) {
        caption = in.readString();
        previewImage = in.readString();
        descriptionTextRes = in.readInt();
        contentPics = in.createStringArray();
        coordinates = in.readString();
        address = in.readString();
        urlInfo = in.readString();
    }

    public static final Creator<VldObject> CREATOR = new Creator<VldObject>() {
        @Override
        public VldObject createFromParcel(Parcel in) {
            return new VldObject(in);
        }

        @Override
        public VldObject[] newArray(int size) {
            return new VldObject[size];
        }
    };

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


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(caption);
        parcel.writeString(previewImage);
        parcel.writeInt(descriptionTextRes);
        parcel.writeStringArray(contentPics);
        parcel.writeString(coordinates);
        parcel.writeString(address);
        parcel.writeString(urlInfo);
    }

    @Override
    public int compareTo(VldObject object) {
        return this.getCaption().compareTo(object.getCaption());
    }
}
