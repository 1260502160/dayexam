package com.bawei.rikao18.network;

import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;

public class OkHttp{

    private static OkHttpClient okHttpClient;
    private static Request request;

    public static void getHttp(String url, Callback callback){

        okHttpClient = new OkHttpClient();
        request = new Request.Builder()
                .url(url)
                .method("GET", null)
                .build();
        okHttpClient.newCall(request).enqueue(callback);

    }

}
