package com.example.hello;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class LihatMahasiswa extends AppCompatActivity {

    protected Cursor cursor;
    DataHelper dbHelper;
    TextView lihatNRP, lihatNama, lihatAlamat;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lihat_mahasiswa);

        dbHelper = new DataHelper(this);

        lihatNRP = findViewById(R.id.lihat_nrp);
        lihatNama = findViewById(R.id.lihat_nama);
        lihatAlamat = findViewById(R.id.lihat_alamat);

        SQLiteDatabase db = dbHelper.getReadableDatabase();
        cursor = db.rawQuery("select * from mahasiswa where nama = '" +
                getIntent().getStringExtra("nama") + "'", null);
        cursor.moveToFirst();
        if (cursor.getCount() > 0){
            cursor.moveToPosition(0);
            lihatNRP.setText(cursor.getString(0));
            lihatNama.setText(cursor.getString(1));
            lihatAlamat.setText(cursor.getString(2));
        }
    }

    public void buttonBack(View v){
        finish();
    }
}
