package com.app.instagramtest.activity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.annotation.Nullable;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.app.instagramtest.R;
import com.app.instagramtest.adapter.FeedListAdapter;
import com.app.instagramtest.api.ApiServiceModule;
import com.app.instagramtest.api.RestApiInterface;
import com.app.instagramtest.api.response.RecentResponse;
import com.app.instagramtest.model.RecentData;

import java.util.ArrayList;
import java.util.HashSet;

import eu.marcocattaneo.androidinstagramconnector.connection.Instagram;
import eu.marcocattaneo.androidinstagramconnector.connection.InstagramSession;
import eu.marcocattaneo.androidinstagramconnector.connection.implementation.InstagramListener;
import eu.marcocattaneo.androidinstagramconnector.connection.implementation.RequestCallback;
import eu.marcocattaneo.androidinstagramconnector.connection.models.ConnectionError;
import eu.marcocattaneo.androidinstagramconnector.connection.models.Scope;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity implements SwipeRefreshLayout.OnRefreshListener, FeedListAdapter.OnFeedItemClickedListener {

    private SharedPreferences mSharedPreferences;

    private RecyclerView mFeedRv;
    private SwipeRefreshLayout mSwipeView;
    private FeedListAdapter mFeedAdapter;
    private LinearLayoutManager mLayoutManager;

    private ArrayList<RecentData> mFeedList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mFeedRv = (RecyclerView) findViewById(R.id.rvFeed);
        mSwipeView = (SwipeRefreshLayout) findViewById(R.id.swipeContainer);
        mLayoutManager = new LinearLayoutManager(this);
        mFeedRv.setLayoutManager(mLayoutManager);
        mFeedAdapter = new FeedListAdapter(this);
        mFeedAdapter.setOnFeedItemClickedListener(this);

        mFeedRv.setAdapter(mFeedAdapter);
        setUpRefreshListener();
        mFeedList = new ArrayList<>();



        mSharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        Instagram instagram = Instagram.newInstance(this, Constant.CLIENT_ID, Constant.CLIENT_SECRET, Constant.CALLBACL_URL);
        instagram.addScopes(new HashSet<Scope>() {{
            add(Scope.BASIC);
            add(Scope.PUBLIC);
            add(Scope.FOLLOWER);
        }});
        instagram.getSession(new InstagramListener() {
            @Override
            public void onConnect(final InstagramSession session) {
                session.execute("/users/self", new RequestCallback() {
                    @Override
                    public void onResponse(int resultCode, @Nullable String body) {
                        getLectureNote(20, getToken(), false);
                    }
                });
            }
            @Override
            public void onError(ConnectionError error) {
                Log.d("error", "" + error);
            }
        });
    }

    private String getToken() {
        return mSharedPreferences.getString("InstantLibrary:saved_token", null);
    }

    private void getLectureNote(int maxid, String mAccessToken, final boolean isloadmore) {

        if (!mSwipeView.isRefreshing()) mSwipeView.setRefreshing(true);
        ApiServiceModule.createService(RestApiInterface.class).updateProfile(maxid, mAccessToken).enqueue(new Callback<RecentResponse>() {
            @Override
            public void onResponse(Call<RecentResponse> call, Response<RecentResponse> response) {
                if (response.isSuccessful() && response.body() != null) {
                    if (!isloadmore) {
                        mFeedList.clear();
                        mFeedAdapter.clear();
                        mFeedList.addAll(response.body().getmRecentList());
                        mFeedAdapter.addAll(mFeedList);
                    }

                } else {

                }
                if (mSwipeView.isRefreshing()) mSwipeView.setRefreshing(false);
            }

            @Override
            public void onFailure(Call<RecentResponse> call, Throwable t) {
                t.printStackTrace();
                Log.d("error", t.toString());
                if (mSwipeView.isRefreshing()) mSwipeView.setRefreshing(false);
            }
        });
    }

    @Override
    public void onRefresh() {
        getLectureNote(20, getToken(), false);
    }

    private void setUpRefreshListener() {
        mSwipeView.setOnRefreshListener(this);
        mSwipeView.setColorSchemeResources(android.R.color.holo_blue_bright,
                android.R.color.holo_green_light,
                android.R.color.holo_orange_light,
                android.R.color.holo_red_light);
    }

    @Override
    public void onItemClick(String url) {
        Intent i = new Intent(MainActivity.this, VideoPlayerActivity.class);
        i.putExtra("video", url);
        startActivity(i);
    }
}
