package com.example.vldattractions.utils.factory;

import android.content.Context;

import com.example.vldattractions.R;

public class RusIsland implements Category {
    public static final int INDEX = 4;
    private Context context;

    public RusIsland(Context appContext) {
        this.context = appContext;
    }

    @Override
    public int[] getTextArray() {
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
    public String[] getContentPics(int position) {
        String []arr1 = context.getResources().getStringArray(R.array.tobizin_content);
        String []arr2 = context.getResources().getStringArray(R.array.vyatlin_content);
        String []arr3 = context.getResources().getStringArray(R.array.ajaks_content);
        String []arr4 = context.getResources().getStringArray(R.array.dvfu_content);
        String []arr5 = context.getResources().getStringArray(R.array.korabl_content);
        String []arr6 = context.getResources().getStringArray(R.array.novosilc_content);
        String []arr7 = context.getResources().getStringArray(R.array.okeanarium_content);
        String []arr8 = context.getResources().getStringArray(R.array.shkot_content);
        String[][] imgArray = {arr1, arr2, arr3, arr4, arr5, arr6, arr7, arr8};

        return imgArray[position];
    }
}
