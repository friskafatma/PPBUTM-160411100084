package com.example.hello;

import android.graphics.Bitmap;

public class Kopi {
    private int  id,harga, total;
    private Bitmap image;
    private String namakopi, detail;

    public Kopi(int id, int harga, int total, Bitmap image, String namakopi, String detail) {
        this.id = id;
        this.harga = harga;
        this.total = total;
        this.image = image;
        this.namakopi = namakopi;
        this.detail = detail;
    }

    public int getId() {

        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getHarga() {

        return harga;
    }

    public void setHarga(int harga) {
        this.harga = harga;
    }

    public int getTotal()
    {
        return total;
    }

    public void setTotal(int total)
    {
        this.total = total;
    }

    public Bitmap getImage()
    {
        return image;
    }

    public void setImage(Bitmap image)
    {
        this.image = image;
    }

    public String getNamakopi()
    {
        return namakopi;
    }

    public void setNamakopi(String namakopi)
    {
        this.namakopi = namakopi;
    }

    public String getDetail()
    {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }
}
