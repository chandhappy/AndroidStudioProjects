package com.example.offlineuploader;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


/**
 * Created by INCBASHA on 11/2/2016.
 */

public class Tab1 extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.tab1, container, false);

        /*List age = new ArrayList<>();
        for (int i = 1; i < 101; i++) {
            age.add(i);
        }
        ArrayAdapter<Integer> sa = new ArrayAdapter<Integer>(this.getActivity(), android.R.layout.simple_spinner_item, age);
        sa.setDropDownViewResource(
                android.R.layout.simple_spinner_dropdown_item);
        Spinner s = (Spinner) view.findViewById(R.id.spinnerAge);

        s.setAdapter(sa);*/
        return view;

    }
}




