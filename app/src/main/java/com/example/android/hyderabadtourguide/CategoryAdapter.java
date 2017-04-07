package com.example.android.hyderabadtourguide;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

/**
 * Created by Pallavi J on 02-04-2017.
 */

public class CategoryAdapter extends FragmentPagerAdapter {
    private Context mContext;
    private final static int NUMBER_OF_FRAGMENTS=5;

    public CategoryAdapter(Context context, FragmentManager fm) {
        super(fm);
        mContext = context;
    }

    @Override
    public Fragment getItem(int position) {
        if (position == 0) {
            return new HistoricFragment();
        } else if (position == 1) {
            return new ReligiousFragment();
        } else if (position == 2) {
            return new LakesFragment();
        } else if (position == 3) {
            return new AmusementFragment();
        } else {
            return new CuisineFragment();
        }
    }

    @Override
    public int getCount() {
        return NUMBER_OF_FRAGMENTS;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        // Generate title based on item position
        if (position == 0) {
            return mContext.getString(R.string.category_historic);
        } else if (position == 1) {
            return mContext.getString(R.string.category_religious);
        } else if (position == 2) {
            return mContext.getString(R.string.category_parkLake);
        } else if (position == 3) {
            return mContext.getString(R.string.category_amusement);
        } else {
            return mContext.getString(R.string.category_cuisine);
        }
    }
}
