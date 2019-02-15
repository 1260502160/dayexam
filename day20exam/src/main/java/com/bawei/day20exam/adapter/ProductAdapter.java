package com.bawei.day20exam.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bawei.day20exam.Jiajian;
import com.bawei.day20exam.R;
import com.bawei.day20exam.bean.CarBean;
import com.bumptech.glide.Glide;

import java.util.List;

public class ProductAdapter extends RecyclerView.Adapter<ProductAdapter.PMyViewHolder> {

    private  LayoutInflater pInflater;
    private Context context;
   private List<CarBean.DataBean.ListBean> plist;

    public ProductAdapter(Context context, List<CarBean.DataBean.ListBean> plist) {
        this.context = context;
        this.plist = plist;
        pInflater = LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public ProductAdapter.PMyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = pInflater.inflate(R.layout.product_layout, parent, false);
        PMyViewHolder pholder = new PMyViewHolder(view);
        return pholder;
    }

    @Override
    public void onBindViewHolder(@NonNull ProductAdapter.PMyViewHolder holder, int position) {


        Glide.with(context).load(plist.get(position).getImages().split("\\|")[0].replace("https","http")).into(holder.icon_cp);
        holder.textview_cp.setText(plist.get(position).getTitle());
        holder.zt_jiajian.setSum(plist.get(position).getNum());
    }

    @Override
    public int getItemCount() {
        return plist.size();
    }

    public class PMyViewHolder extends RecyclerView.ViewHolder {
        CheckBox check_cp;
        ImageView icon_cp;
        TextView textview_cp;
        Jiajian zt_jiajian;
        public PMyViewHolder(View itemView) {
            super(itemView);
            check_cp = itemView.findViewById(R.id.check_cp);
            icon_cp = itemView.findViewById(R.id.icon_cp);
            textview_cp = itemView.findViewById(R.id.textview_cp);
            zt_jiajian = itemView.findViewById(R.id.zt_jiajian);
            zt_jiajian.setOnJiaJianClickListener(new Jiajian.setOnJiaJianClickListener() {
                @Override
                public void JianClickListener() {
                    Toast.makeText(context,"点击了减",Toast.LENGTH_LONG).show();
                }

                @Override
                public void JiaClickListener() {

                    Toast.makeText(context,"点击了加",Toast.LENGTH_LONG).show();
                }
            });

        }
    }
}
