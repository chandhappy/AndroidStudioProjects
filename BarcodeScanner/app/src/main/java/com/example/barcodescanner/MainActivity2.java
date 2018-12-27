package com.example.barcodescanner;

import android.os.Bundle;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.util.SparseArray;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.gms.vision.CameraSource;
import com.google.android.gms.vision.Detector;
import com.google.android.gms.vision.barcode.Barcode;
import com.google.android.gms.vision.barcode.BarcodeDetector;

import java.io.File;
import java.io.IOException;

public class MainActivity2 extends AppCompatActivity implements View.OnClickListener {

    TextView barcodeInfo1;
    SurfaceView cameraView1;
    CameraSource cameraSource1;
    Button processbtn1;
    SparseArray<Barcode> barcodes1 ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        cameraView1 = (SurfaceView) findViewById(R.id.camera_view1);
        barcodeInfo1 = (TextView) findViewById(R.id.txtContent1);
        processbtn1 = (Button) findViewById(R.id.button1);
        processbtn1.setOnClickListener(this);
        processbtn1.setEnabled(false);
        BarcodeDetector barcodeDetector =
                new BarcodeDetector.Builder(this)
                        .setBarcodeFormats(Barcode.QR_CODE)
                        .build();

        cameraSource1 = new CameraSource
                .Builder(this, barcodeDetector)
                .setRequestedPreviewSize(640, 480)
                .build();

        cameraView1.getHolder().addCallback(new SurfaceHolder.Callback() {
            @Override
            public void surfaceCreated(SurfaceHolder holder) {

                try {
                    cameraSource1.start(cameraView1.getHolder());

                } catch (IOException ie) {
                    Log.e("CAMERA SOURCE", ie.getMessage());
                }
            }

            @Override
            public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {
            }

            @Override
            public void surfaceDestroyed(SurfaceHolder holder) {
                cameraSource1.stop();
            }
        });


        barcodeDetector.setProcessor(new Detector.Processor<Barcode>() {
            @Override
            public void release() {
            }


            @Override
            public void receiveDetections(Detector.Detections<Barcode> detections) {
                barcodes1 = detections.getDetectedItems();

                if (barcodes1.size() != 0) {
                    processbtn1.setEnabled(true);
                    barcodeInfo1.post(new Runnable() {    // Use the post method of the TextView
                        public void run() {
                            processbtn1.setEnabled(true);
                            barcodeInfo1.setText(    // Update the TextView
                                    barcodes1.valueAt(0).displayValue
                            );


                        }
                    });
                }
            }
        });
    }

    @Override
    public void onClick(View v) {
        String path = Environment.getDataDirectory().getAbsolutePath().toString() + "/storage/emulated/0/BarcodeScanner/" + barcodes1.valueAt(0).displayValue + "/";
        File mFolder = new File(path);
        if (!mFolder.exists()) {
            mFolder.mkdir();
        }
        else{
            File Directory = new File("/sdcard/BarcodeScanner/" + barcodes1.valueAt(0).displayValue + "/");
        Directory.mkdirs();
        }
        processbtn1.setEnabled(false);
    }
}