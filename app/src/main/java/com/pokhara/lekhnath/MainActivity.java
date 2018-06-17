package com.pokhara.lekhnath;

import android.app.AlertDialog;
import android.app.FragmentManager;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.DisplayMetrics;
import android.view.Menu;
import android.view.MenuItem;

import com.pokhara.lekhnath.Fragments.EmailFragment;
import com.pokhara.lekhnath.Fragments.IntroFragment;

import java.util.Locale;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    Locale myLocale;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        setTitle(R.string.app_name);




        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        android.support.v4.app.FragmentManager fm =getSupportFragmentManager();
        fm.beginTransaction().replace(R.id.frame,new HomeFragment()).commit();


    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds example_item to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        SharedPreferences setting = getSharedPreferences("setting",0);
        boolean isChecked=setting.getBoolean("checkbox",false);
        MenuItem item= menu.findItem(R.id.change_language);
        item.setChecked(isChecked);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
       // if (id == R.id.action_settings) {
        //    Intent intent = new Intent(MainActivity.this,Setting.class);
          //  startActivity(intent);
            //return true;
        //}
        if (id == R.id.change_language) {

            item.setChecked(!item.isChecked());
            SharedPreferences setting= getSharedPreferences("setting",0);
            SharedPreferences.Editor editor= setting.edit();
            editor.putBoolean("checkbox",item.isChecked());
            editor.commit();
            if (item.isChecked()){
                setLocale("ne");
            }
            else
            {
                setLocale("en");
            }
      // setLocale("ne");

            //  changeLang(MainActivity.this, "en");
                //finish();
                //startActivity(new Intent(MainActivity.this, MainActivity.class));
            //}
        }


        if (id == R.id.updateApp) {
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("market://details?id=com.pokhara.lekhnath"));
            startActivity(intent);
            return true;
        }

        if (id == R.id.visitWebsite) {
            Uri uri= Uri.parse("http://pokharalekhnathmun.gov.np/");

            Intent website = new Intent(Intent.ACTION_VIEW, uri);
            startActivity(website);
            return true;
        }
        if (id == R.id.aboutUs) {

            Intent about = new Intent(MainActivity.this,Technomania.class);
            startActivity(about);
            return true;
        }
        if (id == R.id.exitApp) {
            AlertDialog.Builder builder= new AlertDialog.Builder(this);
            builder.setMessage("Do you want to Exit??")
                    .setCancelable(false)
                    .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            MainActivity.this.finish();
                        }
                    })
                    .setNegativeButton("No", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            dialogInterface.cancel();
                        }
                    });
            AlertDialog alertDialog= builder.create();
            alertDialog.show();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    private void setLocale(String lang) {
        myLocale = new Locale(lang);
        Resources res = getResources();
        DisplayMetrics dm = res.getDisplayMetrics();
        Configuration conf = res.getConfiguration();
        conf.locale = myLocale;

        res.updateConfiguration(conf, dm);
        Intent refresh = new Intent(this, MainActivity.class);
        startActivity(refresh);
            finish();
    }

    private void changeLang(Context context, String lang) {
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(context);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putString("Language", lang);
        editor.apply();
    }


    android.app.Fragment fragment= null;

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        android.support.v4.app.FragmentManager fm = getSupportFragmentManager();
        getSupportFragmentManager().popBackStack(null, FragmentManager.POP_BACK_STACK_INCLUSIVE);

        int id = item.getItemId();

        if (id == R.id.nav_camera) {

            fm.beginTransaction().replace(R.id.frame,new HomeFragment()).commit();
            // Handle the camera action
        }
        else if (id==R.id.news){
           Intent news = new Intent(MainActivity.this,News.class);
           startActivity(news);
        }

        else if (id==R.id.introduction){
            fm.beginTransaction()
                    .add(new HomeFragment(),"HomeFragment")
                    .addToBackStack("HomeFragment")
                    .replace(R.id.frame,new IntroFragment()).commit();
        }
        else if (id==R.id.employee){
            Intent employee= new Intent(MainActivity.this,EmployeeWorker.class);
            startActivity(employee);
        }
        else if (id==R.id.email){
            fm.beginTransaction()
                    .add(new HomeFragment(),"HomeFragment")
                    .addToBackStack("HomeFragment").replace(R.id.frame,new EmailFragment()).commit();
        }
        else if (id==R.id.informtion){
            fm.beginTransaction()
                    .add(new HomeFragment(),"HomeFragment")
                    .addToBackStack("HomeFragment").replace(R.id.frame,new InformationWebview()).commit();
        }
        else if (id==R.id.pokharaLekhnath){
            fm.beginTransaction()
                    .add(new HomeFragment(),"HomeFragment")
                    .addToBackStack("HomeFragment").replace(R.id.frame,new PokharaLekhnath()).commit();
        }
        else if (id==R.id.importantNumber){
            fm.beginTransaction()
                    .add(new HomeFragment(),"HomeFragment")
                    .addToBackStack("HomeFragment").replace(R.id.frame,new PhoneNumber()).commit();
        }
        else if (id==R.id.representativenew){
            fm.beginTransaction()
                    .add(new HomeFragment(),"HomeFragment")
                    .addToBackStack("HomeFragment").replace(R.id.frame,new RepresentativeNew()).commit();
        }
        else if (id==R.id.map){
//            fm.beginTransaction()
//                    .add(new HomeFragment(),"HomeFragment")
//                    .addToBackStack("HomeFragment").replace(R.id.frame,new MapFragment()).commit();
            Intent map= new Intent(MainActivity.this,MapActivity.class);
            startActivity(map);
        }
        //tender is for waste management :)
        else if (id==R.id.tender){
           Intent tender= new Intent(MainActivity.this,TenderActivity.class);
           startActivity(tender);
        }
        else if (id==R.id.staff){
            Intent staff= new Intent(MainActivity.this,StaffWorker.class);
            startActivity(staff);
        }


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}