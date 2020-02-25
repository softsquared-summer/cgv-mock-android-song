package com.example.mock_cgv.src.main.home.chart.interfaces;


import com.example.mock_cgv.src.main.home.chart.models.ChartResponse;

import java.util.ArrayList;

public interface ChartFragmentView {
    void GetChartFail();
    void GetChartSuccess(ArrayList<ChartResponse.Result> results);
}
