package com.example.appmusic.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.appmusic.R;
import com.example.appmusic.model.BaiHat;

import java.util.ArrayList;

public class DanhSachBaiHatQCAdapter extends RecyclerView.Adapter<DanhSachBaiHatQCAdapter.ViewHolder> {
    private Context context;
    private ArrayList<BaiHat> list;

    public DanhSachBaiHatQCAdapter(Context context, ArrayList<BaiHat> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView tvSongName, tvSongArtist, tvIndex;
        private ImageView imgLike, imgDSBH;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvSongArtist = itemView.findViewById(R.id.tv_dsbh_song_artist);
            tvSongName = itemView.findViewById(R.id.tv_dsbh_song_name);
            tvIndex = itemView.findViewById(R.id.tv_dsbh_index);
            imgLike = itemView.findViewById(R.id.img_dsbh_like);
            imgDSBH = itemView.findViewById(R.id.img_dsbh);
        }
    }
}
