package com.pact.hello.http;

import android.content.Context;
import android.content.pm.PackageManager;
import android.telephony.TelephonyManager;

import org.xutils.common.Callback;
import org.xutils.http.RequestParams;
import org.xutils.x;

import java.util.Map;

/**
 * ********************************************************
 * <p/>
 * ********************************************************
 * Created by wangdong on 2016/9/28.
 */

public class ServiceEngin {
    private static String url = "";

    /**
     * 发送get请求
     *
     * @param <T>
     */
    public static <T> void Get(String url, Callback.CommonCallback<T> callback) {
        RequestParams params = new RequestParams(url);
        x.http().get(params, callback);
    }

    /**
     * 发送post请求
     *
     * @param <T>
     */
    public static <T> void Post(String url, Map<String, Object> map, Callback.ProgressCallback<T> callback) {
        RequestParams params = new RequestParams(url);
        if (null != map) {
            for (Map.Entry<String, Object> entry : map.entrySet()) {
                params.addParameter(entry.getKey(), entry.getValue());
            }
        }
        x.http().post(params, callback);
    }

    /**
     * 上传文件
     *
     * @param <T>
     */
    public static <T> void UpLoadFile(String url, Map<String, Object> map, Callback.CommonCallback<T> callback) {
        RequestParams params = new RequestParams(url);
        if (null != map) {
            for (Map.Entry<String, Object> entry : map.entrySet()) {
                params.addParameter(entry.getKey(), entry.getValue());
            }
        }
        params.setMultipart(true);
        x.http().post(params, callback);
    }

    /**
     * 下载文件
     *
     * @param <T>
     */
    public static <T> void DownLoadFile(String url, String filepath, Callback.CommonCallback<T> callback) {
        RequestParams params = new RequestParams(url);
        //设置断点续传
        params.setAutoResume(true);
        params.setSaveFilePath(filepath);
        x.http().get(params, callback);
    }
}
