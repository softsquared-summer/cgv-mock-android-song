package com.example.mock_cgv.src.main.home;

import android.content.ContentResolver;
import android.content.Intent;
import android.graphics.Bitmap;
import android.media.MediaPlayer;
import android.media.ThumbnailUtils;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
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


public class HomeFragment extends BaseFragment  {
    private TabLayout mTabLayout;
    private NonSwipeViewPager mNonSwipeViewPager;
    SwipeRefreshLayout mSwipeRefreshLayout;

    ImageView IvThumbNail;
    HomeViewPagerAdapter homeViewPagerAdapter;

    FrameLayout frameLayout;

    LinearLayout mLlHomeVideo;
    View rootView;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.fragment_home, container, false);

        frameLayout=rootView.findViewById(R.id.home_video);
        frameLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.youtube.com/watch?v=_Yc1Yrlv82g"));
                startActivity(intent);
            }
        });

        /*

        무비차트는 리사이클러 뷰 아님, 차트 도메인으로 가야 리사이클러 뷰 있다. 스와이프 안되는 뷰페이져다.

        좋아할것 같아서는 리사이클러뷰임

         */


        //무비차트
        mNonSwipeViewPager = rootView.findViewById(R.id.home_viewpager);
        mTabLayout = rootView.findViewById(R.id.home_tablayout);
        homeViewPagerAdapter = new HomeViewPagerAdapter(getChildFragmentManager(), mTabLayout.getTabCount());

        mNonSwipeViewPager.setAdapter(homeViewPagerAdapter);
        mNonSwipeViewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(mTabLayout));
        mTabLayout.addOnTabSelectedListener(new TabLayout.ViewPagerOnTabSelectedListener(mNonSwipeViewPager));

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


//        //좋아할것같아서
//        ArrayList<String> list = new ArrayList<>();
//        for (int i = 0; i < 100; i++) {
//            list.add(String.format("Text %d", i));
//        }
//        RecyclerView recyclerView = rootView.findViewById(R.id.home_rv_like_recycler);
//        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false));
//
//        HomeRecyclerViewAdapter homeRecyclerViewAdapter = new HomeRecyclerViewAdapter(list);
//        recyclerView.setAdapter(homeRecyclerViewAdapter);

        //섬네일
        IvThumbNail=rootView.findViewById(R.id.home_iv_video_thumbnail);


        mLlHomeVideo=rootView.findViewById(R.id.home_ll_video);
        mLlHomeVideo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String url ="http://www.cgv.co.kr/movies/detail-view/?midx=83058";
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
                startActivity(intent);
            }
        });

        ImageView IvHomeAd1 = rootView.findViewById(R.id.home_ad1);
        IvHomeAd1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String url ="http://www.cgv.co.kr/culture-event/event/detail-view.aspx?idx=20870";
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
                startActivity(intent);
            }
        });
        ImageView IvHomeLexusAd = rootView.findViewById(R.id.home_iv_lexus_ad);
        IvHomeLexusAd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String url ="https://lexus.co.kr/";
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
                startActivity(intent);
            }
        });

//        LinearLayout linearLayout=rootView.findViewById(R.id.home_not_yet);
//        linearLayout.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                showCustomToast("준비중 입니다!");
//            }
//        });
        return rootView;


    }


}
