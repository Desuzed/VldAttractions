package com.example.vldattractions.factory;

import android.content.Context;

import com.example.vldattractions.R;

public class Places implements Category {
    public static final int INDEX = 0;
    private Context context;
    private VldObject vldObject;
    private int[] descriptionTxtArr;
    private String[][] imgArray;
    private String[] addressArray;
    private String[] coordinatesArray;
    private String[] captionArray;
    private String[] urlInfoArray;


    public Places(Context appContext) {
        this.context = appContext;
        descriptionTxtArr = getDescriptionTxtArr();
        imgArray = getContentPics();
        coordinatesArray = getCoordinatesArray();
        addressArray = getAddressArray();
        captionArray = getCaptionArray();
        urlInfoArray = getUrlInfoArray();
    }

    @Override
    public String[] getCaptionArray() {
        String[] captionsArray = context.getResources().getStringArray(R.array.array_places);
        return captionsArray;
    }

    @Override
    public String[] getCoordinatesArray() {
        String[] coordArr = context.getResources().getStringArray(R.array.lat_lng_places);
        return coordArr;
    }

    @Override
    public String[] getAddressArray() {
        String[] addrArr = context.getResources().getStringArray(R.array.address_places);
        return addrArr;
    }

    @Override
    public String[] getUrlInfoArray() {
        String[] urlInfo = context.getResources().getStringArray(R.array.info_places);
        return urlInfo;
    }

    public int[] getDescriptionTxtArr() {
        int[] textArr = {R.string.rus_bridge,
                R.string.gold_bridge,
                R.string.sport_embankment,
                R.string.cesarevich_embankment,
                R.string.funicular,
                R.string.orlinoe_gnezdo_hill,
                R.string.frigates,
                R.string.red_pennant,
                R.string.st_paul_cathedral,
                R.string.triumph_gate,
                R.string.egersheld_lighthouse};
        return textArr;
    }

    public String[][] getContentPics() {
        String[] arr1 = context.getResources().getStringArray(R.array.rus_bridge_content);
        String[] arr2 = context.getResources().getStringArray(R.array.gold_bridge);
        String[] arr3 = context.getResources().getStringArray(R.array.sportEmb_content);
        String[] arr4 = context.getResources().getStringArray(R.array.cesarEmb_content);
        String[] arr5 = context.getResources().getStringArray(R.array.funicular_content);
        String[] arr6 = context.getResources().getStringArray(R.array.eagleHill_content);
        String[] arr7 = context.getResources().getStringArray(R.array.fregates_content);
        String[] arr8 = context.getResources().getStringArray(R.array.redPennant_content);
        String[] arr9 = context.getResources().getStringArray(R.array.cathedral_content);
        String[] arr10 = context.getResources().getStringArray(R.array.triumphGate_content);
        String[] arr11 = context.getResources().getStringArray(R.array.egersheld_content);
        imgArray = new String[][]{arr1, arr2, arr3, arr4, arr5, arr6, arr7, arr8, arr9, arr10, arr11};
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
