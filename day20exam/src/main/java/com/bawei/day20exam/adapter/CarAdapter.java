package com.bawei.day20exam.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.OrientationHelper;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;

import com.bawei.day20exam.R;
import com.bawei.day20exam.bean.CarBean;

import java.util.List;

public class CarAdapter extends RecyclerView.Adapter<CarAdapter.CarMyViewHolder> {

    private  RecyclerView recycle_sj;
    private  LayoutInflater cInflater;
    private Context context;
    private List<CarBean.DataBean> clist;


    public CarAdapter(Context context, List<CarBean.DataBean> clist) {
        this.context = context;
        this.clist = clist;
        cInflater = LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public CarMyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = cInflater.inflate(R.layout.fragment_my, parent, false);
        recycle_sj = view.findViewById(R.id.recycle_sj);
        CarMyViewHolder cholder = new CarMyViewHolder(view);
        return cholder;
    }

    @Override
    public void onBindViewHolder(@NonNull CarMyViewHolder holder, int position) {

        holder.text_sj.setText(clist.get(position+1).getSellerName());
        ProductAdapter productAdapter = new ProductAdapter(context, clist.get(position + 1).getList());
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(context);
        linearLayoutManager.setOrientation(OrientationHelper.HORIZONTAL);
        recycle_sj.setAdapter(productAdapter);
        recycle_sj.setLayoutManager(linearLayoutManager);
    }

    @Override
    public int getItemCount() {
        return clist.size()-1;
    }

    public class CarMyViewHolder extends RecyclerView.ViewHolder {
        CheckBox check_sj;
        TextView text_sj;
        RecyclerView recycle_sj;
        public CarMyViewHolder(View itemView) {
            super(itemView);
            check_sj = itemView.findViewById(R.id.check_sj);
            text_sj = itemView.findViewById(R.id.text_sj);
            recycle_sj = itemView.findViewById(R.id.recycle_sj);

        }
    }
}
