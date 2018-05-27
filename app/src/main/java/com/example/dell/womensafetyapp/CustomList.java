package com.example.dell.womensafetyapp;

/**
 * Created by DELL on 12-05-2018.
 */
//this class's object is used to set the text and image to the customized list elements
public class CustomList {

    private String tlessonName="";
    private int dayResourceId = NO_IMAGE_PROVIDER;
    private static final int NO_IMAGE_PROVIDER = -1;

    public CustomList() {
    }

    public CustomList(String tlessonName, int dayResourceId) {
        this.tlessonName = tlessonName;
        this.dayResourceId = dayResourceId;
    }

    public String getTlessonName() {
        return tlessonName;
    }

    public void setTlessonName(String tlessonName) {
        this.tlessonName = tlessonName;
    }

    public int getDayResourceId() {
        return dayResourceId;
    }

    public void setDayResourceId(int dayResourceId) {
        this.dayResourceId = dayResourceId;
    }

    public boolean hasImage(){
        return dayResourceId != NO_IMAGE_PROVIDER;
    }

    //public static int getNoImageProvider() {
      //  return NO_IMAGE_PROVIDER;
    //}
}
