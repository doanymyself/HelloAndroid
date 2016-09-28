package com.pact.hello.components.welcome;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.pact.hello.R;
import com.pact.hello.framework.BaseFragment;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * ********************************************************
 * 引导页面
 * ********************************************************
 * Created by wangdong on 2016/9/28.
 */

public class GuideFragment extends BaseFragment implements ViewPager.OnPageChangeListener {

    @BindView(R.id.viewpager)
    ViewPager vp;
    private ViewPagerAdapter vpAdapter;
    private List<View> views;

    @BindView(R.id.ll)
    LinearLayout ll;
    // 底部小点图片
    private ImageView[] dots;

    // 记录当前选中位置
    private int currentIndex;
    private static final String SHAREDPREFERENCES_NAME = "first_pref";

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        View view = inflater.inflate(R.layout.fragment_guide, null);
        ButterKnife.bind(this, view);
        return view;
    }

    @Override
    protected void initUIandEvent() {
        super.initUIandEvent();

        LayoutInflater inflater = LayoutInflater.from(context);
        views = new ArrayList<View>();
        // 初始化引导图片列表
        views.add(inflater.inflate(R.layout.what_new_one, null));
        views.add(inflater.inflate(R.layout.what_new_two, null));
        views.add(inflater.inflate(R.layout.what_new_three, null));
        views.add(inflater.inflate(R.layout.what_new_four, null));
        // 初始化Adapter
        vpAdapter = new ViewPagerAdapter(views, context);
        vp.setAdapter(vpAdapter);
        // 绑定回调
        vp.setOnPageChangeListener(this);

        dots = new ImageView[views.size()];
        // 循环取得小点图片
        for (int i = 0; i < views.size(); i++) {
            dots[i] = (ImageView) ll.getChildAt(i);
            dots[i].setEnabled(true);// 都设为灰色
        }
        currentIndex = 0;
        dots[currentIndex].setEnabled(false);// 设置为白色，即选中状态
    }

    private void setCurrentDot(int position) {
        if (position < 0 || position > views.size() - 1
                || currentIndex == position) {
            return;
        }

        dots[position].setEnabled(false);
        dots[currentIndex].setEnabled(true);

        currentIndex = position;
    }

    // 当当前页面被滑动时调用
    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
        if (position == views.size() - 1) {
            ImageView mStartWeiboImageButton = (ImageView) views.get(position)
                    .findViewById(R.id.iv_start_weibo);
            mStartWeiboImageButton.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View v) {
                    // 设置已经引导
                    setGuided();
                    goHome();
                }

            });
        }

    }

    private void goHome() {
        // 跳转
        Intent intent = new Intent(context, HomeActivity.class);
        context.startActivity(intent);
        getActivity().finish();
    }

    /**
     * method desc：设置已经引导过了，下次启动不用再次引导
     */
    private void setGuided() {
        SharedPreferences preferences = context.getSharedPreferences(
                SHAREDPREFERENCES_NAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();
        // 存入数据
        editor.putBoolean("isFirstIn", false);
        // 提交修改
        editor.commit();
    }

    // 当新的页面被选中时调用
    @Override
    public void onPageSelected(int position) {
        // 设置底部小点选中状态
        setCurrentDot(position);
    }

    // 当滑动状态改变时调用
    @Override
    public void onPageScrollStateChanged(int state) {

    }
}
