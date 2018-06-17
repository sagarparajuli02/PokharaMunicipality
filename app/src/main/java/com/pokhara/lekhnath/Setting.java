package com.pokhara.lekhnath;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Switch;

public class Setting extends AppCompatActivity {

    Switch switch1;
    private static  final String SHARED_PREBFS="sharedPrefs ";
    private static  final String SWITCH1="switch1 ";
    private boolean switchOnOff;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);
        switch1=findViewById(R.id.languageChange);
        saveData();
        loadData();
        updateViews();
    }

    private void saveData() {
        SharedPreferences sharedPreferences=getSharedPreferences(SHARED_PREBFS,MODE_PRIVATE);
        SharedPreferences.Editor editor= sharedPreferences.edit();
        editor.putBoolean(SWITCH1,switch1.isChecked());
        editor.apply();
    }
    private  void loadData(){
        SharedPreferences sharedPreferences= getSharedPreferences(SHARED_PREBFS,MODE_PRIVATE);
        switchOnOff=sharedPreferences.getBoolean(SWITCH1,false);


    }
    public  void updateViews(){
        switch1.setChecked(switchOnOff);
    }
}
