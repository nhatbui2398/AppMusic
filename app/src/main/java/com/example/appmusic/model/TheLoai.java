package com.example.appmusic.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class TheLoai {

    @SerializedName("IDTheLoai")
    @Expose
    private String iDTheLoai;
    @SerializedName("IDChuDe")
    @Expose
    private Object iDChuDe;
    @SerializedName("TenTheLoai")
    @Expose
    private String tenTheLoai;
    @SerializedName("HinhTheLoai")
    @Expose
    private String hinhTheLoai;

    public String getIDTheLoai() {
        return iDTheLoai;
    }

    public void setIDTheLoai(String iDTheLoai) {
        this.iDTheLoai = iDTheLoai;
    }

    public Object getIDChuDe() {
        return iDChuDe;
    }

    public void setIDChuDe(Object iDChuDe) {
        this.iDChuDe = iDChuDe;
    }

    public String getTenTheLoai() {
        return tenTheLoai;
    }

    public void setTenTheLoai(String tenTheLoai) {
        this.tenTheLoai = tenTheLoai;
    }

    public String getHinhTheLoai() {
        return hinhTheLoai;
    }

    public void setHinhTheLoai(String hinhTheLoai) {
        this.hinhTheLoai = hinhTheLoai;
    }

}
