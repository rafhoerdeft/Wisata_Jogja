package com.example.bayu.wisata_jogja.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Ent_wisata {
    @SerializedName("nama_pariwisata")
    @Expose
    private String nama_pariwisata;

    @SerializedName("alamat_pariwisata")
    @Expose
    private String alamat_pariwisata;

    @SerializedName("detail_pariwisata")
    @Expose
    private String detail_pariwisata;

    @SerializedName("gambar_pariwisata")
    @Expose
    private String gambar_pariwisata;


    public String getNama_pariwisata() {
        return nama_pariwisata;
    }

    public void setNama_pariwisata(String nama_pariwisata) {
        this.nama_pariwisata = nama_pariwisata;
    }

    public String getAlamat_pariwisata() {
        return alamat_pariwisata;
    }

    public void setAlamat_pariwisata(String alamat_pariwisata) {
        this.alamat_pariwisata = alamat_pariwisata;
    }

    public String getDetail_pariwisata() {
        return detail_pariwisata;
    }

    public void setDetail_pariwisata(String detail_pariwisata) {
        this.detail_pariwisata = detail_pariwisata;
    }

    public String getGambar_pariwisata() {
        return gambar_pariwisata;
    }

    public void setGambar_pariwisata(String gambar_pariwisata) {
        this.gambar_pariwisata = gambar_pariwisata;
    }
}
