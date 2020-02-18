package com.example.mock_cgv.src.main.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import com.example.mock_cgv.R;
import com.google.android.material.tabs.TabItem;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;

public class HomeFragment extends Fragment {
    private TabLayout mTabLayout;
    private NonSwipeViewPager mViewpager;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        final View rootView = inflater.inflate(R.layout.fragment_home,container,false);

        mViewpager=rootView.findViewById(R.id.home_viewpager);
        mTabLayout=rootView.findViewById(R.id.home_tablayout);
        HomeViewPagerAdapter homeViewPagerAdapter = new HomeViewPagerAdapter(getChildFragmentManager(), mTabLayout.getTabCount());
        mViewpager.setAdapter(homeViewPagerAdapter);

        mViewpager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(mTabLayout));
        mTabLayout.addOnTabSelectedListener(new TabLayout.ViewPagerOnTabSelectedListener(mViewpager));


        ArrayList<String> list = new ArrayList<>();
        for(int i=0;i<100;i++){
            list.add(String.format("Text %d",i));
        }
        RecyclerView recyclerView = rootView.findViewById(R.id.home_recycler);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity(),LinearLayoutManager.HORIZONTAL,false));

        HomeRecyclerViewAdapter homeRecyclerViewAdapter = new HomeRecyclerViewAdapter(list);
        recyclerView.setAdapter(homeRecyclerViewAdapter);
        return rootView;
    }
}
