package com.addindev.myapplication.ui.main;

import android.content.Context;

import androidx.annotation.Nullable;
import androidx.annotation.StringRes;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.addindev.myapplication.R;
import com.addindev.myapplication.listmovies.MovListFrag;
import com.addindev.myapplication.listtvshow.TvListShowFrag;

public class PagerAdapter extends FragmentPagerAdapter {

    @StringRes
    private static final int[] TAB_TITLES = new int[]{R.string.tab_text_1, R.string.tab_text_2};
    private final Context mContext;
    private MovListFrag moviesFragment;
    private TvListShowFrag tvShowFragment;

    public PagerAdapter(Context context, FragmentManager fm) {

        super(fm);
        mContext = context;
        moviesFragment = new MovListFrag();
        tvShowFragment = new TvListShowFrag();

    }

    @Override
    public Fragment getItem(int position) {

        switch (position){
            case 0 :
                return new MovListFrag();
            case 1 :
                return new TvListShowFrag();
            default:
                return null;

        }
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return mContext.getResources().getString(TAB_TITLES[position]);
    }

    @Override
    public int getCount() {

        return 2;

    }
}