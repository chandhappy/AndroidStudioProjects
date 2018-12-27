package com.example.barcodescanner;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by INCBASHA on 2/2/2017.
 */

public class CodeSelection extends AppCompatActivity implements View.OnClickListener {
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.codeselection);

        Button brcbtn = (Button) findViewById(R.id.barcodebtn);
        brcbtn.setOnClickListener(this);

        Button qrcbtn = (Button) findViewById(R.id.qrcodebtn);
        qrcbtn.setOnClickListener(this);

        Button otrbtn = (Button) findViewById(R.id.otrcodebtn);
        otrbtn.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
       Intent intent = new Intent("com.google.zxing.client.android.SCAN");
        switch(v.getId()){
            case R.id.qrcodebtn:
                intent.putExtra("SCAN_MODE", "QR_CODE_MODE");
                /*IntentIntegrator scanIntegrator = new IntentIntegrator(this);
                scanIntegrator.initiateScan();*/
                break;
            case R.id.otrcodebtn:
                intent.putExtra("SCAN_MODE", "PRODUCT_MODE");
                break;
            case R.id.barcodebtn:
                intent.putExtra("SCAN_FORMATS", "CODE_39,CODE_93,CODE_128,DATA_MATRIX,ITF,CODABAR");
                break;
        }
        startActivityForResult(intent, 0);
    }
    public void onActivityResult(int requestCode, int resultCode, Intent intent) {
        //IntentResult scanningResult = IntentIntegrator.parseActivityResult(requestCode, resultCode, intent);
        if (requestCode == 0) {
            TextView tvStatus=(TextView)findViewById(R.id.tvStatus);
            TextView tvResult=(TextView)findViewById(R.id.tvResult);
            if (resultCode == RESULT_OK) {
                tvStatus.setText(intent.getStringExtra("SCAN_RESULT_FORMAT"));
                tvResult.setText(intent.getStringExtra("SCAN_RESULT"));
            } else if (resultCode == RESULT_CANCELED) {
                tvStatus.setText("Press a button to start a scan.");
                tvResult.setText("Scan cancelled.");
            }
        }
        /*if (scanningResult != null) {
            TextView tvStatus=(TextView)findViewById(R.id.tvStatus);
            TextView tvResult=(TextView)findViewById(R.id.tvResult);
            String scanContent = scanningResult.getContents();
            String scanFormat = scanningResult.getFormatName();
            tvStatus.setText("FORMAT: " + scanFormat);
            tvResult.setText("CONTENT: " + scanContent);
        }
        else{
            Toast toast = Toast.makeText(getApplicationContext(),
                    "No scan data received!", Toast.LENGTH_SHORT);
            toast.show();
        }*/
    }
}