package com.bawei.day20exam;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;

public class Jiajian extends RelativeLayout{

    private EditText edit_text;
    private  Button btn_jia;
    private Button btn_jian;
    private setOnJiaJianClickListener listener;
    public void setOnJiaJianClickListener(setOnJiaJianClickListener listener){

        this.listener=listener;
    }
    public interface setOnJiaJianClickListener{

        void JianClickListener();
        void JiaClickListener();
    }
    public void setSum(String data){

        edit_text.setText(data);
    }
    public Jiajian(Context context, AttributeSet attrs) {
        super(context, attrs);
        View view = LayoutInflater.from(context).inflate(R.layout.layout_jiajian, this);
        btn_jian = view.findViewById(R.id.btn_jian);
        btn_jia = view.findViewById(R.id.btn_jia);
        edit_text = view.findViewById(R.id.edit_text);
        btn_jian.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                if (listener!=null){

                    listener.JianClickListener();
                }
            }
        });

        btn_jia.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                if (listener!=null){

                    listener.JiaClickListener();
                }
            }
        });

        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.ReduceAdd);
        int redue = typedArray.getResourceId(R.styleable.ReduceAdd_ReDuce, 0);
        int add = typedArray.getResourceId(R.styleable.ReduceAdd_Add, 0);
        String hint = typedArray.getString(R.styleable.ReduceAdd_Hint);
        btn_jian.setBackgroundResource(redue);
        btn_jia.setBackgroundResource(add);
        edit_text.setText(hint);


    }
}
