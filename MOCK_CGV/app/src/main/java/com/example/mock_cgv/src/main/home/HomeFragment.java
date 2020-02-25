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
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import androidx.viewpager.widget.ViewPager;

import com.example.mock_cgv.R;
import com.example.mock_cgv.src.BaseFragment;
import com.google.android.material.tabs.TabItem;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;

public class HomeFragment extends BaseFragment {
    private TabLayout mTabLayout;
    private NonSwipeViewPager mNonSwipeViewPager;
    SwipeRefreshLayout mSwipeRefreshLayout;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        final View rootView = inflater.inflate(R.layout.fragment_home, container, false);

        /*

        무비차트는 리사이클러 뷰 아님, 차트 도메인으로 가야 리사이클러 뷰 있다. 스와이프 안되는 뷰페이져다.

        좋아할것 같아서는 리사이클러뷰임

         */

        //새로고침
        mSwipeRefreshLayout = rootView.findViewById(R.id.home_swipe_refresh_layout);
        mSwipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {

            @Override
            public void onRefresh() {

                //TODO 새로고침 만들기
                //재통신을 해야된다는데 모르겟다.
                mSwipeRefreshLayout.setRefreshing(false);
            }
        });

                //무비차트
        mNonSwipeViewPager = rootView.findViewById(R.id.home_viewpager);
        mTabLayout = rootView.findViewById(R.id.home_tablayout);
        HomeViewPagerAdapter homeViewPagerAdapter = new HomeViewPagerAdapter(getChildFragmentManager(), mTabLayout.getTabCount());
        mNonSwipeViewPager.setAdapter(homeViewPagerAdapter);
        mNonSwipeViewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(mTabLayout));
        mTabLayout.addOnTabSelectedListener(new TabLayout.ViewPagerOnTabSelectedListener(mNonSwipeViewPager));


        //좋아할것같아서
        ArrayList<String> list = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            list.add(String.format("Text %d", i));
        }
        RecyclerView recyclerView = rootView.findViewById(R.id.home_rv_like_recycler);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false));

        HomeRecyclerViewAdapter homeRecyclerViewAdapter = new HomeRecyclerViewAdapter(list);
        recyclerView.setAdapter(homeRecyclerViewAdapter);
        return rootView;
    }
}
