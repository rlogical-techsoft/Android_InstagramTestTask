package com.app.instagramtest.activity;

import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.afollestad.easyvideoplayer.EasyVideoCallback;
import com.afollestad.easyvideoplayer.EasyVideoPlayer;
import com.app.instagramtest.R;


public class VideoPlayerActivity extends AppCompatActivity {

    private EasyVideoPlayer mVideoPlayer;
    private String mVideoURL;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_videoplayer);
        mVideoPlayer = (EasyVideoPlayer) findViewById(R.id.video_player);
        mVideoPlayer.setAutoFullscreen(true);


        mVideoURL = getIntent().getExtras().getString("video");

        mVideoPlayer.setSource(Uri.parse(mVideoURL));

        mVideoPlayer.setLeftAction(EasyVideoPlayer.LEFT_ACTION_NONE);

        mVideoPlayer.setCallback(new EasyVideoCallback() {
            @Override
            public void onStarted(EasyVideoPlayer player) {
            }

            @Override
            public void onPaused(EasyVideoPlayer player) {
            }

            @Override
            public void onPreparing(EasyVideoPlayer player) {
            }

            @Override
            public void onPrepared(EasyVideoPlayer player) {
            }

            @Override
            public void onBuffering(int percent) {
            }

            @Override
            public void onError(EasyVideoPlayer player, Exception e) {
            }

            @Override
            public void onCompletion(EasyVideoPlayer player) {
                finish();
            }

            @Override
            public void onRetry(EasyVideoPlayer player, Uri source) {
            }

            @Override
            public void onSubmit(EasyVideoPlayer player, Uri source) {
            }
        });
    }
}
