package com.example.barcodescanner;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

/**
 * Created by INCBASHA on 2/9/2017.
 */

public class CodeSelect  extends AppCompatActivity implements View.OnClickListener{

    Button barcode, qrcode;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.codeselect);

        barcode = (Button) findViewById(R.id.Barcode);
        barcode.setOnClickListener(this);

        qrcode = (Button) findViewById(R.id.QRcode);
        qrcode.setOnClickListener(this);

    }


    @Override
    public void onClick(View v) {
        if(v.getId()==R.id.Barcode){
            setContentView(R.layout.activity_main);

        }if(v.getId()==R.id.QRcode){
            setContentView(R.layout.activity_main2);
        }
    }
}
