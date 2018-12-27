package com.example.e_learning;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.pdf.PdfRenderer;
import android.os.Bundle;
import android.os.ParcelFileDescriptor;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import java.io.File;

public class PdfHandler extends Activity {
    private int currentpage =0;
    private ImageView imageView;
    private Button next,previous;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pdfview);
        next = (Button)findViewById(R.id.next);
        previous = (Button)findViewById(R.id.previous);
        next.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                currentpage++;
                render();
            }
        });

        previous.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                currentpage--;
                render();
            }
        });
        render();
    }

    private  void render(){
        try{
            imageView = (ImageView) findViewById(R.id.pdfimage);
            int REQ_WIDTH= imageView.getWidth();
            int REQ_HEIGHT= imageView.getHeight();
            Bitmap bitmap = Bitmap.createBitmap(REQ_WIDTH,REQ_HEIGHT,Bitmap.Config.ARGB_4444);
            File file= new File("/storage/sdcard1/Ciaz_hybrid_brochure.pdf");
            PdfRenderer renderer = new PdfRenderer(ParcelFileDescriptor.open(file,ParcelFileDescriptor.MODE_READ_ONLY));
            if (currentpage<0){
                currentpage=0;
            }else if(currentpage>renderer.getPageCount()){
                currentpage= renderer.getPageCount()-1;
            }
            Matrix m = imageView.getImageMatrix();
            Rect rect= new Rect(0,0,REQ_WIDTH,REQ_HEIGHT);
            renderer.openPage(currentpage).render(bitmap,rect,m,PdfRenderer.Page.RENDER_MODE_FOR_DISPLAY);
            imageView.setImageMatrix(m);
            imageView.setImageBitmap(bitmap);
            imageView.invalidate();

        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
