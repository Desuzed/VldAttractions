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
    public String[] getImgArray() {
        String[] imgArray = context.getResources().getStringArray(R.array.hotels_pics_url);
        return imgArray;
    }

    @Override
    public String[] getCaptionArray() {
        String[] captionsArray = context.getResources().getStringArray(R.array.array_hotels);
        return captionsArray;
    }
}
