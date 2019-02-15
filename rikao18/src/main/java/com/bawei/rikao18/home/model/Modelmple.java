package com.bawei.rikao18.home.model;

import com.bawei.rikao18.network.OkHttp;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

public class Modelmple implements Modelnface{
    Modulnface modulnface;

    public Modelmple(Modulnface modulnface) {
        this.modulnface = modulnface;
    }

    @Override
    public void getModelData(String url) {

        OkHttp.getHttp(url, new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {

                modulnface.getModelSuccess(response.body().string());
            }
        });
    }

    public interface Modulnface{

        void getModelSuccess(String data);
        void getModelFailed();
    }
}
