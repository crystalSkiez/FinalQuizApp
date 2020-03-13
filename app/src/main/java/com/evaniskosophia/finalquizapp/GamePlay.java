package com.evaniskosophia.finalquizapp;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class GamePlay extends AppCompatActivity {
    SharedPreferences pref;
    SharedPreferences.Editor edit;
    Questions q;
    TextView question;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.game_layout);

        pref = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
        edit = pref.edit();
        edit.apply();

        q = new Questions();
        question = findViewById(R.id.textquestion);
        showQuestion();

    }

    public void showQuestion(){
        System.out.println(q.getQuestion());
        question.setText("" + q.getQuestion());
        //start the time
    }

    public void onTrueClick(View v){
        if (q.getAnswer()){
            q.newQandA();
            showQuestion();
            //update score based on time remaining
        }
        else {
            Intent intent = new Intent(getApplicationContext(), Leaderboard.class);
            startActivity(intent);
        }
    }

    public void onFalseClick(View v){
        if (!q.getAnswer()){
            q.newQandA();
            showQuestion();
            //update score based on time remaining
        }
        else {
            Intent intent = new Intent(getApplicationContext(), Leaderboard.class);
            startActivity(intent);
        }
    }

}