package com.bawei.rikao18;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;

import com.bawei.rikao18.home.presenter.PresenterImple;
import com.bawei.rikao18.home.view.ViewInface;

public class MainActivity extends AppCompatActivity implements ViewInface{

    private RecyclerView recycle_view;
    private PresenterImple presenterImple;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recycle_view = findViewById(R.id.recycle_view);
        presenterImple = new PresenterImple(this);
        presenterImple.getPresenterData();

    }

    @Override
    public void getViewData(String data) {

        Log.i("dddd",data);
    }
}
