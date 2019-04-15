package com.example.appmusic.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.appmusic.R;
import com.example.appmusic.model.Album;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class AlbumAdapter extends RecyclerView.Adapter<AlbumAdapter.MyViewHolder> {
    private Context context;
    private ArrayList<Album> albumArrayList;

    public AlbumAdapter(Context context, ArrayList<Album> albumArrayList) {
        this.context = context;
        this.albumArrayList = albumArrayList;
    }


    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_album,viewGroup,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, int i) {
        Album album = albumArrayList.get(i);
        Log.e("Ablum",""+album.getTenCaSiAlbum());
        myViewHolder.tvArtistName.setText(album.getTenCaSiAlbum());
        myViewHolder.tvAlbumName.setText(album.getTenAlbum());
        if (album.getHinhAlbum()!=null){
            Picasso.with(context).load(album.getHinhAlbum()).into(myViewHolder.imgviewAlbum);
        }
    }

    @Override
    public int getItemCount() {
        return albumArrayList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{
        private ImageView imgviewAlbum;
        private TextView tvAlbumName, tvArtistName;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            imgviewAlbum = itemView.findViewById(R.id.imageview_album);
            tvAlbumName = itemView.findViewById(R.id.tv_album_name);
            tvArtistName = itemView.findViewById(R.id.tv_album_tencasi);
        }
    }
}
