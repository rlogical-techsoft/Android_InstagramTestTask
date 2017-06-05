package com.app.instagramtest.model;

import com.google.gson.annotations.SerializedName;


public class User
{
    @SerializedName("id")
    private String mId;

    @SerializedName("full_name")
    private String mFullName;

    @SerializedName("profile_picture")
    private String mProfilePicture;

    @SerializedName("username")
    private String mUserName;


    public String getmId() {
        return mId;
    }

    public void setmId(String mId) {
        this.mId = mId;
    }

    public String getmFullName() {
        return mFullName;
    }

    public void setmFullName(String mFullName) {
        this.mFullName = mFullName;
    }

    public String getmProfilePicture() {
        return mProfilePicture;
    }

    public void setmProfilePicture(String mProfilePicture) {
        this.mProfilePicture = mProfilePicture;
    }

    public String getmUserName() {
        return mUserName;
    }

    public void setmUserName(String mUserName) {
        this.mUserName = mUserName;
    }
}
