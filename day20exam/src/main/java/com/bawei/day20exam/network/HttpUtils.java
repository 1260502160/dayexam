package com.bawei.day20exam.network;

import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;

public class HttpUtils {

    private static OkHttpClient okHttpClient;
    private static Request request;
    private static volatile HttpUtils instance;
    public void httpGet(String url, Callback callback){

        okHttpClient = new OkHttpClient();
        request = new Request.Builder()
                .url(url)
                .method("GET", null)
                .build();
        okHttpClient.newCall(request).enqueue(callback);
    }

    public static HttpUtils getInstance(){

         if (instance==null){

               synchronized (HttpUtils.class){

                   if (instance==null){

                       instance=new HttpUtils();
                   }

               }
         }
         return instance;
    }
}
