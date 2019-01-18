package com.example.bayu.wisata_jogja;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

public class DetailActivity extends AppCompatActivity {
private ImageButton cekMap;
private TextView tvArtikel,tvAlamat,tvNamaWisata;
private ImageView imgDetWisata;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        cekMap = findViewById(R.id.cekMap);
        tvNamaWisata = findViewById(R.id.tvNamaWisata);
        tvAlamat = findViewById(R.id.tvAlamat);
        tvArtikel = findViewById(R.id.tvArtikel);
        imgDetWisata = findViewById(R.id.imgDetWisata);

        Intent intent = getIntent();
        Picasso.with(getApplicationContext()).load(intent.getStringExtra("gambar_pariwisata")).resize(400,350)
                .into(imgDetWisata);
        tvNamaWisata.setText(intent.getStringExtra("nama_pariwisata"));
        tvAlamat.setText(intent.getStringExtra("alamat_pariwisata"));
        tvArtikel.setText(intent.getStringExtra("detail_pariwisata"));

        cekMap.setOnClickListener(l->{
            Uri gmmIntentUri = Uri.parse("http://maps.google.co.in/maps?q="+intent.getStringExtra("alamat_pariwisata"));
            Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
            mapIntent.setPackage("com.google.android.apps.maps");
            startActivity(mapIntent);
        });
    }
}
