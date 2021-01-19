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
    public String[] getImgArray() {
        String[] imgArray = context.getResources().getStringArray(R.array.rus_island_pics_url);
        return imgArray;
    }

    @Override
    public String[] getCaptionArray() {
        String[] captionsArray = context.getResources().getStringArray(R.array.array_rus_island);
        return captionsArray;
    }
}
