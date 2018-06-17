package com.pokhara.lekhnath.Chater;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;

import com.pokhara.lekhnath.R;

public class CitizenChater extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_citizen_chater);
        setTitle(R.string.citizenchater);
        if(getSupportActionBar()!=null){
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);;
            getSupportActionBar().setDisplayShowHomeEnabled(true);
        }
        LinearLayout sifaris = findViewById(R.id.sifarisLayout);
        LinearLayout byapar = findViewById(R.id.byaparLayout);
        LinearLayout  panjisakan= findViewById(R.id.panjikaranLayout);
        LinearLayout pradigit = findViewById(R.id.pramaditLayout);
        LinearLayout kaar = findViewById(R.id.kaarLayout);
        LinearLayout darta =  findViewById(R.id.dartaLayout);
        sifaris.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent sifaris= new Intent(CitizenChater.this,Sifaris.class);
                startActivity( sifaris);
            }
        });
        byapar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent byapar = new Intent(CitizenChater.this, ByaparActivity.class);
                startActivity(byapar);
            }
        });
        panjisakan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent sifaris= new Intent(CitizenChater.this,PanjikaranActivity.class);
                startActivity( sifaris);
            }
        });
        pradigit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent pradigit = new Intent(CitizenChater.this, PradigitActivity.class);
                startActivity(pradigit);
            }
        });
        kaar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent pradigit = new Intent(CitizenChater.this, KaarActivity.class);
                startActivity(pradigit);
            }
        });

        darta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent pradigit = new Intent(CitizenChater.this, DartaActivity.class);
                startActivity(pradigit);
            }
        });


    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId()==android.R.id.home);
        finish();
        return super.onOptionsItemSelected(item);
    }

}