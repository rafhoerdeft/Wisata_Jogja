package com.example.bayu.wisata_jogja.Api;

import com.example.bayu.wisata_jogja.Model.Ent_wisata;
import com.example.bayu.wisata_jogja.Model.getData;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface Api_Interface {

   @GET("jsonBootcamp.php")
   Call<getData> tampil_wisata();
}
