package com.example.mock_cgv.src.main.moviedetail;

import android.util.Log;

import com.example.mock_cgv.src.main.login.models.LogInResponse;
import com.example.mock_cgv.src.main.moviedetail.interfaces.MovieDetailActivityView;
import com.example.mock_cgv.src.main.moviedetail.interfaces.MovieDetailRetrofitInterface;
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
