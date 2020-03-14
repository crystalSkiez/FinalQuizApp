package com.evaniskosophia.finalquizapp;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.fragment.app.DialogFragment;

public class MyDialogFragment extends DialogFragment {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.instuctions, container, false);
        View tv = v.findViewById(R.id.inst);
        ((TextView)tv).setText("INSTRUCTIONS \n Answer the true or false questions as quickly as you can. Points are added for speed and correctness. Fail to answer the questions in 3 seconds or answer wrongly and GAME OVER.");
        return v;
    }
}

