package com.example.appmusic.service;

import com.example.appmusic.model.Album;
import com.example.appmusic.model.BaiHat;
import com.example.appmusic.model.ChuDeTheLoaiTrongNgay;
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

    @GET("getChuDeTheLoai.php")
    Call<ChuDeTheLoaiTrongNgay> getChuDeTheLoaiTrongNgay();

    @GET("getAlbum.php")
    Call<List<Album>> getAlbum();

    @GET("getBHYeuThich.php")
    Call<List<BaiHat>> getBaiHatHot();
}
