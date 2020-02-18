package com.example.mock_cgv.src.main.home;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import com.example.mock_cgv.src.main.home.chart.ChartFragment;
import com.example.mock_cgv.src.main.home.parasite.ParasiteFragment;
import com.example.mock_cgv.src.main.home.speedcoupon.SpeedCouponFragment;

public class HomeViewPagerAdapter extends FragmentStatePagerAdapter {
    private int mPageCount;

    public HomeViewPagerAdapter(@NonNull FragmentManager fm, int pageCount) {
        super(fm, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);
        this.mPageCount=pageCount;
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0:
                return new ChartFragment();
            case 1:
                return new ParasiteFragment();
            case 2:
                return new SpeedCouponFragment();
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return mPageCount;
    }
}
