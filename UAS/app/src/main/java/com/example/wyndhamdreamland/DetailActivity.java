package com.example.wyndhamdreamland;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import com.bumptech.glide.Glide;

public class DetailActivity extends AppCompatActivity {
    public static final String nama="room";
    public static final String deskripsi="deskripsi";
    public static final String adventage="adventage";
    public static final String facility="facility";
    public static final String harga="harga";
    public static final String gambar="null";
    public ImageView imdata;
    public TextView tvdeskripsidata;
    public TextView tvnamadata;
    public TextView tvadventagedata;
    public TextView tvhargadata;
    public TextView tvfacilitydata;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView( R.layout.activity_detail );

        tvnamadata=findViewById(R.id.tv_nama);
        tvdeskripsidata=findViewById(R.id.tv_deskripsi);
        tvadventagedata=findViewById(R.id.tv_adventage);
        tvfacilitydata=findViewById(R.id.tv_facility);
        tvhargadata=findViewById(R.id.tv_harga);
        imdata=findViewById(R.id.img_menu);

        String simpannama = getIntent().getStringExtra(nama);
        String simpandeskripsi = getIntent().getStringExtra(deskripsi);
        String simpanadventage = getIntent().getStringExtra(adventage);
        String simpanharga = getIntent().getStringExtra(harga);
        String simpanfacility = getIntent().getStringExtra(facility);
        String simpangambar = getIntent().getStringExtra(gambar);

        tvnamadata.setText(simpannama);
        tvdeskripsidata.setText(simpandeskripsi);
        tvadventagedata.setText(simpanadventage);
        tvfacilitydata.setText(simpanfacility);
        tvhargadata.setText(simpanharga);

        Glide
                .with(this)
                .load(simpangambar)
                .centerCrop()
                .into(imdata);

    }
}
