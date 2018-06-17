package com.pokhara.lekhnath;

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;


public class Downloads extends AppCompatActivity  implements View.OnClickListener {
    private static Button downloadPdf, downloadDoc, downloadZip, downloadVideo, downloadMp3, openDownloadedFolder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_downloads);
        if(getSupportActionBar()!=null){
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);;
            getSupportActionBar().setDisplayShowHomeEnabled(true);
        }
        initViews();
        setListeners();
    }


    private void initViews() {
        downloadPdf = (Button) findViewById(R.id.downloadPdf);
        downloadDoc = (Button) findViewById(R.id.downloadDoc);
        downloadZip = (Button) findViewById(R.id.downloadZip);
        downloadVideo = (Button) findViewById(R.id.downloadVideo);

    }
    private void setListeners() {
        downloadPdf.setOnClickListener(this);
        downloadDoc.setOnClickListener(this);
        downloadZip.setOnClickListener(this);
        downloadVideo.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        //Before starting any download check internet connection availability
        if (ContextCompat.checkSelfPermission(Downloads.this, Manifest.permission.WRITE_EXTERNAL_STORAGE)
                != PackageManager.PERMISSION_GRANTED) {
// Permission is not granted
            // Log.e(TAG , “WRITE EXTERNAL STORAGE PERMISSION NOT GRANTED”);
            ActivityCompat.requestPermissions(Downloads.this,
                    new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE},
                    1);
            return;

        }


        switch (view.getId()) {
            case R.id.downloadPdf:
                if (isConnectingToInternet())

                    new DownloadTask(Downloads.this, downloadPdf, Utils.badapatrawithrate);
                else
                    Toast.makeText(Downloads.this, "Oops!! There is no internet connection. Please enable internet connection and try again.", Toast.LENGTH_SHORT).show();
                break;
            case R.id.downloadDoc:
                if (isConnectingToInternet())
                    new DownloadTask(Downloads.this, downloadDoc, Utils.income);
                else
                    Toast.makeText(Downloads.this, "Oops!! There is no internet connection. Please enable internet connection and try again.", Toast.LENGTH_SHORT).show();
                break;
            case R.id.downloadZip:
                if (isConnectingToInternet())
                    new DownloadTask(Downloads.this, downloadZip, Utils.tax_rate);
                else
                    Toast.makeText(Downloads.this, "Oops!! There is no internet connection. Please enable internet connection and try again.", Toast.LENGTH_SHORT).show();
                break;
            case R.id.downloadVideo:
                if (isConnectingToInternet())
                    new DownloadTask(Downloads.this, downloadVideo, Utils.downloadVideoUrl);
                else
                    Toast.makeText(Downloads.this, "Oops!! There is no internet connection. Please enable internet connection and try again.", Toast.LENGTH_SHORT).show();
                break;


        }

    }


    //Check if internet is present or not
    private boolean isConnectingToInternet() {
        ConnectivityManager connectivityManager = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connectivityManager
                .getActiveNetworkInfo();
        if (networkInfo != null && networkInfo.isConnected())
            return true;
        else
            return false;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId()==android.R.id.home);
        finish();
        return super.onOptionsItemSelected(item);
    }



}