package com.example.hello;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class KopiAdapter extends RecyclerView.Adapter<KopiAdapter.KopiViewHolder>{
    private ArrayList<Kopi> kopiData;
    private Context context;

    public KopiAdapter(ArrayList<Kopi> kopiData){

        this.kopiData = kopiData;
    }

    @Override
    public KopiAdapter.KopiViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        LayoutInflater layoutInflater = LayoutInflater.from(viewGroup.getContext());
        View view = layoutInflater.inflate(R.layout.cardmenu_layout, viewGroup, false);
        context = viewGroup.getContext();
        return new KopiViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final KopiViewHolder kopiViewHolder, final int i) {
        kopiViewHolder.image.setImageBitmap(kopiData.get(i).getImage());
        kopiViewHolder.name.setText(kopiData.get(i).getNamakopi());
        kopiViewHolder.price.setText(String.valueOf(kopiData.get(i).getHarga()));

        kopiViewHolder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, PesanKopi.class);
                intent.putExtra("ID", i);
                context.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return (kopiData != null) ? kopiData.size() : 0;
    }

    public class KopiViewHolder extends RecyclerView.ViewHolder{

        ImageView image;
        TextView name, price;
        CardView cardView;

        public KopiViewHolder(View itemView) {
            super(itemView);
            image = itemView.findViewById(R.id.logo);
            name = itemView.findViewById(R.id.txt_name);
            price = itemView.findViewById(R.id.txt_price);
            cardView = itemView.findViewById(R.id.cardview);
        }
    }
}
