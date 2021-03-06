package com.example.vldattractions.factory;

import android.content.Context;

import com.example.vldattractions.R;

public class Hotels implements Category {
    public static final int INDEX = 2;
    private Context context;
    private VldObject vldObject;
    private int[] descriptionTxtArr;
    private String[][] imgArray;
    private String[] addressArray;
    private String[] coordinatesArray;
    private String[] captionArray;
    private String[] urlInfoArray;

    public Hotels(Context appContext) {
        this.context = appContext;
        descriptionTxtArr = getDescriptionTxtArr();
        imgArray = getContentPics();
        coordinatesArray = getCoordinatesArray();
        addressArray = getAddressArray();
        captionArray = getCaptionArray();
        urlInfoArray = getUrlInfoArray();
    }

    private int[] getDescriptionTxtArr() {
        int[] textArr = {R.string.marine_wave,
                R.string.azimut,
                R.string.lido_central,
                R.string.holiday_hotel,
                R.string.pearl_hotel,
                R.string.kamminn,
                R.string.apart_hotel_vld,
                R.string.karmen,
                R.string.zodiac,
                R.string.teplo_hotel};
        return textArr;
    }


    @Override
    public String[] getCaptionArray() {
        String[] captionsArray = context.getResources().getStringArray(R.array.array_hotels);
        return captionsArray;
    }

    @Override
    public String[] getCoordinatesArray() {
        String[] coordArr = context.getResources().getStringArray(R.array.lat_lng_hotels);
        return coordArr;
    }

    @Override
    public String[] getAddressArray() {
        String[] addrArr = context.getResources().getStringArray(R.array.address_hotels);
        return addrArr;
    }

    @Override
    public String[] getUrlInfoArray() {
        String[] urlInfo = context.getResources().getStringArray(R.array.info_hotels);
        return urlInfo;
    }

    public String[][] getContentPics() {
        String[] arr1 = context.getResources().getStringArray(R.array.marine_content);
        String[] arr2 = context.getResources().getStringArray(R.array.azimut_content);
        String[] arr3 = context.getResources().getStringArray(R.array.lido_content);
        String[] arr4 = context.getResources().getStringArray(R.array.holiday_content);
        String[] arr5 = context.getResources().getStringArray(R.array.pearl_content);
        String[] arr6 = context.getResources().getStringArray(R.array.kaminn_content);
        String[] arr7 = context.getResources().getStringArray(R.array.arbat_content);
        String[] arr8 = context.getResources().getStringArray(R.array.karmen_content);
        String[] arr9 = context.getResources().getStringArray(R.array.zodiac_content);
        String[] arr10 = context.getResources().getStringArray(R.array.teplo_content);
        imgArray = new String[][]{arr1, arr2, arr3, arr4, arr5, arr6, arr7, arr8, arr9, arr10};
        return imgArray;
    }

    @Override
    public VldObject getVldObject(int position) {
        vldObject = new VldObject(captionArray[position],
                descriptionTxtArr[position],
                imgArray[position],
                coordinatesArray[position],
                addressArray[position],
                urlInfoArray[position]);

        return vldObject;
    }

}
