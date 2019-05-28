package com.example.hello;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Main2Activity extends AppCompatActivity {
    TextView judul, hasil, status;
    EditText berat,tinggi;
    String tempbb, temptb;
    double bb, tb;
    Button cek,btn2,btn3,btn4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        judul=findViewById(R.id.bmi);
        berat=findViewById(R.id.bbtext);
        tinggi=findViewById(R.id.tbtext);
        cek=findViewById(R.id.btn_bmi);
        btn2=findViewById(R.id.btn_tgs1);
        btn3=findViewById(R.id.btn_tgs2);
        btn3=findViewById(R.id.btn_tgs3);
        hasil=findViewById(R.id.resultbmi);
        status=findViewById(R.id.statusbmi);

        cek.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (berat.length()==0 && tinggi.length()==0){
                    hasil.setText("Berat badan dan tinggi badan belum diisi");
                }else if(berat.length()==0){
                    hasil.setText("Berat badan belum diisi");
                }else if(tinggi.length()==0){
                    hasil.setText("Tinggi badan belum diisi");
                }
                else{
                    tempbb=berat.getText().toString();
                    temptb=tinggi.getText().toString();

                    bb = Double.parseDouble(tempbb);
                    tb = Double.parseDouble(temptb);

                    hitung(bb,tb);
                }
            }
        });
    }

    public void hitung(double bb, double tb){
        double bmi =bb / ((tb/100) * (tb/100));
        if (bmi < 18.5) {
            hasil.setText("BMI anda : " + Double.toString(bmi));
            status.setText("Berat Badan Kurang");
        } else if (bmi >= 18.5 && bmi <= 24.9) {
            hasil.setText("BMI anda : " + Double.toString(bmi));
            status.setText("Berat Badan Normal");
        } else if (bmi >= 25 && bmi <= 29.9) {
            hasil.setText("BMI anda : " + Double.toString(bmi));
            status.setText("BMI anda : " + "Berat Badan Berlebih");
        } else if (bmi >= 30 && bmi <= 34.9) {
            hasil.setText("BMI anda : " + Double.toString(bmi));
            status.setText("Obesititas Tahap 1");
        } else if (bmi >= 35 && bmi <= 39.9) {
            hasil.setText("BMI anda : " + Double.toString(bmi));
            status.setText("Obesititas Tahap 2");
        } else {
            hasil.setText("BMI anda : " + Double.toString(bmi));
            status.setText("Obesititas Tahap 3");
        }
    }


    public void tugas1no1(View view) {
        Intent intent = new Intent(Main2Activity.this,Login.class);
        startActivity(intent);
    }

    public void tugas4(View view) {
        Intent intent = new Intent(Main2Activity.this,Login4Activity.class);
        startActivity(intent);
    }

    public void modul5(View view) {
        Intent intent = new Intent(Main2Activity.this,Main5Activity.class);
        startActivity(intent);
    }
}

