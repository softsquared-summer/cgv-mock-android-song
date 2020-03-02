package com.example.mock_cgv.src.main.home.chart.interfaces;



import com.example.mock_cgv.src.main.home.chart.models.ChartResponse;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ChartRetrofitInterface {

    @GET("/movie?condition=best")
    Call<ChartResponse> getMovieChart();

}
