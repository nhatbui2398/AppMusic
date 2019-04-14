package com.example.appmusic.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class PlayList {

    @SerializedName("IDPlayList")
    @Expose
    private String iDPlayList;
    @SerializedName("TenPlayList")
    @Expose
    private String tenPlayList;
    @SerializedName("HinhNenPlayList")
    @Expose
    private String hinhNenPlayList;
    @SerializedName("HinhIcon")
    @Expose
    private String hinhIcon;

    public String getIDPlayList() {
        return iDPlayList;
    }

    public void setIDPlayList(String iDPlayList) {
        this.iDPlayList = iDPlayList;
    }

    public String getTenPlayList() {
        return tenPlayList;
    }

    public void setTenPlayList(String tenPlayList) {
        this.tenPlayList = tenPlayList;
    }

    public String getHinhNenPlayList() {
        return hinhNenPlayList;
    }

    public void setHinhNenPlayList(String hinhNenPlayList) {
        this.hinhNenPlayList = hinhNenPlayList;
    }

    public String getHinhIcon() {
        return hinhIcon;
    }

    public void setHinhIcon(String hinhIcon) {
        this.hinhIcon = hinhIcon;
    }

}
