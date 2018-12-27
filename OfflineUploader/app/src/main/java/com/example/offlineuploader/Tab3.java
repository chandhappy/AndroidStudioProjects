package com.example.offlineuploader;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;

/**
 * Created by INCBASHA on 11/2/2016.
 */

public class Tab3 extends Fragment implements View.OnClickListener {

    private  View vi;
    static String hello;
    private ArrayAdapter<String> adaptertext;
    private ArrayList<String> arraylist;


    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        vi = inflater.inflate(R.layout.tab3,container,false);
        arraylist = new ArrayList<String>();
        Button btn = (Button) vi.findViewById(R.id.button);
        btn.setOnClickListener(this);
        return vi;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.button:
                EditText gettext = (EditText) vi.findViewById(R.id.CommentArea);
                ListView settext = (ListView) vi.findViewById(R.id.CommentView);
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
