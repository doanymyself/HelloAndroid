package com.pact.hello.http;

import android.content.Context;

import org.xutils.common.Callback;
import org.xutils.common.util.LogUtil;

public class EnginCallBack<ResultType> implements Callback.ProgressCallback<ResultType> {

    private Context context;

    /**
     * 构造函数,为公共进度条重写此回调
     */
    public EnginCallBack(Context context) {
        this.context = context;
    }

    @Override
    public void onSuccess(ResultType result) {
        //TODO 根据公司业务需求，处理相应业务逻辑
        canclDialog();
        LogUtil.e(result.toString());
    }

    @Override
    public void onError(Throwable ex, boolean isOnCallback) {
        //TODO 根据公司业务需求，处理相应业务逻辑
        canclDialog();
    }

    @Override
    public void onCancelled(CancelledException cex) {
        //TODO 根据公司业务需求，处理相应业务逻辑
        canclDialog();
    }

    @Override
    public void onFinished() {
        //TODO 根据公司业务需求，处理相应业务逻辑
        canclDialog();
    }

    @Override
    public void onWaiting() {
        //TODO 根据公司业务需求，处理相应业务逻辑

    }

    @Override
    public void onStarted() {
        // 初始一个进度条
    }

    @Override
    public void onLoading(long total, long current, boolean isDownloading) {
        //TODO 根据公司业务需求，处理相应业务逻辑
    }

    /**
     * 取消进度条
     */
    public void canclDialog() {
        //
    }

}
