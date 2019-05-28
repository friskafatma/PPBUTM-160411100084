package com.example.hello;

import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

public class Main5Activity extends AppCompatActivity {

    String[] daftar;
    ListView listView;
    protected Cursor cursor;
    DataHelper dbcenter;
    public static Main5Activity ma;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main5);

        Button btn = findViewById(R.id.btn_tambah);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Main5Activity.this, TambahMahasiswa.class);
                startActivity(intent);
            }
        });

        ma = this;
        dbcenter = new DataHelper(this);

        RefreshList();

    }

    public void RefreshList() {
        SQLiteDatabase db = dbcenter.getReadableDatabase();
        cursor = db.rawQuery("SELECT * FROM mahasiswa", null);
        daftar = new String[cursor.getCount()];
        cursor.moveToFirst();

        for (int cc = 0; cc < cursor.getCount(); cc++) {
            cursor.moveToPosition(cc);
            daftar[cc] = cursor.getString(1).toString();
        }

        listView = findViewById(R.id.list_view);
        listView.setAdapter(new ArrayAdapter(this, android.R.layout.simple_list_item_1, daftar));
        listView.setSelected(true);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView adapterView, View view, int i, long l) {
                final String selection = daftar[i];
                final CharSequence[] dialogItem = {"Lihat Mahasiswa", "Update Mahasiswa", "Hapus Mahasiswa"};

                AlertDialog.Builder builder = new AlertDialog.Builder(Main5Activity.this);
                builder.setTitle("Pilihan");
                builder.setItems(dialogItem, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                        switch (i) {
                            case 0:
                                Intent a = new Intent(getApplicationContext(), LihatMahasiswa.class);
                                a.putExtra("nama", selection);
                                startActivity(a);
                                break;
                            case 1:
                                Intent in = new Intent(getApplicationContext(), EditMahasiswa.class);
                                in.putExtra("nama", selection);
                                startActivity(in);
                                break;
                            case 2:
                                SQLiteDatabase db = dbcenter.getWritableDatabase();
                                db.execSQL("DELETE FROM mahasiswa WHERE nama = '" + selection + "'");
                                RefreshList();
                                break;
                        }

                    }
                });
                builder.create().show();
            }
        });
        ((ArrayAdapter) listView.getAdapter()).notifyDataSetChanged();
    }
}


