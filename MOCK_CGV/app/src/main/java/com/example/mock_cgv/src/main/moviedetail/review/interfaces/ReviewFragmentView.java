package com.example.mock_cgv.src.main.moviedetail.review.interfaces;

import com.example.mock_cgv.src.main.moviedetail.review.models.ReviewResponse;

import java.util.ArrayList;

public interface ReviewFragmentView {

    void getReviewSucces(ReviewResponse.Result result,int code,String message);
    void getReviewFail();

    void patchStateUpdateSuccess(String message);
    void patchStateUpdateFail();

    void postReviewEnrollSuccess(String message);
    void postReviewEnrollFail();
}
