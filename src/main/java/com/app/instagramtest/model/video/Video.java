package com.app.instagramtest.model.video;

import com.google.gson.annotations.SerializedName;

/**
 * Created by rlogical-dev-19 on 05-Jun-2017.
 */

public class Video
{
    @SerializedName("standard_resolution")
    private VideoBandWidth mStandardResolution;

    @SerializedName("low_bandwidth")
    private VideoBandWidth mLowBandwidth;

    @SerializedName("low_resolution")
    private VideoBandWidth mLowResolution;


    public VideoBandWidth getmStandardResolution() {
        return mStandardResolution;
    }

    public void setmStandardResolution(VideoBandWidth mStandardResolution) {
        this.mStandardResolution = mStandardResolution;
    }

    public VideoBandWidth getmLowBandwidth() {
        return mLowBandwidth;
    }

    public void setmLowBandwidth(VideoBandWidth mLowBandwidth) {
        this.mLowBandwidth = mLowBandwidth;
    }

    public VideoBandWidth getmLowResolution() {
        return mLowResolution;
    }

    public void setmLowResolution(VideoBandWidth mLowResolution) {
        this.mLowResolution = mLowResolution;
    }
}
