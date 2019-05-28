package com.example.hello;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class TambahMahasiswa extends AppCompatActivity {

    protected Cursor cursor;
    DataHelper dbHelper;
    Button btnSimpan, btnKembali;
    EditText tambahNRP, tambahNama, tambahAlamat;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tambah_mahasiswa);

        dbHelper = new DataHelper(this);

        tambahNRP = findViewById(R.id.tambah_nrp);
        tambahNama = findViewById(R.id.tambah_nama);
        tambahAlamat = findViewById(R.id.tambah_alamat);
        btnSimpan = findViewById(R.id.btn_simpan);
        btnKembali = findViewById(R.id.btn_kembali);

    }

    public void buttonSave(View v) {
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        db.execSQL("insert into mahasiswa(nrp, nama, alamat) values('" +
                tambahNRP.getText().toString() + "','" +
                tambahNama.getText().toString() + "','" +
                tambahAlamat.getText().toString() + "')");
        Toast.makeText(getApplicationContext(), "Data Tersimpan", Toast.LENGTH_SHORT).show();
        Main5Activity.ma.RefreshList();
        finish();
    }

    public void buttonBack(View v){
        finish();
    }


}


