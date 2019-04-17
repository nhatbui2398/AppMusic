package com.example.appmusic.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.appmusic.R;
import com.example.appmusic.activity.DanhSachBaiHatActivity;
import com.example.appmusic.model.PlayList;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class AllPlayListAdapter extends RecyclerView.Adapter<AllPlayListAdapter.ViewHolder> {
    private Context context;
    private ArrayList<PlayList> lists;

    public AllPlayListAdapter(Context context, ArrayList<PlayList> lists) {
        this.context = context;
        this.lists = lists;
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_all_play_list, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        PlayList playList = lists.get(i);
        viewHolder.tvPlayListName.setText(playList.getTenPlayList());
        Picasso.with(context)
                .load(playList.getHinhIcon())
                .into(viewHolder.imgPlayList);

    }

    @Override
    public int getItemCount() {
        return lists.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private ImageView imgPlayList;
        private TextView tvPlayListName;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imgPlayList = itemView.findViewById(R.id.img_all_play_list);
            tvPlayListName = itemView.findViewById(R.id.tv_all_play_list_name);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(context, DanhSachBaiHatActivity.class);
                    intent.putExtra("ItemPlayList",lists.get(getPosition()));
                    context.startActivity(intent);
                }
            });
        }
    }
}
