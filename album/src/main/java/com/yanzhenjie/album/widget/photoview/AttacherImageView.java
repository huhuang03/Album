package com.yanzhenjie.album.widget.photoview;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;

import com.yanzhenjie.album.R;
import com.yanzhenjie.album.app.album.PlayVideoActivity;

/**
 * Created by Yan Zhenjie on 2017/3/31.
 */

public class AttacherImageView extends FrameLayout {

    private PhotoViewAttacher mAttacher;
    private ImageView mImageView;
    private View mContainerPlay;
    private View mBtPlay;

    public AttacherImageView(Context context) {
        this(context, null);
    }

    public AttacherImageView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public AttacherImageView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        LayoutInflater.from(context).inflate(R.layout.album_v_attacher_image, this, true);
        mImageView = findViewById(R.id.iv);
        mContainerPlay = findViewById(R.id.containerPlay);
        mBtPlay = findViewById(R.id.btPlay);
    }

    public void setAttacher(PhotoViewAttacher attacher) {
        this.mAttacher = attacher;
    }

    public void setImageDrawable(@Nullable Drawable drawable) {
        this.mImageView.setImageDrawable(drawable);
        if (mAttacher != null) {
            mAttacher.update();
        }
    }

    public void setIsVideo(boolean isVideo, final String videoPath) {
        if (isVideo) {
            mContainerPlay.setVisibility(View.VISIBLE);
            mBtPlay.setOnClickListener(new OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(getContext(), PlayVideoActivity.class);
                    intent.putExtra(PlayVideoActivity.EXTRA_VIDEO_PATH, videoPath);
                    getContext().startActivity(intent);
                }
            });
        } else {
            mContainerPlay.setVisibility(View.GONE);
        }
    }

    public ImageView getImageView() {
        return mImageView;
    }
}
