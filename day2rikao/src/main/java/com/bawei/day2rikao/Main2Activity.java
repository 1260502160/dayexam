package com.bawei.day2rikao;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

public class Main2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        //接收器
        EventBus.getDefault().register(this);

    }

    //保留接受内容
    @Subscribe
    public void receive1(String s){

        Toast.makeText(Main2Activity.this,s,Toast.LENGTH_LONG).show();
    }

    public void to1(View view) {
        String s="我是2的数据";
        String s1="我是2的数据11111";
        //发送普通string的事件
        EventBus.getDefault().post(s);
        EventBus.getDefault().post(s1);
        //发送对象的事件
        EventBus.getDefault().post(new User("kson"));
        this.finish();
    }
}
