package com.example.mock_cgv.src.main.home.chart;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.mock_cgv.R;

import java.util.ArrayList;

public class ChartFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        final View rootView = inflater.inflate(R.layout.fragment_chart,container,false);

        ArrayList<String> list1 = new ArrayList<>();
        for(int i=0;i<100;i++){
            list1.add(String.format("Text %d",i));
        }
        RecyclerView recyclerView = rootView.findViewById(R.id.chart_recycler);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity(),LinearLayoutManager.HORIZONTAL,false));

        ChartRecyclerViewAdapter chartRecyclerViewAdapter = new ChartRecyclerViewAdapter(list1);
        recyclerView.setAdapter(chartRecyclerViewAdapter);


        return rootView;
    }
}
