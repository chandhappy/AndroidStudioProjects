package com.example.e_learning;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;

/**
 * Created by INCBASHA on 11/28/2016.
 */

public class Topic extends Fragment implements View.OnClickListener {

    public Topic() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.topics, container, false);
       /* ImageButton btnNew = (ImageButton) rootView.findViewById(R.id.page1home);
        btnNew.setOnClickListener(this);*/


        String pdf = "http://www.cbu.edu.zm/downloads/pdf-sample.pdf";
        String doc="<iframe src='http://www.cbu.edu.zm/downloads/pdf-sample.pdf' width='100%' height='100%' style='border: none;'></iframe>";
       WebView webView = (WebView)rootView.findViewById(R.id.webView1);
        webView.getSettings().setJavaScriptEnabled(true);
        webView.getSettings().setAllowFileAccess(true);
        webView.loadData( doc , "text/html", "UTF-8");
        return rootView;
    }

    @Override
    public void onClick(View v) {
        /*Intent n = new Intent(getActivity(), Homepage.class);
        startActivity(n);*/
    }
}
