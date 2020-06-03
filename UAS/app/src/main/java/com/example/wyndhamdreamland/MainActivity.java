package com.example.wyndhamdreamland;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {
private MenuAdapter menuAdapter;
private RecyclerView recyclerView;
private ArrayList<menu> menus;
int jumdata;
private RequestQueue requestQueue;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setContentView(R.layout.item_menu);
        recyclerView=findViewById(R.id.rv_list);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        menus=new ArrayList<>();
        requestQueue= Volley.newRequestQueue(this);
        parseJSON();
    }

    private void parseJSON() {
        String url="https://olympias.000webhostapp.com/koneksi.php";
        JsonArrayRequest request= new JsonArrayRequest(Request.Method.GET, url, null,
                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {
                        jumdata = response.length();
                        try {
                            for (int i = 0; i < jumdata; i++) {
                                JSONObject data = response.getJSONObject(i);
                                String gambarmenu = data.getString("gambar");
                                String namamenu = data.getString("room");
                                String hargamenu = data.getString("harga");
                                menus.add(new menu(namamenu, hargamenu, gambarmenu));
                            }
                            menuAdapter = new MenuAdapter(MainActivity.this, menus);
                            recyclerView.setAdapter(menuAdapter);
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                error.printStackTrace();
            }
    });
        requestQueue.add(request);
    }

    public void Pindah(View view) {
        Intent intent = new Intent(MainActivity.this, DetailActivity.class);
        startActivity(intent);
    }
}
