package com.example.vldattractions.factory;

import android.content.Context;

public class CategoriesFactory {
    Context context;
    public CategoriesFactory(Context context) {
        this.context = context;
    }

    public Category getCategory(int categoryIndex) {
        Category toReturn = null;
        switch (categoryIndex) {
            case Places.INDEX:
                toReturn = new Places(context);
                break;
            case Food.INDEX:
                toReturn = new Food(context);
                break;
            case Hotels.INDEX:
                toReturn = new Hotels(context);
                break;
            case Swimming.INDEX:
                toReturn = new Swimming(context);
                break;
            case RusIsland.INDEX:
                toReturn = new RusIsland(context);
                break;
            default:
                throw new IllegalArgumentException("Wrong categoryIndex:" + categoryIndex);
        }
        return toReturn;
    }
}
