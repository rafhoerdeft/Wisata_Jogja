package com.example.bayu.wisata_jogja.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class getData {
    @SerializedName("result")
    @Expose
    private String result;

    @SerializedName("data")
    @Expose
    private List<Ent_wisata> listData;

    public getData(String result, List<Ent_wisata> listData) {
        this.result = result;
        this.listData = listData;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public List<Ent_wisata> getListData() {
        return listData;
    }

    public void setListData(List<Ent_wisata> listData) {
        this.listData = listData;
    }
}
