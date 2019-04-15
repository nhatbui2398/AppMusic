package com.example.appmusic.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class QuangCao implements Serializable {

    @SerializedName("IDQuangCao")
    @Expose
    private String iDQuangCao;
    @SerializedName("HinhQuangCao")
    @Expose
    private String hinhQuangCao;
    @SerializedName("NoiDung")
    @Expose
    private String noiDung;
    @SerializedName("IDBaiHat")
    @Expose
    private String iDBaiHat;
    @SerializedName("TenBaiHat")
    @Expose
    private String tenBaiHat;
    @SerializedName("HinhBaiHat")
    @Expose
    private String hinhBaiHat;

    public String getIDQuangCao() {
        return iDQuangCao;
    }

    public void setIDQuangCao(String iDQuangCao) {
        this.iDQuangCao = iDQuangCao;
    }

    public String getHinhQuangCao() {
        return hinhQuangCao;
    }

    public void setHinhQuangCao(String hinhQuangCao) {
        this.hinhQuangCao = hinhQuangCao;
    }

    public String getNoiDung() {
        return noiDung;
    }

    public void setNoiDung(String noiDung) {
        this.noiDung = noiDung;
    }

    public String getIDBaiHat() {
        return iDBaiHat;
    }

    public void setIDBaiHat(String iDBaiHat) {
        this.iDBaiHat = iDBaiHat;
    }

    public String getTenBaiHat() {
        return tenBaiHat;
    }

    public void setTenBaiHat(String tenBaiHat) {
        this.tenBaiHat = tenBaiHat;
    }

    public String getHinhBaiHat() {
        return hinhBaiHat;
    }

    public void setHinhBaiHat(String hinhBaiHat) {
        this.hinhBaiHat = hinhBaiHat;
    }

}
