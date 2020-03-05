package com.example.cs408lab4;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

public class TabPagerAdapter extends FragmentPagerAdapter {

    int tabCount;

    public TabPagerAdapter(FragmentManager fm, int numTabs) {
        super(fm);
        this.tabCount = numTabs;
    }

    @Override
    public Fragment getItem(int position) {

        switch (position) {
            case 0: return new TipFragment();
            case 1: return new RangeFragment();
            case 2: return new DegreeFragment();
            default: return null;
        }
    }

    @Override
    public int getCount() { return tabCount; }

}