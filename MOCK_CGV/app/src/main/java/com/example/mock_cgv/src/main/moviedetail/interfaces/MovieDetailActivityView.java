package com.example.mock_cgv.src.main.moviedetail.interfaces;

import com.example.mock_cgv.src.main.moviedetail.models.LikedResponse;
import com.example.mock_cgv.src.main.moviedetail.models.MovieDetailResponse;

public interface MovieDetailActivityView {
    void GetInfoSuccess(String message, MovieDetailResponse.Result result);
    void GetInfoFail();

    void GetLikedSuccess(LikedResponse.Result result);
    void GetLikedFail();

    void PostLikedAddSuccess(String message, int code, LikedResponse.Result result);
    void PostLikedAddFail();
}
