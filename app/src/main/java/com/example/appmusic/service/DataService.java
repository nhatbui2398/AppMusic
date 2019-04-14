package com.example.appmusic.service;

import com.example.appmusic.model.PlayList;
import com.example.appmusic.model.QuangCao;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface DataService {
    @GET("getBanner.php")
    Call<List<QuangCao>> getDataBanner();

    @GET("getPlayList.php")
    Call<List<PlayList>> getPlayListCurrentDay();
}
