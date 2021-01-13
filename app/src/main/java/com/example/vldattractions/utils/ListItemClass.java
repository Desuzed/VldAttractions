package com.example.vldattractions.utils;

public class ListItemClass {
    private String name;
    private String secondName;

    public ListItemClass(String name, String secondName, int imageId) {
        this.name = name;
        this.secondName = secondName;
        this.imageId = imageId;
    }

    private int imageId;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public int getImageId() {
        return imageId;
    }

    public void setImageId(int imageId) {
        this.imageId = imageId;
    }
}
