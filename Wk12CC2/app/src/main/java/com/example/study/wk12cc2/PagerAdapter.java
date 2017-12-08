package com.example.study.wk12cc2;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

/**
 * Created by study on 1/12/17.
 */

public class PagerAdapter extends FragmentStatePagerAdapter {

    int mNumOfTabs;

    public PagerAdapter(FragmentManager fm, int mNumOfTabs) {
        super(fm);
        this.mNumOfTabs = mNumOfTabs;
    }

    //TODO 2.1  - implement the method skeleton by using Alt+Enter
    //TODO 2.2  - getItem takes in a position and returns a fragment
    //            depending on the position chosen
    @Override //have to override
    public Fragment getItem(int position) {
        switch(position) {
            case 0:
                return new Fragment1();
            case 1:
                return new Fragment2();
            case 2:
                return new Fragment3();
        }
        return null;
    }
    //TODO 2.3  - getCount returns the number of tabs
    @Override //have to override
    public int getCount(){
        return mNumOfTabs;
    }
}