package com.example.bayu.wisata_jogja.Adapter;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.bayu.wisata_jogja.DetailActivity;
import com.example.bayu.wisata_jogja.Model.Ent_wisata;
import com.example.bayu.wisata_jogja.R;
import com.squareup.picasso.Picasso;

import java.util.List;

public class wisata_adapter extends RecyclerView.Adapter<wisata_adapter.MyViewHolder> {
    private Context context;
    private List<Ent_wisata> list_wisata;

    public wisata_adapter(Context context, List<Ent_wisata> list_wisata) {
        this.context = context;
        this.list_wisata = list_wisata;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.list_wisata,viewGroup,false);
        MyViewHolder mvHolder = new MyViewHolder(view);
        return mvHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int i) {
        holder.tvWisata.setText(list_wisata.get(i).getNama_pariwisata());
        Picasso.with(context).load(list_wisata.get(i).getGambar_pariwisata()).error(R.mipmap.ic_launcher)
                .into(holder.imgWisata);

        holder.itemView.setOnClickListener(l->{
            Intent intent = new Intent(context,DetailActivity.class);
            intent.putExtra("nama_pariwisata",list_wisata.get(i).getNama_pariwisata());
            intent.putExtra("detail_pariwisata",list_wisata.get(i).getDetail_pariwisata());
            intent.putExtra("alamat_pariwisata",list_wisata.get(i).getAlamat_pariwisata());
            intent.putExtra("gambar_pariwisata",list_wisata.get(i).getGambar_pariwisata());
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            context.startActivity(intent);

        });
    }

    @Override
    public int getItemCount() {
        return list_wisata.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        private TextView tvWisata;
        private ImageView imgWisata;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            tvWisata = itemView.findViewById(R.id.tvWisata);
            imgWisata = itemView.findViewById(R.id.imgWisata);
        }
    }
}
