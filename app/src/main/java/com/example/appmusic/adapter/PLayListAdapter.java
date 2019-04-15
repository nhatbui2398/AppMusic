package com.example.appmusic.adapter;

import android.content.Context;
import android.media.Image;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.appmusic.R;
import com.example.appmusic.model.PlayList;
import com.squareup.picasso.Picasso;

import java.util.List;

public class PLayListAdapter extends ArrayAdapter<PlayList> {
    public PLayListAdapter(@NonNull Context context, int resource, @NonNull List<PlayList> objects) {
        super(context, resource, objects);
    }

    private class ViewHolder{
        private TextView tvTitle;
        ImageView imgBackGroundPL, imgPlayList;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        ViewHolder viewHolder;
        if (convertView == null){
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.item_playlist, parent,false);
            viewHolder = new ViewHolder();
            viewHolder.tvTitle = convertView.findViewById(R.id.tv_title_playlist);
            viewHolder.imgBackGroundPL = convertView.findViewById(R.id.imageView_playlist_background);
            viewHolder.imgPlayList= convertView.findViewById(R.id.imageView_PLayList);
            convertView.setTag(viewHolder);
        }
        else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        PlayList playList = getItem(position);
        Picasso.with(getContext()).load(playList.getHinhNenPlayList()).into(viewHolder.imgBackGroundPL);
        Picasso.with(getContext()).load(playList.getHinhIcon()).into(viewHolder.imgPlayList);
        viewHolder.tvTitle.setText(playList.getTenPlayList());
        return convertView;
    }
}
