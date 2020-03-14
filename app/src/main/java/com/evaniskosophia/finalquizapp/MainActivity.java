package com.evaniskosophia.finalquizapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.location.SettingInjectorService;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.EditText;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class MainActivity extends AppCompatActivity {
    SharedPreferences pref;
    EditText edit2;
    SharedPreferences.Editor edit;
    //add a set of strings in shared preferences for the other scores--dont use their usernames for now i guess?
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        pref = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());

        edit2 = findViewById(R.id.editText);

        edit = pref.edit();
        edit.putString("curr_username", "blank");
        edit.putInt("curr_score", 0);
        edit.putInt("questions_correct", 0);
        edit.apply();


    }

    public void startGame(View view) {
        String username = ""+edit2.getText();
        edit.putString("curr_username", username);
        edit.apply();
        //edit.putString("username", edit2.getText());
        Intent intent = new Intent(getApplicationContext(), GamePlay.class);
        startActivity(intent);
    }

}
