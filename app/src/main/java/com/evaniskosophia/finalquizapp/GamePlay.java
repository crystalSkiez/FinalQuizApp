package com.evaniskosophia.finalquizapp;

import android.app.Fragment;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.preference.PreferenceManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.app.FragmentManager;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;

import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.TimeUnit;

public class GamePlay extends AppCompatActivity {
    SharedPreferences pref;
    SharedPreferences.Editor edit;
    Questions q;
    TextView question, time, score, correct;
    Timer timer = new Timer();
    int duration = 0;
    CountDownTimer cTimer = null;
    CountDownTimer cTimer2 = null;
    DialogFragment f;


    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.game_layout);

        pref = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
        edit = pref.edit();
        edit.apply();

        q = new Questions();
        question = findViewById(R.id.textquestion);
        time = findViewById(R.id.texttimer);
        score = findViewById(R.id.textscore);
        correct = findViewById(R.id.textcorrect);

        showDialog();
        startTimer2();
        System.out.println("reached");
        cTimer2.start();
        cancelTimer();
        //showQuestion();
    }

    void showDialog(){
        Fragment prev = getFragmentManager().findFragmentByTag("dialog");
        f = new MyDialogFragment();
        f.show(getSupportFragmentManager(), "dialog");
        //dialogFragment.dismiss();
    }

    void startTimer() {
        cTimer = new CountDownTimer(3500, 1000) {
            public void onTick(long millisUntilFinished) {
                time.setText("" + millisUntilFinished / 1000);
            }

            public void onFinish() {
                Intent intent = new Intent(getApplicationContext(), Leaderboard.class);
                startActivity(intent);

            }
        };
    }

    void startTimer2() {
        cTimer2 = new CountDownTimer(6000, 1000) {
            public void onTick(long millisUntilFinished) {
                System.out.println(millisUntilFinished);
            }

            public void onFinish() {
                System.out.println(("im here"));
                f.dismiss();
                showQuestion();
            }
        };
    }

    void cancelTimer2() {
        if(cTimer2!=null)
            cTimer2.cancel();
        showQuestion();
    }

    void cancelTimer() {
        if(cTimer!=null)
            cTimer.cancel();
    }

    public void showQuestion() {
        System.out.println(q.getQuestion());
        question.setText("" + q.getQuestion());
        //start the time
        startTimer();
        cTimer.start();
        score.setText(pref.getInt("curr_score", 0) + "");
        score.setText(pref.getInt("questions_correct", 0) + "");
    }

    public void onTrueClick(View v){
        if (q.getAnswer()){
            q.newQandA();
            cancelTimer();
            showQuestion();
            //update score based on time remaining
            int timebonus = Integer.parseInt(""+time.getText()) * 100;
            edit.putInt("curr_score", pref.getInt("curr_score", 0) + timebonus + 500);
            edit.putInt("questions_correct", pref.getInt("questions_correct", 0) + 1);
            edit.apply();
            score.setText(pref.getInt("curr_score", 0) + "");;
            correct.setText(pref.getInt("questions_correct", 0) + "");
        }
        else {
            cancelTimer();
            Intent intent = new Intent(getApplicationContext(), Leaderboard.class);
            startActivity(intent);
        }
    }

    public void onFalseClick(View v){
        if (!q.getAnswer()){
            q.newQandA();
            cancelTimer();
            showQuestion();
            //update score based on time remaining
            int timebonus = Integer.parseInt(""+time.getText()) * 100;
            edit.putInt("curr_score", pref.getInt("curr_score", 0) + timebonus + 500);
            edit.putInt("questions_correct", pref.getInt("questions_correct", 0) + 1);
            edit.apply();
            score.setText(pref.getInt("curr_score", 0) + "");
            correct.setText(pref.getInt("questions_correct", 0) + "");
        }
        else {
            cancelTimer();
            Intent intent = new Intent(getApplicationContext(), Leaderboard.class);
            startActivity(intent);
        }
    }

}
