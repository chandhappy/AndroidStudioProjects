package com.example.offlineuploader;
import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

class ViewPagerAdapter extends FragmentPagerAdapter {

    // Tab Titles
    private String tabtitles[] = new String[] { "Patient Creation", "Pending Studies", "Uploaded Studies" };
    Context context;

    public ViewPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public int getCount() {
        return tabtitles.length;
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return new Tab1();
            case 1:
                return new Tab2();
            case 2:
                return new Tab3();
        }
        return null;
    }
    @Override
    public CharSequence getPageTitle(int position) {
        return tabtitles[position];
    }
}