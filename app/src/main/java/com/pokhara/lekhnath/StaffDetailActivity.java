package com.pokhara.lekhnath;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

public class StaffDetailActivity extends AppCompatActivity {

    Context context;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_staff_detail);
setTitle(R.string.staff);
        if(getSupportActionBar()!=null){
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);;
            getSupportActionBar().setDisplayShowHomeEnabled(true);
        }

        Intent i = getIntent();

        TextView name= (TextView)findViewById(R.id.employeeName);
        TextView post= (TextView)findViewById(R.id.employeePost);
        TextView email= (TextView)findViewById(R.id.employeeemail);
        TextView number= (TextView)findViewById(R.id.employeeNumber);
        ImageView image= (ImageView)findViewById(R.id.employeeImage);

        String Name=i.getExtras().getString("name");
        String Post=i.getExtras().getString("post");
        String Image=i.getExtras().getString("image");
        final String Number= i.getExtras().getString("number");
        final String Email= i.getExtras().getString("email");

        name.setText(Name);
        post.setText(Post);
        email.setText(Email);
        number.setText(Number);
        Picasso.with(this)
                .load(Image)
                .placeholder(R.drawable.manager)
                .into(image);


        number.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
             //   Toast.makeText(StaffDetailActivity.this, Number, Toast.LENGTH_SHORT).show();
                Intent callIntent = new Intent(Intent.ACTION_DIAL);
                callIntent.setData(Uri.parse("tel:" + Number));

                startActivity(callIntent);
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

