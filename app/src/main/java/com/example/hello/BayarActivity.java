package com.example.hello;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class BayarActivity extends AppCompatActivity {

    TextView jumlah, nama, harga, hargaTotal;
    EditText bayar;
    Toolbar toolbar;
    String txt_jumlah, txt_nama, txt_harga;
    int intHargaTotal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bayar);

        toolbar = findViewById(R.id.toolbar_layout);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        jumlah = findViewById(R.id.txt_jumlah);
        nama = findViewById(R.id.txt_nama);
        harga = findViewById(R.id.txt_harga);
        hargaTotal = findViewById(R.id.harga_total);
        bayar = findViewById(R.id.pembayaran);

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

    public boolean onOptionsItemSelected(MenuItem item) {
        finish();
        return true;
    }

    public void buttonCheckout(View v){

        if (bayar.getText().toString().isEmpty()){
            Toast.makeText(this, "Anda Belum Membayar", Toast.LENGTH_SHORT).show();
        }
        else if (Integer.parseInt(bayar.getText().toString()) < intHargaTotal){
            Toast.makeText(this, "Uang Anda Tidak Cukup", Toast.LENGTH_SHORT).show();
        }
        else {
            Intent intent = new Intent(this, NotaActivity.class);
            intent.putExtra("pembayaran", bayar.getText().toString());
            intent.putExtra("kembalian", Integer.parseInt(bayar.getText().toString()) - intHargaTotal);
            startActivity(intent);
            finish();
        }
    }
}
