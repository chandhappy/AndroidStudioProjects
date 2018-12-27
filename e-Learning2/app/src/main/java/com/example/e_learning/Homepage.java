package com.example.e_learning;

import android.app.Fragment;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class Homepage extends AppCompatActivity {

    private List<ItemSlideMenu> listSliding;
    private SlidingMenuAdapter adapter;
    private ListView listViewSliding;
    private DrawerLayout drawerLayout;
    private ActionBarDrawerToggle actionBarDrawerToggle;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.homepage);


        //Init component
        listViewSliding = (ListView) findViewById(R.id.lv_sliding_menu);


        drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);

        listSliding = new ArrayList<>();
        //Add item for sliding list

        listSliding.add(new ItemSlideMenu(R.mipmap.ic_launcher, "Topics"));
        listSliding.add(new ItemSlideMenu(R.drawable.basket, "My Topics"));
        listSliding.add(new ItemSlideMenu(R.mipmap.ic_launcher, "Progress"));
        listSliding.add(new ItemSlideMenu(R.drawable.knowledge, "Discussion"));
        listSliding.add(new ItemSlideMenu(R.drawable.assessment, "Assessment"));
        listSliding.add(new ItemSlideMenu(R.drawable.award, "Certificates"));
        listSliding.add(new ItemSlideMenu(R.drawable.exit, "Exit"));

        adapter = new SlidingMenuAdapter(this, listSliding);
        LayoutInflater myinflater = getLayoutInflater();
        ViewGroup myHeader = (ViewGroup)myinflater.inflate(R.layout.nav_header_navigation,listViewSliding,false);
        listViewSliding.addHeaderView(myHeader,null,false);

        listViewSliding.setAdapter(adapter);
        listViewSliding.setSelection(0);

        //Display icon to open/ close sliding list
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        //Set title
        setTitle("e-Learning");
        //item selected
        listViewSliding.setItemChecked(0, true);

        //Close menu
        drawerLayout.closeDrawer(listViewSliding);


        //Display fragment 1 when start
        replaceFragment(0);
        //Handle on item click

        listViewSliding.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //Set title
                setTitle(listSliding.get(position-1).getTitle());
                //item selected
                listViewSliding.setItemChecked(position, true);
                //Replace fragment
                replaceFragment(position);
                //Close menu
                drawerLayout.closeDrawer(listViewSliding);
            }
        });

        actionBarDrawerToggle = new ActionBarDrawerToggle(this, drawerLayout, R.string.drawer_opened, R.string.drawer_closed) {


            @Override
            public void onDrawerOpened(View drawerView) {
                super.onDrawerOpened(drawerView);
                invalidateOptionsMenu();
            }

            @Override
            public void onDrawerClosed(View drawerView) {
                super.onDrawerClosed(drawerView);
                invalidateOptionsMenu();
            }
        };

        drawerLayout.addDrawerListener(actionBarDrawerToggle);

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if (actionBarDrawerToggle.onOptionsItemSelected(item)) {
            return true;
        }
      /*  switch (item.getItemId()) {
            case android.R.id.home:
                Intent homeIntent = new Intent(this, Homepage.class);
                homeIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(homeIntent);
        }*/
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        actionBarDrawerToggle.syncState();
    }

    //Create method replace fragment

    private void replaceFragment(int pos) {
        Fragment fragment = null;
        switch (pos) {
            case 0:
                fragment = new empty();
                break;
            case 1:
                fragment = new Topic();
                break;
            case 2:
                fragment = new MyTopics();
                break;
            case 3:
                fragment = new Progress();
                break;
            case 4:
                fragment = new Discussion();
                break;
            case 5:
                fragment = new Assessment();
                break;
            case 6:
                fragment = new Certificates();
                break;
            default:
                fragment = new empty();
                break;
        }

        if (null != fragment) {
            android.app.FragmentManager fragmentManager = getFragmentManager();
            FragmentTransaction transaction = fragmentManager.beginTransaction();
            transaction.replace(R.id.main_content, fragment);
            transaction.addToBackStack(null);
            transaction.commit();
        }
    }

}




