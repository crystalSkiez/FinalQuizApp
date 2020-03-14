package com.evaniskosophia.finalquizapp;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.widget.TextView;
import java.util.Arrays;

import androidx.appcompat.app.AppCompatActivity;

import java.lang.reflect.Array;
import java.util.HashSet;
import java.util.Set;

public class Leaderboard extends AppCompatActivity {
    SharedPreferences pref;
    TextView username, score, rank, correctquestions;
    int rank1, totalranks;
    SharedPreferences.Editor edit;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        pref = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
        edit = pref.edit();
        edit.apply();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.leaderboard_layout);

        username = findViewById(R.id.username);
        correctquestions = findViewById(R.id.questionscorrect);
        score = findViewById(R.id.score);
        rank = findViewById(R.id.rank);

        username.setText("" + pref.getString("curr_username", ""));
        score.setText("Score: " + pref.getInt("curr_score", 0));
        correctquestions.setText("# Correct: " + pref.getInt("questions_correct", 0));
        getRank();
        rank.setText("Rank: " + rank1 + "/" + totalranks);
    }

    public void getRank(){
        int curr_s = pref.getInt("curr_score", 0);
        Set<String> set = pref.getStringSet("scores", new HashSet<String>());
        set.add("" + curr_s);
        edit.putStringSet("scores", set);
        edit.apply();
        int[] scorelist = new int[set.size()];
        int index = 0;
        for (String s:set){
            scorelist[index] = Integer.parseInt(s);
            index++;
        }
        Arrays.sort(scorelist);
        totalranks = scorelist.length;
        int myrank = 1;
        for (int i=0; i<scorelist.length; i++){
            if (curr_s < scorelist[i])
                myrank++;
        }
        rank1 = myrank;
    }
}
