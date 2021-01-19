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
    public String[] getPreviewImgArray() {
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

    public String[] getContentPics(int position) {
        String [] arr1 = context.getResources().getStringArray(R.array.bridges_content);
        String []arr2 = context.getResources().getStringArray(R.array.sportEmb_content);
        String []arr3 = context.getResources().getStringArray(R.array.cesarEmb_content);
        String []arr4 = context.getResources().getStringArray(R.array.funicular_content);
        String []arr5 = context.getResources().getStringArray(R.array.zolRogBay_content);
        String []arr6 = context.getResources().getStringArray(R.array.eagleHill_content);
        String []arr7 = context.getResources().getStringArray(R.array.fregates_content);
        String []arr8 = context.getResources().getStringArray(R.array.redPennant_content);
        String []arr9 = context.getResources().getStringArray(R.array.cathedral_content);
        String []arr10 = context.getResources().getStringArray(R.array.triumphGate_content);
        String []arr11 = context.getResources().getStringArray(R.array.egersheld_content);
        String[][] imgArray = {arr1, arr2, arr3, arr4, arr5, arr6, arr7, arr8, arr9, arr10, arr11};

        return imgArray[position];
    }
}
