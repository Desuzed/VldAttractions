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
    public String[] getPreviewImgArray() {
        String[] imgArray = context.getResources().getStringArray(R.array.swimming_pics_url);
        return imgArray;
    }

    @Override
    public String[] getCaptionArray() {
        String[] captionsArray = context.getResources().getStringArray(R.array.array_swimming);
        return captionsArray;
    }

    @Override
    public String[] getContentPics(int position) {
        String[] arr1 = context.getResources().getStringArray(R.array.shamora_content);
        String[] arr2 = context.getResources().getStringArray(R.array.steklyan_content);
        String[] arr3 = context.getResources().getStringArray(R.array.egersheldBeach_content);
        String[] arr4 = context.getResources().getStringArray(R.array.ubiley_content);
        String[] arr5 = context.getResources().getStringArray(R.array.kungasny_content);
        String[] arr6 = context.getResources().getStringArray(R.array.silentBay_content);
        String[] arr7 = context.getResources().getStringArray(R.array.kampusBeach_content);
        String[][] imgArray = {arr1, arr2, arr3, arr4, arr5, arr6, arr7};
        return imgArray[position];
    }
}
