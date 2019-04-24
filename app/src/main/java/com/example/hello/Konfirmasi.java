package com.example.hello;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Konfirmasi extends AppCompatActivity {
    TextView nmhold, nmres, tothold, totres, byrhold, byrres, kembhold, kembres;
    Button btnbck, btntel;
    Bundle bundle = new Bundle();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_konfirmasi);

        nmhold = findViewById(R.id.namares);
        nmres = findViewById(R.id.namahsl);
        tothold = findViewById(R.id.totalres);
        totres = findViewById(R.id.totalhsl);
        byrhold = findViewById(R.id.bayarres);
        byrres = findViewById(R.id.bayarhsl);
        kembhold = findViewById(R.id.kmblres);
        kembres = findViewById(R.id.kmblhsl);
        btnbck = findViewById(R.id.btnback);
        btntel = findViewById(R.id.btndial);
        bundle = getIntent().getExtras();

        String nama = bundle.getString("nama");
        nmres.setText(nama);
        String total = bundle.getString("total");
        totres.setText(total);
        String bayar = bundle.getString("bayar");
        byrres.setText(bayar);
        String kembali = bundle.getString("kembali");
        kembres.setText(kembali);

        btnbck.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bckpage();
            }
        });

        btntel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                call();
            }
        });
    }

    public void bckpage(){
        Intent intent = new Intent(this, Login4Activity.class);
        startActivity(intent);
    }

    public void call(){
        String nomor = "+6581259212725";
        Intent intent = new Intent(Intent.ACTION_DIAL);
        intent.setData(Uri.fromParts("tel",nomor,null));
        startActivity(intent);
    }
}

