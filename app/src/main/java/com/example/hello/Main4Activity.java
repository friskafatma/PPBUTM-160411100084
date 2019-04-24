package com.example.hello;

import android.content.Intent;
import android.graphics.BitmapFactory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

import java.util.ArrayList;

public class Main4Activity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private KopiAdapter kopiAdapter;
    public static ArrayList<Kopi> kopiData;
    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);

        toolbar = findViewById(R.id.toolbar_layout);
        setSupportActionBar(toolbar);

        addKopi();

        recyclerView = findViewById(R.id.recyclerview);

        kopiAdapter = new KopiAdapter(kopiData);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(Main4Activity.this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(kopiAdapter);
    }

    public void addKopi(){
        kopiData = new ArrayList<>();
        kopiData.add(new Kopi(1, 10000, 0, BitmapFactory.decodeResource(getResources(), R.drawable.kopi), "Arabica", "Kopi ini berasal dari Etiopia dan sekarang telah dibudidayakan di berbagai belahan dunia, mulai dari Amerika Latin, Afrika Tengah, Afrika Timur, India, dan Indonesia. Secara umum, kopi ini tumbuh di negara-negara beriklim tropis atau subtropis. Kopi arabika tumbuh pada ketinggian 600-2000 m di atas permukaan laut. Biji kopi Arabika adalah yang paling langka dan bernilai dalam berbagai kopi, memiliki kadar cafeine yang 50% lebih rendah dari Kopi Robusta dan memiliki rasa asam khas."));
        kopiData.add(new Kopi(2, 20000, 0, BitmapFactory.decodeResource(getResources(), R.drawable.kopi), "Americano", "Americano adalah minuman kopi espresso dengan tambahan air panas. Namanya diambil dari cara orang Amerika meminum espresso. Americano serupa dengan kopi hitam (black coffee) atau tubruk. Kopi americano dibuat dari satu atau dua shot espresso, kemudian ditambahkan air panas di atasnya."));
        kopiData.add(new Kopi(3, 15000, 0, BitmapFactory.decodeResource(getResources(), R.drawable.kopi), "Cappucino", "Cappuccino adalah minuman khas Italia yang dibuat dari espresso dan susu, namun referensi lain juga ada yang menyebutkan bahwa Cappuccino berawal dari biji biji kopi tentara Turki yang tertinggal setelah peperangan yang di pimpin oleh Kara Mustapha Pasha di Wina, Austria melawan tentara gabungan Polandia-Germania. Cappuccino biasanya didefinisikan sebagai 1/3 espresso, 1/3 susu yang dipanaskan dan 1/3 susu yang dikocok hingga berbusa. "));
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.about) {
            startActivity(new Intent(this, AboutActivity.class));
        } else if (item.getItemId() == R.id.logout) {
            Intent intent = new Intent(this, Login4Activity.class);
            startActivity(intent);
            finish();
            return true;
        }else if(item.getItemId() == R.id.cart){
            boolean check = false;
            for (int i=0; i < kopiData.size(); i++){
                if (kopiData.get(i).getTotal() > 0){
                    check = true;
                    break;
                }
            }
            if (check == false){
                Toast.makeText(this, "Anda tidak mempunyai pesanan", Toast.LENGTH_SHORT).show();
            }
            else {
                Intent intent1 = new Intent(this, BayarActivity.class);
                startActivity(intent1);
            }
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
