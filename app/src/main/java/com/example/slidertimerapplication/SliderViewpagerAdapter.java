package com.example.slidertimerapplication;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import java.util.ArrayList;
import java.util.List;

public class SliderViewpagerAdapter extends FragmentStatePagerAdapter {

    int mNumOfTabs;
    Fragment fragment = null;

    List<SliderDetailModel> tabs = new ArrayList<>();

    public SliderViewpagerAdapter(FragmentManager fm, List<SliderDetailModel> tabs) {
        super(fm);
        this.tabs = tabs;
        this.mNumOfTabs = tabs.size();
    }

    @Override
    public Fragment getItem(int position) {

        for (int i = 0; i < mNumOfTabs ; i++) {
            if (i == position) {
                fragment = SliderFragment.newInstance(position , tabs.get(i));
                break;
            }
        }
        return fragment;

    }

    @Override
    public int getCount() {
        return mNumOfTabs;
    }


    // this method return the name of tab
//    @Override
//    public CharSequence getPageTitle(int position) {
//        return tabs.get(position);
//    }
}

