package com.app.instagramtest.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.app.instagramtest.R;
import com.app.instagramtest.model.RecentData;
import com.app.instagramtest.view.SquareImageView;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;

public class FeedListAdapter extends RecyclerView.Adapter<FeedListAdapter.ViewHolder> {

    private Context context;
    private ArrayList<RecentData> posts;
    private ViewHolder mViewHolder = null;
    private View mView;


    public FeedListAdapter(Context context) {
        this.context = context;
        posts = new ArrayList<>();

    }

    public interface OnFeedItemClickedListener
    {
        void onItemClick(String url);
    }
    private OnFeedItemClickedListener onFeedItemClickedListener;

    public void setOnFeedItemClickedListener(OnFeedItemClickedListener onFeedItemClickedListener) {
        this.onFeedItemClickedListener = onFeedItemClickedListener;
    }

    @Override
    public FeedListAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());

        mView = inflater.inflate(R.layout.item_feed, parent, false);
        mViewHolder = new ViewHolder(mView);

        return mViewHolder;
    }

    @Override
    public void onBindViewHolder(FeedListAdapter.ViewHolder holder, int position) {
        final RecentData bean = posts.get(position);
        mViewHolder.mUserNameTv.setText(bean.getmUser().getmUserName());
        Picasso.with(context).load(bean.getmUser().getmProfilePicture()).into(mViewHolder.mProfileIv);
        Picasso.with(context).load(bean.getmImages().getmStandardResolution().getmUrl()).into(mViewHolder.mContentIv);

        if(bean.getmType().equals("video")){
            mViewHolder.mPlayVideoIv.setVisibility(View.VISIBLE);
        }else{
            mViewHolder.mPlayVideoIv.setVisibility(View.GONE);
        }

        mViewHolder.mPlayVideoIv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onFeedItemClickedListener.onItemClick(bean.getmVideos().getmStandardResolution().getmUrl());
            }
        });
    }
    public void clear() {
        posts.clear();
        notifyDataSetChanged();
    }

    public void addAll(ArrayList<RecentData> postableList) {
        posts.addAll(postableList);
        notifyDataSetChanged();
    }


    public void addAllEvent(ArrayList<RecentData> postableList) {
        posts.addAll(postableList);
    }

    @Override
    public int getItemViewType(int position) {
        return position;
    }

    @Override
    public int getItemCount() {
        return posts.size();
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private TextView mUserNameTv;
        private CircleImageView mProfileIv;
        private SquareImageView mContentIv;
        private ImageView mPlayVideoIv;

        public ViewHolder(View v) {
            super(v);
            mUserNameTv = (TextView) v.findViewById(R.id.user_name_tv);
            mProfileIv = (CircleImageView) v.findViewById(R.id.profile_image);
            mContentIv= (SquareImageView) v.findViewById(R.id.content_iv);
            mPlayVideoIv=(ImageView)v.findViewById(R.id.play_video);
        }
    }
}