package com.example.hello;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class Main3Activity extends AppCompatActivity {
    TextView custom, menu, sajian, npsn, totalv, tottampil, bayarv, kembaliv, kembalitampil;
    EditText nama, narab, namric, ncap, bayarin;
    CheckBox arab, amric, cap;
    RadioGroup bhs, gruparab, grupamr, grupcap;
    RadioButton eng, ina, arabh, arabd, amrich, amricd, caph, capd;
    ImageView logo;
    Button finish, reset, tlp, hitung;
    int a, chrg;
    Bundle bundle = new Bundle();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        custom = findViewById(R.id.customer);
        menu = findViewById(R.id.menukopi);
        sajian = findViewById(R.id.sajianteks);
        npsn = findViewById(R.id.npesan);
        totalv = findViewById(R.id.totalname);
        tottampil = findViewById(R.id.totalhold);
        bayarv = findViewById(R.id.bayarname);
        nama = findViewById(R.id.editcust);
        narab = findViewById(R.id.countarab);
        namric = findViewById(R.id.countamric);
        ncap = findViewById(R.id.countcap);
        bayarin = findViewById(R.id.bayarhold);
        arab = findViewById(R.id.kopiarab);
        amric = findViewById(R.id.kopiamric);
        cap = findViewById(R.id.kopicap);
        bhs = findViewById(R.id.rg_bhs);
        gruparab = findViewById(R.id.rg_arab);
        grupamr = findViewById(R.id.rg_amric);
        grupcap = findViewById(R.id.rg_cap);
        logo = findViewById(R.id.imgholder);
        eng = findViewById(R.id.btneng);
        ina = findViewById(R.id.btnina);
        arabh = findViewById(R.id.rb_warmarab);
        arabd = findViewById(R.id.rb_icearab);
        amrich = findViewById(R.id.rb_warmamric);
        amricd = findViewById(R.id.rb_iceamric);
        caph = findViewById(R.id.rb_warmcap);
        capd = findViewById(R.id.rb_icecap);
        finish = findViewById(R.id.btnbyr);
        tlp = findViewById(R.id.btnpgl);
        hitung = findViewById(R.id.btnhtg);
        reset = findViewById(R.id.btnreset);

        tlp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                call();
            }
        });

        hitung.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int k = count();
                tottampil.setText(String.valueOf(k));

            }
        });

        eng.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setIndo();
            }
        });

        ina.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setEng();
            }
        });

        finish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                akhir();
            }
        });

        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                rst();
            }
        });
    }

    private int getInteger(Object value) {
        int i;
        try {
            i = Integer.parseInt(value.toString());
        } catch (Exception e) {
            i = 0;
        }
        return i;
    }

    public int count() {
        int a = 0;
        Integer jml1 = getInteger(narab.getText().toString());
        Integer jml2 = getInteger(namric.getText().toString());
        Integer jml3 = getInteger(ncap.getText().toString());

        if (arab.isChecked()) {
            a += 10000 * jml1;
        }
        if (amric.isChecked()) {
            a += 15000 * jml2;
        }
        if (cap.isChecked()) {
            a += 20000 * jml3;
        }

        return a;
    }

    public void akhir() {
        int n = count();
        String namaa = nama.getText().toString();
        String total = tottampil.getText().toString();
        Integer bayar = getInteger(bayarin.getText().toString());

        if (bayar == 0) {
            bayarin.setError("Anda Belum Membayar");
        }
        if (namaa.equals("")) {
            nama.setError("Nama Harus Diisi");
        }
        if (bayar != 0 && !namaa.equals("")) {
            if (bayar >= n) {
                //Toast.makeText(this,"Uang yang anda bayarkan kurang", Toast.LENGTH_SHORT).show();
                chrg = bayar - n;
                bundle.putString("nama", namaa);
                bundle.putString("total", total);
                bundle.putString("bayar", String.valueOf(bayar));
                bundle.putString("kembali", String.valueOf(chrg));
                Intent intent = new Intent(this, Konfirmasi.class);
                intent.putExtras(bundle);
                startActivity(intent);
            } else {
                bayarin.setError("Uang Yang Anda Bayarkan Kurang");
            }
        }
    }

    public void rst() {
        nama.setText("");
        bayarin.setText("");
        narab.setText("");
        namric.setText("");
        ncap.setText("");
        arabd.setChecked(false);
        amricd.setChecked(false);
        capd.setChecked(false);
        arabh.setChecked(false);
        amrich.setChecked(false);
        caph.setChecked(false);
        tottampil.setText("");
        kembalitampil.setText("");
    }

    public void setIndo() {
        custom.setText(getResources().getString(R.string.cust1));
        menu.setText(getResources().getString(R.string.menu1));
        sajian.setText(getResources().getString(R.string.jenis1));
        arabh.setText(getResources().getString(R.string.h1));
        arabd.setText(getResources().getString(R.string.d1));
        amrich.setText(getResources().getString(R.string.h1));
        amricd.setText(getResources().getString(R.string.d1));
        caph.setText(getResources().getString(R.string.h1));
        capd.setText(getResources().getString(R.string.d1));
        npsn.setText(getResources().getString(R.string.pesan1));
        totalv.setText(getResources().getString(R.string.total));
        bayarv.setText(getResources().getString(R.string.byr1));
        bayarin.setHint(getResources().getString(R.string.byrh1));
        kembaliv.setText(getResources().getString(R.string.kmbl1));
        finish.setText(getResources().getString(R.string.fns1));
        reset.setText(getResources().getString(R.string.rst1));
        hitung.setText(getResources().getString(R.string.htg1));
        tlp.setText(getResources().getString(R.string.tlp1));
    }

    public void setEng() {
        custom.setText(getResources().getString(R.string.cust2));
        menu.setText(getResources().getString(R.string.menu2));
        sajian.setText(getResources().getString(R.string.jenis2));
        arabh.setText(getResources().getString(R.string.h2));
        arabd.setText(getResources().getString(R.string.d2));
        amrich.setText(getResources().getString(R.string.h2));
        amricd.setText(getResources().getString(R.string.d2));
        caph.setText(getResources().getString(R.string.h2));
        capd.setText(getResources().getString(R.string.d2));
        npsn.setText(getResources().getString(R.string.pesan2));
        totalv.setText(getResources().getString(R.string.total));
        bayarv.setText(getResources().getString(R.string.byr2));
        bayarin.setHint(getResources().getString(R.string.byrh2));
        kembaliv.setText(getResources().getString(R.string.kmbl2));
        finish.setText(getResources().getString(R.string.htg2));
        reset.setText(getResources().getString(R.string.rst2));
        hitung.setText(getResources().getString(R.string.htg2));
        tlp.setText(getResources().getString(R.string.tlp2));
    }

    public void call(){
        String nomor = "+6581259212725";
        Intent intent = new Intent(Intent.ACTION_DIAL);
        intent.setData(Uri.fromParts("tel",nomor,null));
        startActivity(intent);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.about) {
            startActivity(new Intent(this, AboutActivity.class));
        } else if (item.getItemId() == R.id.logout) {
            finish();
        }
        return super.onOptionsItemSelected(item);
    }
}
