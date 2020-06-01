package com.example.uts;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class DetailActivity extends AppCompatActivity {

    public static final String datanama="datanama";
    public static final String datatext="datatext";
    public static final String datagambar="null";
    public static final String dataadventages="dataadventages";
    public static final String datafacility="datafacility";
    public static final String dataharga="dataharga";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        TextView tvnama=findViewById(R.id.tv_nama);
        TextView tvtext=findViewById(R.id.tv_text);
        TextView tvadventages=findViewById(R.id.tv_adventages);
        TextView tvfacility=findViewById(R.id.tv_facility);
        TextView tvharga=findViewById(R.id.tv_harga);
        ImageView imgmenu=findViewById(R.id.img_menu);

        String simpannama= getIntent().getStringExtra(datanama);
        tvnama.setText(simpannama);
        String simpantext= getIntent().getStringExtra(datatext);
        tvtext.setText(simpantext);
        tvtext.setText(getIntent().getStringExtra(datatext));
        tvadventages.setText(getIntent().getStringExtra(dataadventages));
        tvharga.setText(getIntent().getStringExtra(dataharga));
        tvfacility.setText(getIntent().getStringExtra(datafacility));
        imgmenu.setImageResource(getIntent().getIntExtra(datagambar,0));
    }
}
