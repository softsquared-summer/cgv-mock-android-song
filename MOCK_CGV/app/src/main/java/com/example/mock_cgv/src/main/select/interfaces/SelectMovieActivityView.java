package com.example.mock_cgv.src.main.select.interfaces;

import com.example.mock_cgv.src.main.select.models.SelectMovieResponse;

import java.util.ArrayList;

public interface SelectMovieActivityView {


    void getMovieListSuccess(ArrayList<SelectMovieResponse.Result> results);
    void getMovieListFail();
}
