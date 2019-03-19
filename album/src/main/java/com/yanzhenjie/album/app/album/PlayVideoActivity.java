package com.yanzhenjie.album.app.album;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.widget.VideoView;

import com.yanzhenjie.album.R;

/**
 * create by th on 19/3/2019
 */
public class PlayVideoActivity extends Activity  {
    public static final String EXTRA_VIDEO_PATH = "extra_video_path";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.album_activity_play_video);
        final VideoView vv = findViewById(R.id.vv);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                String path = getIntent().getStringExtra(EXTRA_VIDEO_PATH);
                if (!TextUtils.isEmpty(path)) {
                    vv.setVideoPath(path);
                    vv.start();
                }
            }
        }, 500);
    }
}
