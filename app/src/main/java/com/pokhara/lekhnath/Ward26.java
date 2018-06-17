package com.pokhara.lekhnath;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

public class Ward26 extends AppCompatActivity {
    Context context;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ward26);

        ImageView first = findViewById(R.id.first);
        ImageView second = findViewById(R.id.second);
        ImageView third = findViewById(R.id.third);
        ImageView fourth = findViewById(R.id.fourth);

        Picasso.with(context).
                load("http://pokharalekhnathmun.gov.np").
                placeholder(R.drawable.manager).
                into(first);
        Picasso.with(context).
                load("http://pokharalekhnathmun.gov.np/sites/pokharalekhnathmun.gov.np/files/Khadka.jpg").
                placeholder(R.drawable.manager).
                into(second);
        Picasso.with(context).
                load("http://pokharalekhnathmun.gov.np/sites/pokharalekhnathmun.gov.np/files/Murali%20thapa.jpg").
                placeholder(R.drawable.manager).
                into(third);
        Picasso.with(context).
                load("http://pokharalekhnathmun.gov.np").
                placeholder(R.drawable.manager).
                into(fourth);
    }
}
