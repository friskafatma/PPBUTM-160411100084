package com.example.hello;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class PesanKopi extends AppCompatActivity {

    int id, intTotal;
    ImageView image;
    TextView namakopi, total, detail;
    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pesan_kopi);

        toolbar = findViewById(R.id.toolbar_layout);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        id = getIntent().getIntExtra("ID", 0);

        intTotal = Main4Activity.kopiData.get(id).getTotal();

        image = findViewById(R.id.img_pesan);
        image.setImageBitmap(Main4Activity.kopiData.get(id).getImage());

        namakopi = findViewById(R.id.namakopi_pesan);
        namakopi.setText(Main4Activity.kopiData.get(id).getNamakopi());

        total = findViewById(R.id.total);
        total.setText(String.valueOf(intTotal));

        detail = findViewById(R.id.detail_pesan);
        detail.setText(Main4Activity.kopiData.get(id).getDetail());
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        finish();
        return true;
    }

    public void buttonClick(View v){
        Button button = (Button) v;

        switch (button.getId()){
            case R.id.button_minus:
                intTotal --;
                break;
            case R.id.button_plus:
                intTotal ++;
                break;
        }

        if (intTotal < 0){
            intTotal = 0;
            Toast.makeText(this, "Batas Minimum", Toast.LENGTH_SHORT).show();
        }
        else if (intTotal > 9){
            intTotal = 9;
            Toast.makeText(this, "Batas Maksimum", Toast.LENGTH_SHORT).show();
        }
        total.setText(String.valueOf(intTotal));

    }

    public void buttonPesan(View v){
        if (intTotal == 0){
            Toast.makeText(this, "Anda belum memesan", Toast.LENGTH_SHORT).show();
        }
        else {
            Main4Activity.kopiData.get(id).setTotal(intTotal);
            finish();
        }
    }
}
