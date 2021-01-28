package com.example.vldattractions.factory;

import android.content.Context;

import com.example.vldattractions.R;

public class Swimming implements Category {
    public static final int INDEX = 3;
    private Context context;
    private VldObject vldObject;
    private int[] descriptionTxtArr;
    private String[][] imgArray;

    public Swimming(Context appContext) {
        this.context = appContext;
        descriptionTxtArr = getDescriptionTxtArr();
        imgArray = getContentPics();
    }

    public int[] getDescriptionTxtArr() {
        int[] textArr = {R.string.shamora,
                R.string.glass_beach,
                R.string.egersheld_beach,
                R.string.anniversary_beach,
                R.string.kungasny_beach,
                R.string.silent_bay_beach,
                R.string.campus_beach,
                R.string.novic_beach,
                R.string.patrokl_beach};
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

    public String[][] getContentPics() {
        String[] arr1 = context.getResources().getStringArray(R.array.shamora_content);
        String[] arr2 = context.getResources().getStringArray(R.array.steklyan_content);
        String[] arr3 = context.getResources().getStringArray(R.array.egersheldBeach_content);
        String[] arr4 = context.getResources().getStringArray(R.array.ubiley_content);
        String[] arr5 = context.getResources().getStringArray(R.array.kungasny_content);
        String[] arr6 = context.getResources().getStringArray(R.array.silentBay_content);
        String[] arr7 = context.getResources().getStringArray(R.array.kampusBeach_content);
        String[] arr8 = context.getResources().getStringArray(R.array.novik_content);
        String[] arr9 = context.getResources().getStringArray(R.array.patrokl_content);
        imgArray = new String[][]{arr1, arr2, arr3, arr4, arr5, arr6, arr7, arr8, arr9};
        return imgArray;
    }

    @Override
    public VldObject getVldObject(int position) {
        vldObject = new VldObject(descriptionTxtArr[position], imgArray[position]);
        return vldObject;
    }
}
