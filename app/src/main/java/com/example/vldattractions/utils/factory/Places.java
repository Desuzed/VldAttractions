package com.example.vldattractions.utils.factory;

import android.content.Context;

import com.example.vldattractions.R;

public class Places implements Category {
    public static final int INDEX = 0;
    private Context context;

    public Places(Context appContext) {
        this.context = appContext;
    }

    @Override
    public String[] getImgArray() {
        String[] imgArray = context.getResources().getStringArray(R.array.places_pics_url);
        return imgArray;
    }

    @Override
    public String[] getCaptionArray() {
        String[] captionsArray = context.getResources().getStringArray(R.array.array_places);
        return captionsArray;
    }

    @Override
    public int[] getTextArray() {
        int[] textArr = {R.string.bridges,
                R.string.sport_embankment,
                R.string.cesarevich_embankment,
                R.string.funicular,
                R.string.zolotoy_rog_bay, R.string.orlinoe_gnezdo_hill,
                R.string.frigates,
                R.string.red_pennant,
                R.string.st_paul_cathedral,
                R.string.triumph_gate,
                R.string.egersheld_lighthouse};
        return textArr;
    }
}
