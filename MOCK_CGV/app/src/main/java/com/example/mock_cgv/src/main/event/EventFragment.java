package com.example.mock_cgv.src.main.event;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.example.mock_cgv.R;
import com.github.demono.AutoScrollViewPager;

import java.util.ArrayList;



public class EventFragment extends Fragment {
    AutoScrollViewPager mAutoScrollViewPager;
    ArrayList<String> mData = new ArrayList<>();
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_event,container,false);

        mData.add("https://ifh.cc/g/PVsu0.jpg");
        mData.add("https://ifh.cc/g/undzd.jpg");
        mData.add("https://ifh.cc/g/nouNk.jpg");
        mAutoScrollViewPager=(AutoScrollViewPager)rootView.findViewById(R.id.main_auto_view_pager);
        AutoScrollAdapter scrollAdapter = new AutoScrollAdapter(mData,getActivity());
        mAutoScrollViewPager.setAdapter(scrollAdapter);
        mAutoScrollViewPager.startAutoScroll();
        return rootView;
    }
}
