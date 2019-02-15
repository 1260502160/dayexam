package com.bawei.day19exam;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class TopBar extends RelativeLayout{

    private  TextView text_title;
    private  Button btn_left;
    private setOnLeftClickListener listener;
    public void setOnLeftClickListener(setOnLeftClickListener listener){

        this.listener=listener;
    }
    public interface setOnLeftClickListener{

         void LeftClickListener();

    }

    public void setLeftVisibility(boolean flag){

        if (flag){

             btn_left.setVisibility(View.VISIBLE);
        }else{
            btn_left.setVisibility(View.GONE);
        }
    }
    public TopBar(Context context, AttributeSet attrs) {
        super(context, attrs);
        LayoutInflater.from(context).inflate(R.layout.item_layout,this);
        btn_left = findViewById(R.id.btn_left);
        text_title = findViewById(R.id.text_title);
        btn_left.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                if (listener!=null){

                    listener.LeftClickListener();
                }
            }
        });

        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.TopBar);
        int leftbackground = typedArray.getResourceId(R.styleable.TopBar_leftBackground, 0);
        String texttitle = typedArray.getString(R.styleable.TopBar_textTitle);
        float textsize = typedArray.getDimension(R.styleable.TopBar_textSize, 0);
        int textcolor = typedArray.getColor(R.styleable.TopBar_textColor, 0);
        btn_left.setBackgroundResource(leftbackground);
        text_title.setText(texttitle);
        text_title.setTextColor(textcolor);
        text_title.setTextSize(textsize);

    }
}
