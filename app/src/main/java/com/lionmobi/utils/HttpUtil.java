package com.lionmobi.utils;

import com.squareup.okhttp.Callback;
import com.squareup.okhttp.FormEncodingBuilder;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;

import java.util.Map;

/**
 * Created by ChenR on 2016/12/26.
 */

public class HttpUtil {

    private static HttpUtil httpUtil;
    private OkHttpClient mOkHttpClient;

    private HttpUtil () {
        mOkHttpClient = new OkHttpClient();
    }

    public static HttpUtil getIntance() {
        if (httpUtil == null) {
            synchronized (HttpUtil.class) {
                if (httpUtil == null) {
                    httpUtil = new HttpUtil();
                }
            }
        }
        return httpUtil;
    }

    /**
     * okhttp 的get请求;
     * @param url           http接口;
     * @param params        请求的参数;
     * @param callback      网络请求回调;
     */
    public void get (String url, Map<String, String> params, Callback callback) {
        if (url.indexOf("?") == -1) {
            url += "?";
        }
        if (url.endsWith("?") && params != null) {
            StringBuffer sb = new StringBuffer(url);
            for (Map.Entry<String, String> entry : params.entrySet()) {
                sb.append(entry.getKey()).append("=").append(entry.getValue()).append("&");
            }
            sb.deleteCharAt(sb.length() - 1);
        }

        Request request = new Request.Builder()
                .get()
                .url(url)
                .build();
        mOkHttpClient.newCall(request).enqueue(callback);
    }

    /**
     * OKhttp post请求;
     * @param url
     * @param params
     * @param callback
     */
    public void post (String url, Map<String, String> params, Callback callback) {
        if (params == null || params.isEmpty()) {
            return;
        }
        FormEncodingBuilder builder = new FormEncodingBuilder();
        for (Map.Entry<String, String> entry : params.entrySet()) {
            builder.add(entry.getKey(), entry.getValue());
        }

        Request request = new Request.Builder()
                .url(url)
                .post(builder.build())
                .build();

        mOkHttpClient.newCall(request).enqueue(callback);
    }

}
