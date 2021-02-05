package com.example.vldattractions.factory;

import android.content.Context;

import com.example.vldattractions.R;

public class Food implements Category {
    public static final int INDEX = 1;
    private Context context;
    private VldObject vldObject;
    private int[] descriptionTxtArr;
    private String[][] imgArray;
    private String[] addressArray;
    private String[] coordinatesArray;
    private String[] captionArray;
    private String[] urlInfoArray;

    public Food(Context appContext) {
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
        String[] captionsArray = context.getResources().getStringArray(R.array.array_food);
        return captionsArray;
    }

    @Override
    public String[] getCoordinatesArray() {
        String[] coordArr = context.getResources().getStringArray(R.array.lat_lng_food);
        return coordArr;
    }

    @Override
    public String[] getAddressArray() {
        String[] addrArr = context.getResources().getStringArray(R.array.address_food);
        return addrArr;
    }

    @Override
    public String[] getUrlInfoArray() {
        String[] urlInfo = context.getResources().getStringArray(R.array.info_food);
        return urlInfo;
    }

    private int[] getDescriptionTxtArr() {
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

    private String[][] getContentPics() {
        String[] arr1 = context.getResources().getStringArray(R.array.zuma_content);
        String[] arr2 = context.getResources().getStringArray(R.array.supra_content);
        String[] arr3 = context.getResources().getStringArray(R.array.phali_content);
        String[] arr4 = context.getResources().getStringArray(R.array.crab_content);
        String[] arr5 = context.getResources().getStringArray(R.array.visota_content);
        String[] arr6 = context.getResources().getStringArray(R.array.phoviet_content);
        String[] arr7 = context.getResources().getStringArray(R.array.chifan_content);
        String[] arr8 = context.getResources().getStringArray(R.array.brugge_content);
        String[] arr9 = context.getResources().getStringArray(R.array.alaska_content);
        String[] arr10 = context.getResources().getStringArray(R.array.holyhop_content);
        imgArray = new String[][]{arr1, arr2, arr3, arr4, arr5, arr6, arr7, arr8, arr9, arr10};
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


// case 0:
//         break;
//            case 1:
//                    break;
//            case 2:
//                    break;
//            case 3:
//                    break;
//            case 4:
//                    break;
//            case 5:
//                    break;
//            case 6:
//                    break;
//            case 7:
//                    break;
//            case 8:
//                    break;
//            case 9:
//                    break;
//            case 10:
//                    break;