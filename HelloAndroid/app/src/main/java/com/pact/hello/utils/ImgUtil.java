package com.pact.hello.utils;

import android.content.Context;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.pact.hello.R;
import com.squareup.picasso.Picasso;

/**
 * ********************************************************
 * <p/>
 * ********************************************************
 * Created by wangdong on 2016/9/26.
 */

public class ImgUtil {
    /**
     * Picasso加载图片
     *
     * @param context
     * @param imageView
     * @param url
     */
    public static void loadImgWithPicasso(Context context, ImageView imageView, String url) {
        Picasso.with(context)
                .load(url)
                .placeholder(R.mipmap.defalt_pic)
                .error(R.mipmap.defalt_pic)
                .fit()
                .centerCrop()
                .into(imageView);
    }

    /**
     * Gilde加载图片
     *
     * @param context
     * @param imageView
     * @param url
     */
    public static void loadImgWithGilde(Context context, ImageView imageView, String url) {
        Glide.with(context)
                .load(url)
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .placeholder(R.mipmap.defalt_pic)
                .error(R.mipmap.defalt_pic)
                .centerCrop()
                .into(imageView);
    }
}
