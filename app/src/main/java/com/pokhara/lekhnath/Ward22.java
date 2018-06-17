package com.pokhara.lekhnath;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

public class Ward22 extends AppCompatActivity {

    Context context;
    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ward22);
        ImageView first = findViewById(R.id.first);
        ImageView second = findViewById(R.id.second);
        ImageView third = findViewById(R.id.third);
        ImageView fourth = findViewById(R.id.fourth);
        ImageView  fifth= findViewById(R.id.fifth);

        Picasso.with(context).
                load("http://pokharalekhnathmun.gov.np/sites/pokharalekhnathmun.gov.np/files/mitra%20lal%20baral.jpg").
                placeholder(R.drawable.manager).
                into(first);
        Picasso.with(context).
                load("http://pokharalekhnathmun.gov.np").
                placeholder(R.drawable.manager).
                into(second);
        Picasso.with(context).
                load("http://pokharalekhnathmun.gov.np").
                placeholder(R.drawable.manager).
                into(third);
        Picasso.with(context).
                load("http://pokharalekhnathmun.gov.np/sites/pokharalekhnathmun.gov.np/files/chet%20bhakta%20sharma%20baral.jpg").
                placeholder(R.drawable.manager).
                into(fourth);
        Picasso.with(context).
                load("http://pokharalekhnathmun.gov.np/sites/pokharalekhnathmun.gov.np/files/Matrika%20prasad%20baral.jpg").
                placeholder(R.drawable.manager).
                into(fifth);
    }
}
