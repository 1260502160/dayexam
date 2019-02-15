package com.bawei.day3rikao;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;

import com.bawei.day3rikao.api.Api;
import com.bawei.day3rikao.api.ShouApi;
import com.bawei.day3rikao.bean.Bean;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    private RecyclerView rec;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        rec = findViewById(R.id.rec);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(MainActivity.this, 2);
        rec.setLayoutManager(gridLayoutManager);
        //创建retrofit管理器
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Api.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())//解析数据
                .build();
        //实现接口
        ShouApi shouApi = retrofit.create(ShouApi.class);
        //第三部
      final Call<Bean> beanCall = shouApi.shou("卫衣", 1, 5);
      //第四部 请求
        beanCall.enqueue(new Callback<Bean>() {
            @Override
            public void onResponse(Call<Bean> call, Response<Bean> response) {
                Bean body = response.body();
                Log.e("+++++",body+"");
                if (body!=null){


                }
            }

            @Override
            public void onFailure(Call<Bean> call, Throwable t) {

            }
        });


    }
}
