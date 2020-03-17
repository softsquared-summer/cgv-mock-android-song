package com.example.mock_cgv.src.main.home.chart;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import com.example.mock_cgv.src.BaseActivity;
import com.example.mock_cgv.src.main.home.chart.interfaces.ChartFragmentView;
import com.example.mock_cgv.src.main.home.chart.interfaces.ChartRetrofitInterface;
import com.example.mock_cgv.src.main.home.chart.models.ChartResponse;

import java.io.IOException;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static android.content.Context.LOCATION_SERVICE;
import static com.example.mock_cgv.src.ApplicationClass.getRetrofit;

public class ChartService {

    ChartFragmentView mChartFragmentView;

    public ChartService(ChartFragmentView chartFragmentView) {
        this.mChartFragmentView = chartFragmentView;
    }

    public void getChart() {

        ChartRetrofitInterface chartRetrofitInterface = getRetrofit().create(ChartRetrofitInterface.class);
        chartRetrofitInterface.getMovieChart().enqueue(new Callback<ChartResponse>() {


            @Override
            public void onResponse(Call<ChartResponse> call, Response<ChartResponse> response) {
                ChartResponse chartResponse=response.body();

                mChartFragmentView.GetChartSuccess(chartResponse.getResult());
            }
            @Override
            public void onFailure(Call<ChartResponse> call, Throwable t) {
                if (t instanceof IOException) {
                    Log.e("ERROR","인터넷 연결문제");

                }
                else {
                    Log.e("ERROR","인터넷 연결문제 아님");
                }
            }
        });
    }
}