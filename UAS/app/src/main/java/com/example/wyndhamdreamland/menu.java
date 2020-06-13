package com.example.wyndhamdreamland;

public class menu {
    private String nama;
    private String harga;
    private String gambar;
    private String adventage;
    private String deskripsi;
    private String facility;

    public menu(String datanama, String dataharga, String datagambar,String dataadventage,String datadeskripsi,String datafacility){
        nama = datanama;
        harga = dataharga;
        gambar = datagambar;
        adventage = dataadventage;
        deskripsi = datadeskripsi;
        facility = datafacility;
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

    public String getAdventage() {
        return adventage;
    }

    public String getDeskripsi() {
        return deskripsi;
    }

    public String getFacility() {
        return facility;
    }
}
