package com.app.instagramtest.api.response;

import com.app.instagramtest.model.RecentData;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;



public class RecentResponse
{
    @SerializedName("data")
    private ArrayList<RecentData> mRecentList;

    public ArrayList<RecentData> getmRecentList() {
        return mRecentList;
    }

    public void setmRecentList(ArrayList<RecentData> mRecentList) {
        this.mRecentList = mRecentList;
    }
}
