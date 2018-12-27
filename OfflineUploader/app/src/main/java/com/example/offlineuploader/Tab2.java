package com.example.offlineuploader;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;

/**
 * Created by INCBASHA on 11/2/2016.
 */
public class Tab2 extends Fragment implements View.OnClickListener {
    LayoutInflater inflater;
    Button btnDatePicker, btnTimePicker;
    EditText txtDate, txtTime;
    private int mYear, mMonth, mDay, mHour, mMinute;
    public final static String EXTRA_MESSAGE = "MESSAGE";
    private ListView obj;
    DBHelper mydb;

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.tab2, container, false);
            mydb = new DBHelper(this);
            ArrayList array_list = mydb.getAllCotacts();
            ArrayAdapter arrayAdapter=new ArrayAdapter(this, android.R.layout.simple_list_item_1, array_list);

            obj = (ListView)rootView.findViewById(R.id.listView1);
            obj.setAdapter(arrayAdapter);
            obj.setOnItemClickListener(new AdapterView.OnItemClickListener(){
                @Override
                public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,long arg3) {
                    // TODO Auto-generated method stub
                    int id_To_Search = arg2 + 1;

                    Bundle dataBundle = new Bundle();
                    dataBundle.putInt("id", id_To_Search);

                    Intent intent = new Intent(getApplicationContext(),DisplayContact.class);

                    intent.putExtras(dataBundle);
                    startActivity(intent);
                }
            });
        }

        @Override
        public boolean onCreateOptionsMenu(Menu menu) {
            // Inflate the menu; this adds items to the action bar if it is present.
            getMenuInflater().inflate(R.menu.menu_main, menu);
            return true;
        }

        @Override
        public boolean onOptionsItemSelected(MenuItem item){
            super.onOptionsItemSelected(item);

            switch(item.getItemId()) {
                case R.id.item1:Bundle dataBundle = new Bundle();
                    dataBundle.putInt("id", 0);

                    Intent intent = new Intent(getApplicationContext(),DisplayContact.class);
                    intent.putExtras(dataBundle);

                    startActivity(intent);
                    return true;
                default:
                    return super.onOptionsItemSelected(item);
            }
        }

        public boolean onKeyDown(int keycode, KeyEvent event) {
            if (keycode == KeyEvent.KEYCODE_BACK) {
                moveTaskToBack(true);
            }
            return super.onKeyDown(keycode, event);
        }
    @Override
    public void onClick(View v) {
        if (v == btnDatePicker) {
        }
    }
}
