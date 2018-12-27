package com.example.myfirstapp;

import android.content.Context;
import android.content.Intent;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

import static android.content.Intent.getIntent;
import static android.content.Intent.parseIntent;

/**
 * Created by INCBASHA on 11/2/2016.
 */

public class Tab2 extends Fragment implements View.OnClickListener {
    LayoutInflater inflater;
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        View rootView = inflater.inflate(R.layout.tab2, container, false);
        return rootView;
    }

    @Override
    public void onClick(View v) {
    }
}
