package com.example.mock_cgv.src.select.interfaces;

import com.example.mock_cgv.src.select.models.SelectMovieResponse;

import java.util.ArrayList;

public interface SelectMovieActivityView {


    void getMovieListSuccess(ArrayList<SelectMovieResponse.Result> results);
    void getMovieListFail();
}
