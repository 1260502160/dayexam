package com.bawei.day19exam;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TopBar topbar = findViewById(R.id.topbar);
        topbar.setOnLeftClickListener(new TopBar.setOnLeftClickListener() {
            @Override
            public void LeftClickListener() {
                finish();
            }
        });
    }
}
