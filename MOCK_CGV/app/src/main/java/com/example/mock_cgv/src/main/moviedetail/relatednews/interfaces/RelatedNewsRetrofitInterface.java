package com.example.mock_cgv.src.main.moviedetail.relatednews.interfaces;

import com.example.mock_cgv.src.main.moviedetail.relatednews.models.RelatedNewsResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface RelatedNewsRetrofitInterface {


    @GET("/movie/{movieId}/detail")
    Call<RelatedNewsResponse> getAgeSexDetailInfo(
            @Path("movieId") int movieId
    );
}
