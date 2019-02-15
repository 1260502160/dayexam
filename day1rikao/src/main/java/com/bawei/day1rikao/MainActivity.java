package com.bawei.day1rikao;

import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.facebook.drawee.generic.GenericDraweeHierarchy;
import com.facebook.drawee.generic.GenericDraweeHierarchyBuilder;
import com.facebook.drawee.generic.RoundingParams;
import com.facebook.drawee.view.SimpleDraweeView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private SimpleDraweeView sdv;
    private Button icon_round;
    private Button icon_circle;
    private GenericDraweeHierarchyBuilder builder;
    private Uri uri;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        icon_round.setOnClickListener(this);
        icon_circle.setOnClickListener(this);

    }

    private void initView() {

        sdv = findViewById(R.id.sdv);
        icon_round = findViewById(R.id.icon_round);
        icon_circle = findViewById(R.id.icon_circle);
        uri = Uri.parse("https://img02.sogoucdn.com/net/a/04/link?url=https%3A%2F%2Fi01piccdn.sogoucdn.com%2F68e5aa51aae6b82d&appid=122");
        sdv.setImageURI(uri);
        builder = new GenericDraweeHierarchyBuilder(getResources());


    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){

            case R.id.icon_round:
                RoundingParams params = RoundingParams.fromCornersRadius(50f);
                GenericDraweeHierarchy hierarchy = builder.setRoundingParams(params).build();
                sdv.setHierarchy(hierarchy);
                sdv.setImageURI(uri);
                break;
            case R.id.icon_circle:
                RoundingParams params1 = RoundingParams.asCircle();
                GenericDraweeHierarchy hierarchy1 = builder.setRoundingParams(params1).build();
                sdv.setHierarchy(hierarchy1);
                sdv.setImageURI(uri);
                break;

        }

    }
}
