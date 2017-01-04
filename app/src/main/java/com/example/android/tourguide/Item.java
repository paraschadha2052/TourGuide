package com.example.android.tourguide;

/**
 * Created by paras on 1/5/17.
 */

public class Item {
    private int mImage;
    private String mName;

    public Item(String name, int img){
        mImage = img;
        mName = name;
    }

    public int getmImage(){
        return mImage;
    }

    public String getmName(){
        return mName;
    }

}
