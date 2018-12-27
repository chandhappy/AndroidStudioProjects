package com.example.e_learning;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by INCBASHA on 12/27/2016.
 */

public class empty extends Fragment implements View.OnClickListener {
    public empty() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.empty, container, false);
       /* ImageButton btnNew = (ImageButton) rootView.findViewById(R.id.page2home);
        btnNew.setOnClickListener(this);*/
        return rootView;
    }

    @Override
    public void onClick(View v) {
        /*Intent n = new Intent(getActivity(), Homepage.class);
        startActivity(n);*/
    }
}
