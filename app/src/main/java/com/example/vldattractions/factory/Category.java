package com.example.vldattractions.factory;

public interface Category {

    String[] getPreviewImgArray();

    String[] getCaptionArray();


    VldObject getVldObject (int position);
}
