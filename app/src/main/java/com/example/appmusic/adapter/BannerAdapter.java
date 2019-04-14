package com.example.appmusic.adapter;

import android.content.Context;
import android.media.Image;
import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.appmusic.R;
import com.example.appmusic.model.QuangCao;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class BannerAdapter extends PagerAdapter {
    private Context context;
    private ArrayList<QuangCao> list;
    public BannerAdapter(Context context, ArrayList<QuangCao> list){
        this.context = context;
        this.list = list;
    }
    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object o) {

        return view == o;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_banner,null);

        ImageView imgBackGroundBanner = view.findViewById(R.id.imageView_banner);
        ImageView imgSongBanner = view.findViewById(R.id.imageView_song);
        TextView tvTitleSong = view.findViewById(R.id.tv_title);
        TextView tvContent = view.findViewById(R.id.tv_content);

        Picasso.with(context).load(list.get(position).getHinhQuangCao()).into(imgBackGroundBanner);
        Picasso.with(context).load(list.get(position).getHinhBaiHat()).into(imgSongBanner);
        tvTitleSong.setText(list.get(position).getTenBaiHat());
        tvContent.setText(list.get(position).getNoiDung());

        container.addView(view);
        return view;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((View) object);
    }
}
