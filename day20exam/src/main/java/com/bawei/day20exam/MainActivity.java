package com.bawei.day20exam;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.bawei.day20exam.fragment.HomeFragment;
import com.bawei.day20exam.fragment.MyFragment;
import com.hjm.bottomtabbar.BottomTabBar;

public class MainActivity extends AppCompatActivity {

    private BottomTabBar bottombar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TopBar topBar = findViewById(R.id.topbar);
        bottombar = findViewById(R.id.bottombar);
        bottombar.init(getSupportFragmentManager())
                .setFontSize(8)
                .setTabPadding(4,6,10)
                .setChangeColor(Color.RED,Color.DKGRAY)
                .setImgSize(50,50)
                .addTabItem("首页",R.drawable.home,HomeFragment.class)
                .addTabItem("购物车",R.drawable.shopcar,MyFragment.class)
                .isShowDivider(false)
                .setOnTabChangeListener(new BottomTabBar.OnTabChangeListener() {
                    @Override
                    public void onTabChange(int position, String name) {

                    }
                });
        topBar.setOnLeftAndRightClickListener(new TopBar.setOnLeftAndRightClickListener() {
            @Override
            public void LeftListener() {
                finish();
            }

            @Override
            public void RightListener() {

                Toast.makeText(MainActivity.this,"点击了提交",Toast.LENGTH_LONG).show();
            }
        });

    }
}
