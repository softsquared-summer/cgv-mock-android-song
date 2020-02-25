package com.example.mock_cgv.src.main.home.chart.interfaces;

import com.example.mock_cgv.src.main.home.chart.models.ChartResponse;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ChartRetrofitInterface {


    @GET("/movie?best=top") //어플리케이션클레스에 있는 베이스도메인으로 자동완성, 엔드포인트 바꾸고
    Call<ChartResponse> getMovieChart();


}
