package com.yanzhenjie.album.widget.photoview;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;

import com.yanzhenjie.album.R;

/**
 * Created by Yan Zhenjie on 2017/3/31.
 */

public class AttacherImageView extends FrameLayout {

    private PhotoViewAttacher mAttacher;
    private ImageView mImageView;
    private View mContainerPlay;
    private View mBtPlay;

    public AttacherImageView(Context context) {
        super(context);
    }

    public AttacherImageView(Context context, AttributeSet attrs) {
        super(context, attrs);
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

    private void setIsVoideo(boolean isVideo, String videoPath) {
        if (isVideo) {
            mContainerPlay.setVisibility(View.VISIBLE);
            mBtPlay.setOnClickListener(new OnClickListener() {
                @Override
                public void onClick(View v) {

                }
            });
        } else {
            mContainerPlay.setVisibility(View.GONE);
        }
    }


}
