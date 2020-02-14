package com.example.mock_cgv.src.main;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import com.example.mock_cgv.src.main.event.EventFragment;
import com.example.mock_cgv.src.main.fastorder.FastOrderFragment;
import com.example.mock_cgv.src.main.home.HomeFragment;
import com.example.mock_cgv.src.main.my.MyFragment;
import com.example.mock_cgv.src.main.playzone.PlayZoneFragment;

public class MainViewPagerAdapter extends FragmentStatePagerAdapter {
    private int pageCount;

    public MainViewPagerAdapter(@NonNull FragmentManager fm, int pageCount) {
        super(fm, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);
        this.pageCount = pageCount;
    }

    //특정 index의 content를 리턴하는 메소드
    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return new HomeFragment();
            case 1:
                return new EventFragment();
            case 2:
                return new FastOrderFragment();
            case 3:
                return new PlayZoneFragment();
            case 4:
                return new MyFragment();
            default:
                return null;
        }
    }

    //ViewPager가 가지는 총 content개수
    @Override
    public int getCount() {
        return pageCount;
    }
}
