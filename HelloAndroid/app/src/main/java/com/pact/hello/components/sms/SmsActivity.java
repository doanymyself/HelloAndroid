package com.pact.hello.components.sms;

import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;

import com.pact.hello.R;
import com.pact.hello.utils.ReadSmsContent;
import com.pact.hello.view.ClearEditText;
import com.pact.hello.view.PasswordEditText;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * ********************************************************
 * 短信验证码自动输入
 * 各种输入框
 * ********************************************************
 * Created by wangdong on 2016/9/28.
 */
public class SmsActivity extends AppCompatActivity {
    @BindView(R.id.ClearEditText)
    ClearEditText mClearEditText;
    @BindView(R.id.PasswordEditText)
    PasswordEditText mPasswordEditText;
    //短信监听
    private ReadSmsContent readSmsContent;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sms);
        ButterKnife.bind(this);

        readSmsContent = new ReadSmsContent(new Handler(), this, mClearEditText);
        //注册短信内容监听
        getContentResolver().registerContentObserver(Uri.parse("content://sms/"), true, readSmsContent);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        //注销内容监听者
        getContentResolver().unregisterContentObserver(readSmsContent);
    }
}
