package com.example.wyndhamdreamland;

public class menu {
    private String nama;
    private String harga;
    private String gambar;

    public menu(String datanama, String dataharga, String datagambar){
        nama = datanama;
        harga = dataharga;
        gambar = datagambar;
    }

    public String getNama() {
        return nama;
    }

    public String getHarga() {
        return harga;
    }

    public String getGambar() {
        return gambar;
    }
}
