package com.example.mock_cgv.src.main.moviedetail.interfaces;

import com.example.mock_cgv.src.main.moviedetail.models.MovieDetailResponse;

public interface MovieDetailActivityView {
    void GetInfoSuccess(String message, MovieDetailResponse.Result result);
    void GetInfoFail();

}
