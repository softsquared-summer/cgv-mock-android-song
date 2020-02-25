package com.example.mock_cgv.src.main.home.chart;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.mock_cgv.R;
import com.example.mock_cgv.src.BaseFragment;
import com.example.mock_cgv.src.main.home.chart.interfaces.ChartFragmentView;
import com.example.mock_cgv.src.main.home.chart.models.ChartResponse;

import java.util.ArrayList;

public class ChartFragment extends BaseFragment implements ChartFragmentView {
    ArrayList<Chart> items = new ArrayList<>();
    ChartRecyclerViewAdapter mChartRecyclerViewAdapter;
    RecyclerView mRecyclerView;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_chart,container,false);
        mRecyclerView = rootView.findViewById(R.id.chart_recycler);

        ChartService chartService = new ChartService(this);
        chartService.getChart();


        return rootView;
    }

    @Override
    public void GetChartFail() {

    }

    @Override
    public void GetChartSuccess(ArrayList<ChartResponse.Result> results) {

        int id,viewAge,goldenEggRatio,ticketingRatio;
        String title,releaseDate,mainImg;

        for(int i=0;i<results.size();i++){
            id=results.get(i).id;
            viewAge=results.get(i).viewAge;
            goldenEggRatio=results.get(i).goldenEggRatio;
            ticketingRatio=results.get(i).ticketingRatio;
            title=results.get(i).title;
            releaseDate=results.get(i).releaseDate;
            mainImg=results.get(i).mainImg;
            Chart chart = new Chart(id,title,viewAge,releaseDate,mainImg,goldenEggRatio,ticketingRatio);
            items.add(chart);
        }

        Log.e("되나?","ㅇㅇ "+items.get(0).getTitle());
        //가로
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity(),LinearLayoutManager.HORIZONTAL,false));
        mChartRecyclerViewAdapter = new ChartRecyclerViewAdapter(items);
        mRecyclerView.setAdapter(mChartRecyclerViewAdapter);



    }


}
