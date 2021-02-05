package com.example.vldattractions.factory;

public interface Category {


    String[] getCaptionArray();

    String[] getCoordinatesArray();

    String[] getAddressArray();

    String[] getUrlInfoArray();

    VldObject getVldObject (int position);
}
