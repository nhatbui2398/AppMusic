package com.example.appmusic.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.appmusic.R;
import com.example.appmusic.model.BaiHat;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class BaiHatHotAdapter extends RecyclerView.Adapter<BaiHatHotAdapter.MyViewHolder> {
    private Context context;
    private ArrayList<BaiHat> baiHatArrayList;

    public BaiHatHotAdapter(Context context, ArrayList<BaiHat> baiHatArrayList) {
        this.context = context;
        this.baiHatArrayList = baiHatArrayList;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_baihat_hot,viewGroup,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, int i) {
        BaiHat baiHat = baiHatArrayList.get(i);
        myViewHolder.tvTenCaSi.setText(baiHat.getCaSi());
        myViewHolder.tvTenBaiHat.setText(baiHat.getTenBaiHat());
        Picasso.with(context)
                .load(baiHat.getHinhBaiHat())
                .into(myViewHolder.imgHinhBH);

    }

    @Override
    public int getItemCount() {
        return baiHatArrayList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        private TextView tvTenBaiHat, tvTenCaSi;
        private ImageView imgHinhBH, imgYeuThich;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            tvTenBaiHat = itemView.findViewById(R.id.tv_ten_baihat_hot);
            tvTenCaSi = itemView.findViewById(R.id.tv_casi_baihat_hot);
            imgHinhBH = itemView.findViewById(R.id.img_baihat_hot);
            imgYeuThich = itemView.findViewById(R.id.img_icon_yeuthich);
        }
    }
}
