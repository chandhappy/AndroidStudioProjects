package com.example.myfirstapp;


import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;


/**
 * Created by INCBASHA on 11/2/2016.
 */

public class Tab1 extends Fragment {
    GridView gridView;
    String[] web = {
            "Google",
            "Github",
            "Instagram",
            "Facebook",
            "Flickr",
            "Pinterest",
            "Quora",
            "Twitter",
            "Vimeo",
            "WordPress",
            "Youtube",
            "Stumbleupon",
            "SoundCloud",
            "Reddit",
            "Blogger"

    };
    private int[] Imageid = {
            R.mipmap.icon1,
            R.mipmap.icon2,
            R.mipmap.icon3,
            R.mipmap.icon4,
            R.mipmap.icon5,
            R.mipmap.icon6,
            R.mipmap.icon7,
            R.mipmap.icon8,
            R.mipmap.icon9,
            R.mipmap.icon10,
            R.mipmap.icon11,
            R.mipmap.icon12,
            R.mipmap.icon13,
            R.mipmap.icon14,
            R.mipmap.icon15

    };

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.tab1, container, false);
        // Here we inflate the layout we created above
        GridView gridView = (GridView) rootView.findViewById(R.id.grid);
        gridView.setAdapter(new grid(web, Imageid, getActivity()));
        return rootView;
    }

}




