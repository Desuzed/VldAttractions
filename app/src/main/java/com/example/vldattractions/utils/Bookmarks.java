package com.example.vldattractions.utils;

import android.util.Log;

import com.example.vldattractions.factory.VldObject;

import java.util.TreeSet;

import static android.content.ContentValues.TAG;

public class Bookmarks {
    private static Bookmarks instance;
    private TreeSet<VldObject> bookmarksSet;
    // private Context context;

    public void addBookmark(VldObject vldObject) {
        bookmarksSet.add(vldObject);
        Log.i(TAG, "addVldBookmark: " + vldObject.getCaption());

    }

    public TreeSet<VldObject> getBookmarksSet() {
        return bookmarksSet;
    }

    public void setBookmarksSet(TreeSet<VldObject> bookmarksSet) {
        this.bookmarksSet = bookmarksSet;
    }

    public void removeBookmark(VldObject object) {
            bookmarksSet.remove(object);
    }


    public static synchronized Bookmarks getInstance() {
        if (instance == null) {
            instance = new Bookmarks();
        }
        return instance;
    }
}
