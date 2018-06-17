package com.pokhara.lekhnath;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

public class Ward29 extends AppCompatActivity {

    Context context;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ward29);
        ImageView first = findViewById(R.id.first);
        ImageView second = findViewById(R.id.second);
        ImageView third = findViewById(R.id.third);
        ImageView fourth = findViewById(R.id.fourth);
        ImageView fifth = findViewById(R.id.fifth);
        Picasso.with(context).
                load("http://pokharalekhnathmun.gov.np/sites/pokharalekhnathmun.gov.np/files/chet%20bahadur%20gurung%20.jpg").
                placeholder(R.drawable.manager).
                into(first);
        Picasso.with(context).
                load("http://pokharalekhnathmun.gov.np/sites/pokharalekhnathmun.gov.np/files/Thal%20Bahadur%20Pandey%20Thapa.jpg").
                placeholder(R.drawable.manager).
                into(second);
        Picasso.with(context).
                load("http://pokharalekhnathmun.gov.np/sites/pokharalekhnathmun.gov.np/files/Hem%20Bahadur%20Baniya.jpg").
                placeholder(R.drawable.manager).
                into(third);
        Picasso.with(context).
                load("http://pokharalekhnathmun.gov.np/sites/pokharalekhnathmun.gov.np/files/Nirmala%20Poudel.jpg").
                placeholder(R.drawable.manager).
                into(fourth);
        Picasso.with(context).
                load("http://pokharalekhnathmun.gov.np/sites/pokharalekhnathmun.gov.np/files/Man%20Kumari%20Sunar.jpg").
                placeholder(R.drawable.manager).
                into(fifth);
    }
}
