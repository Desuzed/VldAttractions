package com.example.vldattractions.utils.factory;

import android.content.Context;

import com.example.vldattractions.R;

public class Food implements Category {
    public static final int INDEX = 1;
    private Context context;

    public Food(Context appContext) {
        this.context = appContext;
    }

    @Override
    public String[] getImgArray() {
        String[] imgArray = context.getResources().getStringArray(R.array.food_pics_url);
        return imgArray;
    }

    @Override
    public String[] getCaptionArray() {
        String[] captionsArray = context.getResources().getStringArray(R.array.array_food);
        return captionsArray;
    }

    @Override
    public int[] getTextArray() {
        int[] textArr = {R.string.zuma,
                R.string.supra,
                R.string.phali,
                R.string.oh_my_crab,
                R.string.rest_height,
                R.string.pho_viet,
                R.string.chi_fan,
                R.string.brugge_pub,
                R.string.alaska,
                R.string.holyhop};
        return textArr;
    }

}
