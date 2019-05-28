package com.example.hello;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class EditMahasiswa extends AppCompatActivity {

    protected Cursor cursor;
    DataHelper dbHelper;
    EditText editNRP, editNama, editAlamat;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_mahasiswa);

        dbHelper = new DataHelper(this);

        editNRP = findViewById(R.id.edit_nrp);
        editNama = findViewById(R.id.edit_nama);
        editAlamat = findViewById(R.id.edit_alamat);

        SQLiteDatabase db = dbHelper.getReadableDatabase();
        cursor = db.rawQuery("SELECT * FROM mahasiswa WHERE nama ='" +
                getIntent().getStringExtra("nama") + "'", null);
        cursor.moveToFirst();
        if (cursor.getCount() > 0){
            cursor.moveToPosition(0);
            editNRP.setText(cursor.getString(0));
            editNama.setText(cursor.getString(1));
            editAlamat.setText(cursor.getString(2));
        }

    }

    public void buttonUpdate(View v){
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        db.execSQL("update mahasiswa set nama = '" +
                editNama.getText().toString() + "', alamat ='" +
                editAlamat.getText().toString() + "' where nrp ='" +
                editNRP.getText().toString() + "'");
        Toast.makeText(getApplicationContext(), "Update Berhasil", Toast.LENGTH_SHORT).show();
        Main5Activity.ma.RefreshList();
        finish();
    }

    public void buttonBack(View v){
        finish();
    }
}
