package com.bawei.day2rikao;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //注册当前对象给eventbus
        EventBus.getDefault().register(this);


    }
    //保留
    @Subscribe
    public void receiveMsg(String msg){

        Toast.makeText(MainActivity.this,msg,Toast.LENGTH_LONG).show();
    }
    @Subscribe
    public void receviveUser(User user){

        Toast.makeText(MainActivity.this,user.name,Toast.LENGTH_LONG).show();
    }
    public void to2(View view){

        String s="我是1的数据";
        EventBus.getDefault().post(s);
        startActivity(new Intent(this,Main2Activity.class));
    }
}
