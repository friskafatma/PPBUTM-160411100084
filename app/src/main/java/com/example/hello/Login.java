package com.example.hello;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Login extends AppCompatActivity {
    TextView judul;
    EditText nama,pw;
    Button masuk;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        judul = findViewById(R.id.logintxt);
        nama = findViewById(R.id.username);
        pw = findViewById(R.id.pwtxt);
        masuk = findViewById(R.id.btn_login);

        masuk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cek();
            }
        });
    }

    public void cek(){
        String user = "friska";
        String pass = "160411100084";
        String userget = nama.getText().toString();
        String passget = pw.getText().toString();

        Intent intent = new Intent(Login.this,Main3Activity.class);
        if (userget.length()>0){
            if(userget.matches(user)&&(passget.matches(pass))){
                startActivity(intent);
                finish();
            }else{
                Toast toast = Toast.makeText(getApplicationContext(),"Username dan Paassword salah", Toast.LENGTH_SHORT);
                toast.show();
            }
        }else{
            if(userget.isEmpty()){
                Toast toast = Toast.makeText(getApplicationContext(),"Username kosong", Toast.LENGTH_SHORT);
                toast.show();
            }else if (passget.isEmpty()){
                Toast toast = Toast.makeText(getApplicationContext(),"Password kosong", Toast.LENGTH_SHORT);
                toast.show();
            }
        }
    }
}

