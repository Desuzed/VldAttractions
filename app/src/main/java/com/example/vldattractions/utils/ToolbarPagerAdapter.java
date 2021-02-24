package com.example.vldattractions.utils;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

public class ToolbarPagerAdapter extends FragmentPagerAdapter {
    private String [] imageRes;

    public ToolbarPagerAdapter(@NonNull FragmentManager fm, int behavior, String[] imageRes) {
        super(fm, behavior);
        this.imageRes = imageRes;
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
//        switch (position){
//            case 0:
//                return new FragmentToolbar(imageRes[position]);
//            case 1:
//                return new FragmentToolbar(imageRes[position]);
//            case 2:
//                return new FragmentToolbar(imageRes[position]);
//            default:
      //  }
        return new FragmentToolbar(imageRes[position], position);
    }


    @Override
    public int getCount() {
        return imageRes.length;
    }
}
