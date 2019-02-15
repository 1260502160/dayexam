package com.bawei.day18exam;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.umeng.socialize.UMShareAPI;
import com.umeng.socialize.bean.SHARE_MEDIA;

public class MainActivity extends AppCompatActivity {

    private Button btn_qqlogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TopBar topbar = findViewById(R.id.topbar);
        btn_qqlogin = findViewById(R.id.btn_qqlogin);
        btn_qqlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                UMSharePlatform.loginThirdParty(MainActivity.this, SHARE_MEDIA.QQ, new UMSharePlatform.LoginSuccessCallback() {
                    @Override
                    public void getLoginData(String uid) {

                    }
                });

            }
        });
        topbar.setOnLeftClickListener(new TopBar.setOnLeftClickListener() {
            @Override
            public void LeftClickListener() {
                finish();
            }
        });
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        UMShareAPI.get(this).onActivityResult(requestCode, resultCode, data);
    }
}
