package com.bawei.day20exam;

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
    private TextView text_right;
    private  Button btn_left;
    private setOnLeftAndRightClickListener listener;
    public void setOnLeftAndRightClickListener(setOnLeftAndRightClickListener listener){

        this.listener=listener;
    }
    public interface setOnLeftAndRightClickListener{

        void LeftListener();
        void RightListener();
    }
    public void setVisibility(boolean flag){

         if (flag){
             btn_left.setVisibility(View.VISIBLE);
         }else {

             btn_left.setVisibility(View.GONE);
         }
    }
    public TopBar(Context context, AttributeSet attrs) {
        super(context, attrs);

        View view = LayoutInflater.from(context).inflate(R.layout.layout_item, this);
        btn_left = view.findViewById(R.id.btn_left);
        text_title = view.findViewById(R.id.text_title);
        text_right = view.findViewById(R.id.text_right);
        btn_left.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                if (listener!=null){

                    listener.LeftListener();
                }
            }
        });
        text_right.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                if (listener!=null){

                    listener.RightListener();
                }
            }
        });

        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.TopBar);
        int leftbackground = typedArray.getResourceId(R.styleable.TopBar_LeftBackground, 0);
        String righttext = typedArray.getString(R.styleable.TopBar_RightText);
        String texttitle = typedArray.getString(R.styleable.TopBar_TextTitle);
        int textcolor = typedArray.getColor(R.styleable.TopBar_TextColor, 0);
        float textsize = typedArray.getDimension(R.styleable.TopBar_TextSize, 0);
        btn_left.setBackgroundResource(leftbackground);
        text_right.setText(righttext);
        text_title.setText(texttitle);
        text_title.setTextSize(textsize);
        text_title.setTextColor(textcolor);
    }
}
