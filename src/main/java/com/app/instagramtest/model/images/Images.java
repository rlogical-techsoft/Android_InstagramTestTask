package com.app.instagramtest.model.images;

import com.google.gson.annotations.SerializedName;

/**
 * Created by rlogical-dev-19 on 05-Jun-2017.
 */

public class Images
{
    @SerializedName("thumbnail")
    private Thumbnail mThumbnail;

    @SerializedName("low_resolution")
    private Thumbnail mLowResolution;

    @SerializedName("standard_resolution")
    private Thumbnail mStandardResolution;


    public Thumbnail getmThumbnail() {
        return mThumbnail;
    }

    public void setmThumbnail(Thumbnail mThumbnail) {
        this.mThumbnail = mThumbnail;
    }

    public Thumbnail getmLowResolution() {
        return mLowResolution;
    }

    public void setmLowResolution(Thumbnail mLowResolution) {
        this.mLowResolution = mLowResolution;
    }

    public Thumbnail getmStandardResolution() {
        return mStandardResolution;
    }

    public void setmStandardResolution(Thumbnail mStandardResolution) {
        this.mStandardResolution = mStandardResolution;
    }
}
