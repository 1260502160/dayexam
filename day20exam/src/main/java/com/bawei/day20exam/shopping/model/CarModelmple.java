package com.bawei.day20exam.shopping.model;

import com.bawei.day20exam.network.HttpUtils;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

public class CarModelmple implements ICarModelnface{
   CarModelnface carModelnface;

    public CarModelmple(CarModelnface carModelnface) {
        this.carModelnface = carModelnface;
    }

    @Override
    public void getCarModelData(String url) {

        HttpUtils.getInstance().httpGet(url, new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {

                carModelnface.getCarSuccess(response.body().string());
            }
        });

    }
    public interface CarModelnface{

        void getCarSuccess(String data);
        void getCarFailed();
    }
}
