package com.app.instagramtest.model.images;

import com.google.gson.annotations.SerializedName;

/**
 * Created by rlogical-dev-19 on 05-Jun-2017.
 */

public class Thumbnail {

    @SerializedName("width")
    private int mWidth;

    @SerializedName("height")
    private int mHeight;

    @SerializedName("url")
    private String mUrl;


    public int getmWidth() {
        return mWidth;
    }

    public void setmWidth(int mWidth) {
        this.mWidth = mWidth;
    }

    public int getmHeight() {
        return mHeight;
    }

    public void setmHeight(int mHeight) {
        this.mHeight = mHeight;
    }

    public String getmUrl() {
        return mUrl;
    }

    public void setmUrl(String mUrl) {
        this.mUrl = mUrl;
    }
}
