package com.example.mock_cgv.src.main.home.chart;

import android.content.Context;
import android.util.Log;

import com.example.mock_cgv.src.main.home.chart.interfaces.ChartFragmentView;
import com.example.mock_cgv.src.main.home.chart.interfaces.ChartRetrofitInterface;
import com.example.mock_cgv.src.main.home.chart.models.ChartResponse;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.example.mock_cgv.src.ApplicationClass.getRetrofit;

public class ChartService {


    private final ChartFragmentView mChartFragmentView;

    ChartService(final ChartFragmentView chartFragmentView) {
        this.mChartFragmentView = chartFragmentView;
    }

    public void getChart() {

        final ChartRetrofitInterface chartRetrofitInterface = getRetrofit().create(ChartRetrofitInterface.class);
        chartRetrofitInterface.getMovieChart().enqueue(new Callback<ChartResponse>() {
            @Override
            public void onResponse(Call<ChartResponse> call, Response<ChartResponse> response) {
                ChartResponse chartResponse = response.body();

                mChartFragmentView.GetChartSuccess(chartResponse.getResult());
            }
            @Override
            public void onFailure(Call<ChartResponse> call, Throwable t) {
            }
        });
    }
}