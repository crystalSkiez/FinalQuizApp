package com.evaniskosophia.finalquizapp;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;

import androidx.appcompat.app.AppCompatActivity;

public class GamePlay extends AppCompatActivity {
    SharedPreferences pref;
    SharedPreferences.Editor edit;
    Questions q;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.game_layout);

        pref = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
        edit = pref.edit();
        edit.apply();

        q = new Questions();

    }

    public void addQuestions(){


    }
}