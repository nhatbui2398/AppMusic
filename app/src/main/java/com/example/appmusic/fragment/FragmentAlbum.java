package com.example.appmusic.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.appmusic.R;
import com.example.appmusic.adapter.AlbumAdapter;
import com.example.appmusic.model.Album;
import com.example.appmusic.service.APIService;
import com.example.appmusic.service.DataService;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class FragmentAlbum extends Fragment {
    private View view;
    private RecyclerView rcvAlbum;
    private TextView tvXemThemAlbum;
    private AlbumAdapter adapter;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_album, container, false);
        connectView();
        getData();
        return view;
    }

    private void connectView() {
        rcvAlbum = view.findViewById(R.id.rcv_album);
        tvXemThemAlbum = view.findViewById(R.id.tv_seeMore_album);

    }

    private void getData() {
        DataService dataService = APIService.getService();
        Call<List<Album>> callBack = dataService.getAlbum();
        callBack.enqueue(new Callback<List<Album>>() {
            @Override
            public void onResponse(Call<List<Album>> call, Response<List<Album>> response) {
                ArrayList<Album> albumArrayList = (ArrayList<Album>) response.body();
                adapter = new AlbumAdapter(getActivity(),albumArrayList);
                rcvAlbum.setAdapter(adapter);
                LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext(),LinearLayoutManager.HORIZONTAL,false);
                rcvAlbum.setLayoutManager(linearLayoutManager);

            }

            @Override
            public void onFailure(Call<List<Album>> call, Throwable t) {

            }
        });
    }
}
