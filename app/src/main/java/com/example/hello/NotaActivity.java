package com.example.hello;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class NotaActivity extends AppCompatActivity {

    TextView jumlah, nama, harga, hargaTotal, pembayaran, kembalian;
    String txt_jumlah, txt_nama, txt_harga, txt_pembayaran;
    int intHargaTotal, intKembalian;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nota);

        jumlah = findViewById(R.id.nota_txt_jumlah);
        nama = findViewById(R.id.nota_txt_nama);
        harga = findViewById(R.id.nota_txt_harga);
        hargaTotal = findViewById(R.id.nota_harga_total);
        pembayaran = findViewById(R.id.nota_pembayaran);
        kembalian = findViewById(R.id.nota_kembalian);

        txt_pembayaran = getIntent().getStringExtra("pembayaran");
        intKembalian = getIntent().getIntExtra("kembalian", 0);

        pembayaran.setText(txt_pembayaran);
        kembalian.setText(String.valueOf(intKembalian));

        txt_jumlah = "";
        txt_nama = "";
        txt_harga = "";
        intHargaTotal = 0;

        for (int i=0; i < Main4Activity.kopiData.size(); i++){
            if (Main4Activity.kopiData.get(i).getTotal() > 0){
                txt_jumlah = txt_jumlah + Main4Activity.kopiData.get(i).getTotal() + "\n";
                txt_nama = txt_nama + Main4Activity.kopiData.get(i).getNamakopi() + "\n";
                txt_harga = txt_harga + (Main4Activity.kopiData.get(i).getTotal() * Main4Activity.kopiData.get(i).getHarga()) + "\n";
                intHargaTotal = intHargaTotal + (Main4Activity.kopiData.get(i).getTotal() * Main4Activity.kopiData.get(i).getHarga());
            }
        }

        jumlah.setText(txt_jumlah);
        nama.setText(txt_nama);
        harga.setText(txt_harga);
        hargaTotal.setText(String.valueOf(intHargaTotal) + "\n");
    }

    public void buttonLogout(View v){
        Intent intent = new Intent(this, Login4Activity.class);
        startActivity(intent);
        finish();
    }

    public void buttonMenu(View v){
        Intent intent = new Intent(this, Main4Activity.class);
        startActivity(intent);
        finish();
    }

    public void telp(View v){
        Intent intent = new Intent(Intent.ACTION_DIAL);
        intent.setData(Uri.parse("tel:+6581259212725"));
        startActivity(intent);
    }
}
