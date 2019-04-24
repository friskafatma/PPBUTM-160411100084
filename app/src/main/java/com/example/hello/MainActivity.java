package com.example.hello;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText text_edit;
    TextView app, txt;
    Button btn, btn2;
    String temp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        text_edit=findViewById(R.id.edittext);
        btn=findViewById(R.id.button);
        btn2=findViewById(R.id.btn_tgs2);
        txt=findViewById(R.id.textview);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                temp=text_edit.getText().toString();
                if(temp.length()==0) {
                    txt.setText("Nama belum diisi");
                }
                else{
                    txt.setText("Assalamualaikum "+temp);
                }
            }
        });
    }

    public void tugas1no2(View view) {
        Intent intent = new Intent(MainActivity.this,Main2Activity.class);
        startActivity(intent);
    }
}
