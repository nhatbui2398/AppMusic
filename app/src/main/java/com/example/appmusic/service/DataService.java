package com.example.appmusic.service;

import com.example.appmusic.model.Album;
import com.example.appmusic.model.BaiHat;
import com.example.appmusic.model.ChuDeTheLoaiTrongNgay;
import com.example.appmusic.model.PlayList;
import com.example.appmusic.model.QuangCao;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface DataService {
    @GET("getBanner.php")
    Call<List<QuangCao>> getDataBanner();

    @GET("getPlayListCurrentDay.php")
    Call<List<PlayList>> getPlayListCurrentDay();

    @GET("getPlayList.php")
    Call<List<PlayList>> getAllPlayList();

    @GET("getChuDeTheLoai.php")
    Call<ChuDeTheLoaiTrongNgay> getChuDeTheLoaiTrongNgay();

    @GET("getAlbum.php")
    Call<List<Album>> getAlbum();

    @GET("getBHYeuThich.php")
    Call<List<BaiHat>> getBaiHatHot();

    @FormUrlEncoded
    @POST("getDanhSachBaiHat.php")
    Call<List<BaiHat>> getDSBHQuangCao(@Field("IDQuangCao") String idQC);


    @FormUrlEncoded
    @POST("getDanhSachBaiHat.php")
    Call<List<BaiHat>> getDSBHPlayList(@Field("IDPlayList") String idPlayList);

    @FormUrlEncoded
    @POST("getDanhSachBaiHat.php")
    Call<List<BaiHat>> getDSBHTheLoai(@Field("IDTheLoai") String idTheLoai);
}
