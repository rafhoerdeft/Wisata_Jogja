package com.example.bayu.wisata_jogja;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Button;
import android.widget.Toast;

import com.example.bayu.wisata_jogja.Adapter.wisata_adapter;
import com.example.bayu.wisata_jogja.Api.Api_Client;
import com.example.bayu.wisata_jogja.Api.Api_Interface;
import com.example.bayu.wisata_jogja.Model.Ent_wisata;
import com.example.bayu.wisata_jogja.Model.SharedPref;
import com.example.bayu.wisata_jogja.Model.getData;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Tampil_WisataActivity extends AppCompatActivity {
private RecyclerView.Adapter mAdapter;
private RecyclerView rv_listWisata;
private RecyclerView.LayoutManager mLayoutManager;
private Api_Interface api_interface;
private Button btnLogOut;
SharedPref sharedPref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tampil__wisata);

        sharedPref = new SharedPref(this);
        api_interface = Api_Client.getClient().create(Api_Interface.class);
        rv_listWisata = findViewById(R.id.rv_listWisata);
        btnLogOut = findViewById(R.id.btnLogout);
        mLayoutManager = new LinearLayoutManager(this);
        rv_listWisata.setLayoutManager(mLayoutManager);
        tampilWisata();

        btnLogOut.setOnClickListener(l->{
            showDialog();
        });
    }

    private void tampilWisata()
    {
       Call<getData> call_listWisata = api_interface.tampil_wisata();
        call_listWisata.enqueue(new Callback<getData>() {
            @Override
            public void onResponse(Call<getData> call, Response<getData> response) {
                List<Ent_wisata> listWisata = response.body().getListData();
                mAdapter = new wisata_adapter(getApplicationContext(),listWisata);
                rv_listWisata.setAdapter(mAdapter);
            }

            @Override
            public void onFailure(Call<getData> call, Throwable t) {
                Toast.makeText(getApplicationContext(),t.getMessage(),Toast.LENGTH_LONG).show();
            }
        });
    }

    @Override
    public void onBackPressed() {
        showDialog();
    }

    private void showDialog(){
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);

        // set title dialog
        alertDialogBuilder.setTitle("Are you Sure to Logout ?");

        // set pesan dari dialog
        alertDialogBuilder
                .setMessage("Klik Ya untuk Logout!")
                .setIcon(R.mipmap.ic_launcher)
                .setCancelable(false)
                .setPositiveButton("Ya",new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog,int id) {
                        sharedPref.saveSPBoolean(SharedPref.SP_SUDAH_LOGIN,false);
                        sharedPref.saveSPString("username","");
                        sharedPref.saveSPString("password","");
                        startActivity(new Intent(getApplicationContext(), LoginActivity.class)
                                .addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK));
                        finish();
                    }
                })
                .setNegativeButton("Tidak",new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        // jika tombol ini diklik, akan menutup dialog
                        // dan tidak terjadi apa2
                        dialog.cancel();
                    }
                });

        // membuat alert dialog dari builder
        AlertDialog alertDialog = alertDialogBuilder.create();

        // menampilkan alert dialog
        alertDialog.show();
    }
}
