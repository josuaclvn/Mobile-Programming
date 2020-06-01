package com.example.uts;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    //private String [] dataMenu={"kamar1", "kamar2", "kamar3", "villa1","villa2","villa3"};
private MenuAdapter adapter;
private String[] dataNama;
private String[] dataDes;
private  String[] dataAdventages;
private String[] dataFacility;
private String[] dataText;
private String[] dataHarga;
private TypedArray dataGambar;
private ArrayList<Menu> menus;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView lvlist= findViewById(R.id.lv_list);
        adapter=new MenuAdapter(this);
        lvlist.setAdapter(adapter);

        prepare();
        tambahitem();

        lvlist.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                //Toast.makeText(MainActivity.this, menus.get(i).getNama(), Toast.LENGTH_SHORT).show();
                Intent pindahdata=new Intent(MainActivity.this,DetailActivity.class);
                pindahdata.putExtra(DetailActivity.datanama,menus.get(i).getNama());
                pindahdata.putExtra(DetailActivity.datatext,menus.get(i).getText());
                pindahdata.putExtra(DetailActivity.datagambar,menus.get(i).getGambar());
                pindahdata.putExtra(DetailActivity.dataadventages,menus.get(i).getAdventages());
                pindahdata.putExtra(DetailActivity.datafacility,menus.get(i).getFacility());
                pindahdata.putExtra(DetailActivity.dataharga,menus.get(i).getHarga());
                startActivity(pindahdata);
            }
        });

    }
    private void prepare(){
        dataNama=getResources().getStringArray(R.array.data_nama);
        dataDes=getResources().getStringArray(R.array.data_deskripsi);
        dataGambar=getResources().obtainTypedArray(R.array.data_gambar);
        dataAdventages=getResources().getStringArray(R.array.data_adventages);
        dataFacility=getResources().getStringArray(R.array.data_facilities);
        dataText=getResources().getStringArray(R.array.data_text);
        dataHarga=getResources().getStringArray(R.array.data_harga);

    }
    private void tambahitem(){
        menus = new ArrayList<>();
        for (int i=0; i<dataNama.length; i++ ){
            Menu menu= new Menu();
            menu.setGambar(dataGambar.getResourceId(i, -1));
            menu.setNama(dataNama[i]);
            menu.setAdventages(dataAdventages[i]);
            menu.setDeskripsi(dataDes[i]);
            menu.setFacility(dataFacility[i]);
            menu.setText(dataText[i]);
            menu.setHarga(dataHarga[i]);

            menus.add(menu);
        }
        adapter.setMenus(menus);
    }
}
