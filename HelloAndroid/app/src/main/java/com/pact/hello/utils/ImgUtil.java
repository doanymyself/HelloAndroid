package com.pact.hello.utils;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.pact.hello.R;
import com.squareup.picasso.Picasso;

import org.xutils.ImageManager;
import org.xutils.common.Callback;
import org.xutils.image.ImageOptions;
import org.xutils.x;

/**
 * ********************************************************
 * 图片加载工具类
 * ********************************************************
 * Created by wangdong on 2016/9/26.
 */

public class ImgUtil {

    /**
     * xUtils加载图片
     *
     * @param context
     * @param imageView
     * @param url
     */
    public static void loadImgWithXUtils(Context context, ImageView imageView, String url) {
        ImageManager manager = x.image();//可以重复使用,不需要再次创建
        ImageOptions.Builder builder = new ImageOptions.Builder();
        //添加动画效果
//        builder.setAnimation(AnimationUtils.loadAnimation(context, R.anim.load_img_anim));
        builder.setRadius(30);//设置圆角
        manager.bind(imageView, url, builder.build(), new Callback.CommonCallback<Drawable>() {
            @Override
            public void onSuccess(Drawable result) {
                //可以在这里对下载的图片进行额外操作,比如写进文件
            }

            @Override
            public void onError(Throwable ex, boolean isOnCallback) {

            }

            @Override
            public void onCancelled(CancelledException cex) {

            }

            @Override
            public void onFinished() {

            }
        });
    }

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
