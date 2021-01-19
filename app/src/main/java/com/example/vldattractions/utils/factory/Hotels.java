package com.example.vldattractions.utils.factory;

import android.content.Context;

import com.example.vldattractions.R;

public class Hotels implements Category {
    public static final int INDEX = 2;
    private Context context;

    public Hotels(Context appContext) {
        this.context = appContext;
    }

    @Override
    public int[] getTextArray() {
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
    public String[] getPreviewImgArray() {
        String[] imgArray = context.getResources().getStringArray(R.array.hotels_pics_url);
        return imgArray;
    }

    @Override
    public String[] getCaptionArray() {
        String[] captionsArray = context.getResources().getStringArray(R.array.array_hotels);
        return captionsArray;
    }

    @Override
    public String[] getContentPics(int position) {
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
        String[][] imgArray = {arr1, arr2, arr3, arr4, arr5, arr6, arr7, arr8, arr9, arr10};
        return imgArray[position];
    }
}
