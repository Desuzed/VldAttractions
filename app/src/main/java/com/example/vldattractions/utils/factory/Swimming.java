package com.example.vldattractions.utils.factory;

import android.content.Context;

import com.example.vldattractions.R;

public class Swimming implements Category {
    public static final int INDEX = 3;
    private Context context;

    public Swimming(Context appContext) {
        this.context = appContext;
    }

    @Override
    public int[] getTextArray() {
        int[] textArr = {R.string.shamora,
                R.string.glass_beach,
                R.string.egersheld_beach,
                R.string.anniversary_beach,
                R.string.kungasny_beach,
                R.string.silent_bay_beach,
                R.string.campus_beach};
        return textArr;
    }

    @Override
    public String[] getImgArray() {
        String[] imgArray = context.getResources().getStringArray(R.array.swimming_pics_url);
        return imgArray;
    }

    @Override
    public String[] getCaptionArray() {
        String[] captionsArray = context.getResources().getStringArray(R.array.array_swimming);
        return captionsArray;
    }
}
