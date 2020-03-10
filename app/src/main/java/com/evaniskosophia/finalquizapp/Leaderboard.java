package com.evaniskosophia.finalquizapp;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;

import androidx.appcompat.app.AppCompatActivity;

public class Leaderboard extends AppCompatActivity {
    SharedPreferences pref;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        pref = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
        SharedPreferences.Editor edit = pref.edit();
        edit.apply();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.leaderboard_layout);
    }
}
