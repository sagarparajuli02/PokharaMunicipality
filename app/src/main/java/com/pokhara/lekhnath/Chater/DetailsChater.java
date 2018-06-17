package com.pokhara.lekhnath.Chater;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.TextView;

import com.pokhara.lekhnath.*;

public class DetailsChater extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details_chater);

        setTitle(R.string.citizenchater);
        if(getSupportActionBar()!=null){
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);;
            getSupportActionBar().setDisplayShowHomeEnabled(true);
        }
        Intent intent = getIntent();
       ExampleItem exampleItem = intent.getParcelableExtra("Example Item");

        String line1 = exampleItem.getText1();
        String line2 = exampleItem.getText2();
        String line3 = exampleItem.getmText3();
        String line4 = exampleItem.getmText4();
        String line5 = exampleItem.getmText5();


        TextView textView1 = findViewById(R.id.text1_activity2);
        textView1.setText(line1);

        TextView textView2 = findViewById(R.id.text2_activity2);
        textView2.setText(line2);

        TextView textView3 = findViewById(R.id.text3_activity2);
        textView3.setText(line3);

        TextView textView4 = findViewById(R.id.text4_activity2);
        textView4.setText(line4);

        TextView textVew5 = findViewById(R.id.text5_activity2);
        textVew5.setText(line5);

    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId()==android.R.id.home);
        finish();
        return super.onOptionsItemSelected(item);
    }
}
