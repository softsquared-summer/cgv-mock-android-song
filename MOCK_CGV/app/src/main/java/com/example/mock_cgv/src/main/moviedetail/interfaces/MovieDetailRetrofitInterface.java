package com.example.mock_cgv.src.main.moviedetail.interfaces;

import com.example.mock_cgv.src.main.moviedetail.models.MovieDetailResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface MovieDetailRetrofitInterface {

    @GET("/movie/{movieId}") //어플리케이션클레스에 있는 베이스도메인으로 자동완성, 엔드포인트 바꾸고
    Call<MovieDetailResponse> getMovieDetails(
            @Path("movieId") int movieId
    );

//    @GET("/test/{number}")
//    Call<DefaultResponse> getTestPathAndQuery(
//            @Path("number") int number,
//            @Query("content") final String content
//    );


}
