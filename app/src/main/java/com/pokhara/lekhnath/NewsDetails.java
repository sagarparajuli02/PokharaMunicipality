package com.pokhara.lekhnath;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.webkit.URLUtil;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

public class NewsDetails extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news_details);

        if(getSupportActionBar()!=null){
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);;
            getSupportActionBar().setDisplayShowHomeEnabled(true);
        }

        Intent i = getIntent();

        TextView title= (TextView)findViewById(R.id.titleDetail);
        ImageView image= (ImageView)findViewById(R.id.imageDetail);
        TextView description= (TextView)findViewById(R.id.descriptionDetail);
        Button OpenLink= (Button)findViewById(R.id.link);


        String Title=i.getExtras().getString("title");
        String Description=i.getExtras().getString("description");
        String Image=i.getExtras().getString("image");
        final String Link= i.getExtras().getString("link");

        OpenLink.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (URLUtil.isValidUrl(Link)) {
                    Uri uri = Uri.parse(Link);
                    Intent intent= new Intent(Intent.ACTION_VIEW,uri);
                    startActivity(intent);


                }
                else
                {

                    Toast.makeText(NewsDetails.this, "No Files to Download", Toast.LENGTH_SHORT).show();
                }

            }
        });

        title.setText(Title);
        description.setText(Description);
        Picasso.with(this)
                .load(Image)
                .placeholder(R.drawable.ic_panjikaran)
                .into(image);
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId()==android.R.id.home);
        finish();
        return super.onOptionsItemSelected(item);
    }
}
