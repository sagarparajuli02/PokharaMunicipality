package com.pokhara.lekhnath;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

public class Ward7 extends AppCompatActivity {

    Context context;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ward7);
        ImageView first = findViewById(R.id.first);
        ImageView second = findViewById(R.id.second);
        ImageView third = findViewById(R.id.third);
        ImageView fourth = findViewById(R.id.fourth);
        ImageView fifth = findViewById(R.id.ffifth);


        Picasso.with(context).
                load("http://pokharalekhnathmun.gov.np/sites/pokharalekhnathmun.gov.np/files/ward7.PNG").
                placeholder(R.drawable.manager).
                into(first);
        Picasso.with(context).
                load("http://pokharalekhnathmun.gov.np/sites/pokharalekhnathmun.gov.np/files/mahila-sadasya-7.jpg").
                placeholder(R.drawable.manager).
                into(second);
        Picasso.with(context).
                load("http://pokharalekhnathmun.gov.np/sites/pokharalekhnathmun.gov.np/files/%E0%A4%A6%E0%A4%B2%E0%A4%BF%E0%A4%A4%20%E0%A4%AE%E0%A4%B9%E0%A4%BF%E0%A4%B2%E0%A4%BE%20-%E0%A5%AD.jpg").
                placeholder(R.drawable.manager).
                into(third);
        Picasso.with(context).
                load("http://pokharalekhnathmun.gov.np/sites/pokharalekhnathmun.gov.np/files/%E0%A4%96%E0%A5%81%E0%A4%B2%E0%A5%8D%E0%A4%B2%E0%A4%BE%20%E0%A4%B8%E0%A4%A6%E0%A4%B8%E0%A5%8D%E0%A4%AF%20-%E0%A5%AD.jpg").
                placeholder(R.drawable.manager).
                into(fourth);
        Picasso.with(context).
                load("http://pokharalekhnathmun.gov.np/sites/pokharalekhnathmun.gov.np/files/%E0%A4%96%E0%A5%81%E0%A4%B2%E0%A5%8D%E0%A4%B2%E0%A4%BE%20%E0%A4%B8%E0%A4%A6%E0%A4%B8%E0%A5%8D%E0%A4%AF%20-%E0%A5%AD-%E0%A5%A7.jpg").
                placeholder(R.drawable.manager).
                into(fifth);

    }
}