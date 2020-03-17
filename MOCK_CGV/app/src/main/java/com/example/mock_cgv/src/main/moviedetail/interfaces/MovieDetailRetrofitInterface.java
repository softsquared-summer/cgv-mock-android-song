package com.example.mock_cgv.src.main.moviedetail.interfaces;

import com.example.mock_cgv.src.main.moviedetail.models.LikedResponse;
import com.example.mock_cgv.src.main.moviedetail.models.MovieDetailResponse;
import com.example.mock_cgv.src.main.moviedetail.review.models.ReviewResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface MovieDetailRetrofitInterface {

    @GET("/movie/{movieId}") //어플리케이션클레스에 있는 베이스도메인으로 자동완성, 엔드포인트 바꾸고
    Call<MovieDetailResponse> getMovieDetails(
            @Path("movieId") int movieId
    );

    @POST("/movie/{movieId}/liked")
    Call<LikedResponse> PostLikedAdd(
            @Path("movieId") int movieId
    );

    @GET("/movie/{movieId}/liked")
    Call<LikedResponse> getLiked(
            @Path("movieId") int movieId
    );


}
