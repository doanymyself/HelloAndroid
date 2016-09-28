package com.pact.hello.components.welcome;

import android.os.Bundle;

import com.pact.hello.R;
import com.pact.hello.framework.BaseActivity;

/**
 * ********************************************************
 * <p/>
 * ********************************************************
 * Created by wangdong on 2016/9/28.
 */

public class WelcomeActivity extends BaseActivity {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContenierView(2);
        setBackType(1);
        SplashFragment fragment = new SplashFragment();
        mFragmentManager.beginTransaction()
                .replace(R.id.login_fl_continer, fragment)
                .addToBackStack("SplashFragment").commit();
    }
}
