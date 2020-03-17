package com.example.mock_cgv.src.main.moviedetail;

import android.util.Log;

import com.example.mock_cgv.src.main.login.models.LogInResponse;
import com.example.mock_cgv.src.main.moviedetail.interfaces.MovieDetailActivityView;
import com.example.mock_cgv.src.main.moviedetail.interfaces.MovieDetailRetrofitInterface;
import com.example.mock_cgv.src.main.moviedetail.models.LikedResponse;
import com.example.mock_cgv.src.main.moviedetail.models.MovieDetailResponse;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.example.mock_cgv.src.ApplicationClass.getRetrofit;

public class MovieDetailService {

    private int mMovieId;
    private final MovieDetailActivityView movieDetailActivityView;

    public MovieDetailService(MovieDetailActivityView movieDetailActivityView,int MovieId) {
        this.movieDetailActivityView = movieDetailActivityView;
        this.mMovieId=MovieId;
    }

    public void getLiked(){
        final MovieDetailRetrofitInterface movieDetailRetrofitInterface = getRetrofit().create(MovieDetailRetrofitInterface.class);
        movieDetailRetrofitInterface.getLiked(mMovieId).enqueue(new Callback<LikedResponse>() {
            @Override
            public void onResponse(Call<LikedResponse> call, Response<LikedResponse> response) {
                LikedResponse likedResponse = response.body();
                if(likedResponse.getCode()==100){
                    movieDetailActivityView.GetLikedSuccess(likedResponse.getResult());
                }
            }

            @Override
            public void onFailure(Call<LikedResponse> call, Throwable t) {

            }
        });
    }

    public void postLikedAdd(){
        final MovieDetailRetrofitInterface movieDetailRetrofitInterface = getRetrofit().create(MovieDetailRetrofitInterface.class);
        movieDetailRetrofitInterface.PostLikedAdd(mMovieId).enqueue(new Callback<LikedResponse>() {
            @Override
            public void onResponse(Call<LikedResponse> call, Response<LikedResponse> response) {
                LikedResponse likedResponse = response.body();
                Log.e("result",""+likedResponse.result);
                movieDetailActivityView.PostLikedAddSuccess(likedResponse.getMessage(),likedResponse.getCode(),likedResponse.getResult());
            }

            @Override
            public void onFailure(Call<LikedResponse> call, Throwable t) {

            }
        });
    }



    public void getMovieDetails() {

        final MovieDetailRetrofitInterface movieDetailRetrofitInterface = getRetrofit().create(MovieDetailRetrofitInterface.class);
        movieDetailRetrofitInterface.getMovieDetails(mMovieId).enqueue(new Callback<MovieDetailResponse>() {
            @Override
            public void onResponse(Call<MovieDetailResponse> call, Response<MovieDetailResponse> response) {
                MovieDetailResponse movieDetailResponse = response.body();
                if(movieDetailResponse.isSuccess==true){
                    movieDetailActivityView.GetInfoSuccess(movieDetailResponse.getMessage(),movieDetailResponse.getResult());

                }
            }
            @Override
            public void onFailure(Call<MovieDetailResponse> call, Throwable t) {
                movieDetailActivityView.GetInfoFail();
            }
        });


    }
}
