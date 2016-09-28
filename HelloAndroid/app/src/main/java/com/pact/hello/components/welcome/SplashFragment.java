package com.pact.hello.components.welcome;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.pact.hello.R;
import com.pact.hello.framework.BaseFragment;

import butterknife.ButterKnife;

import static android.content.Context.MODE_PRIVATE;

/**
 * ********************************************************
 * 欢迎页面
 * ********************************************************
 * Created by wangdong on 2016/9/28.
 */

public class SplashFragment extends BaseFragment {

    boolean isFirstIn = false;

    private static final int GO_HOME = 0x1000;
    private static final int GO_GUIDE = 0x1001;
    // 延迟3秒
    private static final long SPLASH_DELAY_MILLIS = 3 * 1000;

    private static final String SHAREDPREFERENCES_NAME = "first_pref";

    /**
     * Handler:跳转到不同界面
     */
    private Handler mHandler = new Handler() {

        @Override
        public void handleMessage(Message msg) {
            switch (msg.what) {
                case GO_HOME:
                    goHome();
                    break;
                case GO_GUIDE:
                    goGuide();
                    break;
            }
            super.handleMessage(msg);
        }
    };

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_splash, null);
        ButterKnife.bind(this, view);
        return view;
    }

    @Override
    protected void initUIandEvent() {
        super.initUIandEvent();
        // 读取SharedPreferences中需要的数据
        // 使用SharedPreferences来记录程序的使用次数
        SharedPreferences preferences = context.getSharedPreferences(
                SHAREDPREFERENCES_NAME, MODE_PRIVATE);

        // 取得相应的值，如果没有该值，说明还未写入，用true作为默认值
        isFirstIn = preferences.getBoolean("isFirstIn", true);

        // 判断程序与第几次运行，如果是第一次运行则跳转到引导界面，否则跳转到主界面
        if (!isFirstIn) {
            // 使用Handler的postDelayed方法，3秒后执行跳转到MainActivity
            mHandler.sendEmptyMessageDelayed(GO_HOME, SPLASH_DELAY_MILLIS);
        } else {
            mHandler.sendEmptyMessageDelayed(GO_GUIDE, SPLASH_DELAY_MILLIS);
        }
    }

    private void goHome() {
        Intent intent = new Intent(context, HomeActivity.class);
        startActivity(intent);
        getActivity().finish();
    }

    private void goGuide() {
        /**
         * ft事务是全局的变量，只能commit一次。 在这里用局部ft事务去做commit。
         */
        mFragmentTransaction = getActivity().getSupportFragmentManager()
                .beginTransaction();
        mFragmentTransaction.replace(R.id.login_fl_continer, new GuideFragment())
                .addToBackStack("GuideFragment").commit();
    }
}
