package com.example.e_learning;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;

/**
 * Created by INCBASHA on 11/28/2016.
 */

public class Discussion extends Fragment implements View.OnClickListener {

    public Discussion() {
    }

    private View rootView;
    static String hello;
    private ArrayAdapter<String> adaptertext;
    private ArrayList<String> arraylist;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.discussion, container, false);
        arraylist = new ArrayList<String>();
        Button btn = (Button) rootView.findViewById(R.id.button);
        btn.setOnClickListener(this);
        return rootView;
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.button:
                EditText gettext = (EditText) rootView.findViewById(R.id.CommentArea);
                ListView settext = (ListView) rootView.findViewById(R.id.CommentView);
                hello = gettext.getText().toString().trim();
                if (hello != null && !hello.equals("") && (hello.length() != 0) && !hello.equals("　")) {
                    arraylist.add(hello);
                }
                adaptertext = new ArrayAdapter<String>(getActivity(), R.layout.list_viewhelper, arraylist);
                settext.setAdapter(adaptertext);
                adaptertext.notifyDataSetChanged();
                gettext.setText(null);
                break;
            default:
                break;
        }

    }
}
