package com.bawei.day20exam.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.OrientationHelper;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;

import com.bawei.day20exam.R;
import com.bawei.day20exam.adapter.CarAdapter;
import com.bawei.day20exam.bean.CarBean;
import com.bawei.day20exam.shopping.presenter.CarPresenterImple;
import com.bawei.day20exam.shopping.view.ICarViewInface;
import com.google.gson.Gson;

import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class MyFragment extends Fragment implements ICarViewInface{


    private CheckBox check_sj;
    private TextView text_sj;
    private RecyclerView recycle_sj;
    private Gson gson;
    private CarPresenterImple carPresenterImple;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_my, container, false);
        check_sj = view.findViewById(R.id.check_sj);
        text_sj = view.findViewById(R.id.text_sj);
        recycle_sj = view.findViewById(R.id.recycle_sj);
        carPresenterImple = new CarPresenterImple(this);
        carPresenterImple.getCarPresenterData();
        return view;
    }


    @Override
    public void getCarViewData(final String data) {
        Log.i("综合练习",data);
        getActivity().runOnUiThread(new Runnable() {
            @Override
            public void run() {

                gson = new Gson();
                CarBean carBean = gson.fromJson(data, CarBean.class);
                List<CarBean.DataBean> clist = carBean.getData();
                CarAdapter carAdapter = new CarAdapter(getContext(), clist);
                LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
                linearLayoutManager.setOrientation(OrientationHelper.VERTICAL);
                recycle_sj.setLayoutManager(linearLayoutManager);
                recycle_sj.setAdapter(carAdapter);


            }
        });
    }
}
