package com.pokhara.lekhnath;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

public class Ward31 extends AppCompatActivity {

    Context context;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ward31);
        ImageView first = findViewById(R.id.first);
        ImageView second = findViewById(R.id.second);
        ImageView third = findViewById(R.id.third);
        ImageView fourth = findViewById(R.id.fourth);
        ImageView fifth = findViewById(R.id.fifth);
        Picasso.with(context).
                load("http://pokharalekhnathmun.gov.np/sites/pokharalekhnathmun.gov.np/files/Kamal%20Bahadur%20Thapa.jpg").
                placeholder(R.drawable.manager).
                into(first);
        Picasso.with(context).
                load("http://pokharalekhnathmun.gov.np").
                placeholder(R.drawable.manager).
                into(second);
        Picasso.with(context).
                load("http://pokharalekhnathmun.gov.np/sites/pokharalekhnathmun.gov.np/files/Bishnu%20Bahadur%20bhujel.jpg").
                placeholder(R.drawable.manager).
                into(third);
        Picasso.with(context).
                load("http://pokharalekhnathmun.gov.np/sites/pokharalekhnathmun.gov.np/files/bishnu%20sunar.jpg").
                placeholder(R.drawable.manager).
                into(fourth);
        Picasso.with(context).
                load("http://pokharalekhnathmun.gov.np/sites/pokharalekhnathmun.gov.np/files/Purna%20khar%20pandey.jpg").
                placeholder(R.drawable.manager).
                into(fifth);
    }
}
