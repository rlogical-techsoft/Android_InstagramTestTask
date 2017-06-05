package com.app.instagramtest.model;

import com.app.instagramtest.model.images.Images;
import com.app.instagramtest.model.video.Video;
import com.google.gson.annotations.SerializedName;


public class RecentData
{
    @SerializedName("id")
    private String mId;

    @SerializedName("created_time")
    private String mCreatedTime;

    @SerializedName("caption")
    private String  mCaption;

    @SerializedName("user_has_liked")
    private boolean mIsLiked;

    @SerializedName("filter")
    private String mFilter;

    @SerializedName("type")
    private String mType;

    @SerializedName("link")
    private String mLink;

    @SerializedName("user")
    private User mUser;

    @SerializedName("images")
    Images mImages;

    @SerializedName("videos")
    Video mVideos;

    public User getmUser() {
        return mUser;
    }

    public void setmUser(User mUser) {
        this.mUser = mUser;
    }

    public Images getmImages() {
        return mImages;
    }

    public void setmImages(Images mImages) {
        this.mImages = mImages;
    }

    public Video getmVideos() {
        return mVideos;
    }

    public void setmVideos(Video mVideos) {
        this.mVideos = mVideos;
    }

    public String getmId() {
        return mId;
    }

    public void setmId(String mId) {
        this.mId = mId;
    }

    public String getmCreatedTime() {
        return mCreatedTime;
    }

    public void setmCreatedTime(String mCreatedTime) {
        this.mCreatedTime = mCreatedTime;
    }

    public String getmCaption() {
        return mCaption;
    }

    public void setmCaption(String mCaption) {
        this.mCaption = mCaption;
    }

    public boolean ismIsLiked() {
        return mIsLiked;
    }

    public void setmIsLiked(boolean mIsLiked) {
        this.mIsLiked = mIsLiked;
    }

    public String getmFilter() {
        return mFilter;
    }

    public void setmFilter(String mFilter) {
        this.mFilter = mFilter;
    }

    public String getmType() {
        return mType;
    }

    public void setmType(String mType) {
        this.mType = mType;
    }

    public String getmLink() {
        return mLink;
    }

    public void setmLink(String mLink) {
        this.mLink = mLink;
    }
}
