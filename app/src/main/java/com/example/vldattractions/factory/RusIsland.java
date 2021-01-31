package com.example.vldattractions.factory;

import android.content.Context;

import com.example.vldattractions.R;

public class RusIsland implements Category {
    public static final int INDEX = 4;
    private Context context;
    private VldObject vldObject;
    private int[] descriptionTxtArr;
    private String[][] imgArray;
    private String[] addressArray;
    private String[] coordinatesArray;
    private String[] mapPointCaptionArray;
    private String[] urlInfoArray;

    public RusIsland(Context appContext) {
        this.context = appContext;
        descriptionTxtArr = getDescriptionTxtArr();
        imgArray = getContentPics();
        coordinatesArray = getCoordinatesArray();
        addressArray = getAddressArray();
        mapPointCaptionArray = getCaptionArray();
        urlInfoArray = getUrlInfoArray();
    }

    public int[] getDescriptionTxtArr() {
        int[] textArr = {R.string.tobizin_promontory,
                R.string.vyatlin_promontory,
                R.string.ayaks_bay,
                R.string.campus,
                R.string.ships_graveyard,
                R.string.novosilc_troop,
                R.string.oceanarium,
                R.string.shkot_island};
        return textArr;
    }

    @Override
    public String[] getPreviewImgArray() {
        String[] imgArray = context.getResources().getStringArray(R.array.rus_island_pics_url);
        return imgArray;
    }

    @Override
    public String[] getCaptionArray() {
        String[] captionsArray = context.getResources().getStringArray(R.array.array_rus_island);
        return captionsArray;
    }

    @Override
    public String[] getCoordinatesArray() {
        String[] coordArr = context.getResources().getStringArray(R.array.lat_lng_rus_island);
        return coordArr;
    }

    @Override
    public String[] getAddressArray() {
        String[] addrArr = context.getResources().getStringArray(R.array.address_rus_island);
        return addrArr;
    }

    @Override
    public String[] getUrlInfoArray() {
        String[] urlInfo = context.getResources().getStringArray(R.array.info_rus_island);
        return urlInfo;
    }

    public String[][] getContentPics() {
        String[] arr1 = context.getResources().getStringArray(R.array.tobizin_content);
        String[] arr2 = context.getResources().getStringArray(R.array.vyatlin_content);
        String[] arr3 = context.getResources().getStringArray(R.array.ajaks_content);
        String[] arr4 = context.getResources().getStringArray(R.array.dvfu_content);
        String[] arr5 = context.getResources().getStringArray(R.array.korabl_content);
        String[] arr6 = context.getResources().getStringArray(R.array.novosilc_content);
        String[] arr7 = context.getResources().getStringArray(R.array.okeanarium_content);
        String[] arr8 = context.getResources().getStringArray(R.array.shkot_content);
        imgArray = new String[][]{arr1, arr2, arr3, arr4, arr5, arr6, arr7, arr8};

        return imgArray;
    }

    @Override
    public VldObject getVldObject(int position) {
        vldObject = new VldObject(coordinatesArray[position], mapPointCaptionArray[position], addressArray[position], descriptionTxtArr[position], imgArray[position], urlInfoArray[position]);
        return vldObject;
    }
}
