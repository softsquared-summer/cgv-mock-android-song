package com.example.mock_cgv.src.main.moviedetail.review.interfaces;

import com.example.mock_cgv.src.main.moviedetail.review.models.ReviewResponse;

import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.PATCH;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface ReviewRetrofitInterface {


    @GET("/review/{movieId}")
    Call<ReviewResponse> getReview(
            @Path("movieId") int movieId
    );

    @PATCH("/past-time")
    Call<ReviewResponse> patchStateUpdate();

    @POST("/review")
    Call<ReviewResponse> postReviewEnroll(
            @Body RequestBody params
    );


}
