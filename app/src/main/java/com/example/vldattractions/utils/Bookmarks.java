package com.example.vldattractions.utils;

import android.content.SharedPreferences;

import com.example.vldattractions.factory.VldObject;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.TreeSet;

public class Bookmarks {
    private static Bookmarks instance;
    private TreeSet<VldObject> bookmarksSet;
    public boolean hasBookmarks;

    public TreeSet<VldObject> getBookmarksSet() {
        if (bookmarksSet.size()==0){
            hasBookmarks=false;
        }else {
            hasBookmarks=true;
        }
        return bookmarksSet;
    }

    public void setBookmarksSet(TreeSet<VldObject> bookmarksSet) {
        this.bookmarksSet = bookmarksSet;
    }

    public static synchronized Bookmarks getInstance() {
        if (instance == null) {
            instance = new Bookmarks();
        }
        return instance;
    }

    public TreeSet<VldObject> getSharedPrefBookmarkSet(SharedPreferences sp) {
        String json = sp.getString("bookmarks", "");
        Gson gson = new Gson();
        Type type = new TypeToken<TreeSet<VldObject>>() {
        }.getType();
        TreeSet<VldObject> set = gson.fromJson(json, type);
        if (set == null ) {
            set = new TreeSet<VldObject>();
        }


        return set;
    }

    public void saveBookmarksToSP(SharedPreferences sp) {
        SharedPreferences.Editor editor = sp.edit();
        Gson gson = new Gson();
        String json = gson.toJson(bookmarksSet);
        editor.putString("bookmarks", json);
        editor.apply();
//        if (bookmarksSet.size()>0){
//            hasBookmarks = true;
//        }
    }

    public void removeBookmark(VldObject o, SharedPreferences sp) {
        bookmarksSet.remove(o);
        TreeSet<VldObject> set = getSharedPrefBookmarkSet(sp);
        set.remove(o);
        saveBookmarksToSP(sp);
    }

    public void addBookmark(VldObject vldObject) {
        bookmarksSet.add(vldObject);
    }
}
