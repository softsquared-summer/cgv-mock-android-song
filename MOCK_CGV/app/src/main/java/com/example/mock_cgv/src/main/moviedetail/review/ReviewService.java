package com.example.mock_cgv.src.main.moviedetail.review;

import android.util.Log;

import com.example.mock_cgv.src.main.moviedetail.review.interfaces.ReviewFragmentView;
import com.example.mock_cgv.src.main.moviedetail.review.interfaces.ReviewRetrofitInterface;
import com.example.mock_cgv.src.main.moviedetail.review.models.ReviewResponse;

import org.json.JSONObject;

import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.example.mock_cgv.src.ApplicationClass.MEDIA_TYPE_JSON;
import static com.example.mock_cgv.src.ApplicationClass.getRetrofit;


public class ReviewService {
    ReviewFragmentView mReviewFragmentView;

    public ReviewService(ReviewFragmentView mReviewFragmentView) {
        this.mReviewFragmentView = mReviewFragmentView;
    }

    public void getReview(int movieid){

        ReviewRetrofitInterface reviewRetrofitInterface = getRetrofit().create(ReviewRetrofitInterface.class);
        reviewRetrofitInterface.getReview(movieid).enqueue(new Callback<ReviewResponse>() {
            @Override
            public void onResponse(Call<ReviewResponse> call, Response<ReviewResponse> response) {

                ReviewResponse reviewResponse=response.body();
                mReviewFragmentView.getReviewSucces(reviewResponse.getResult(),reviewResponse.getCode(),reviewResponse.getMessage());
            }

            @Override
            public void onFailure(Call<ReviewResponse> call, Throwable t) {

            }
        });
    }

    public void patchStateUpdate(){
        ReviewRetrofitInterface reviewRetrofitInterface = getRetrofit().create(ReviewRetrofitInterface.class);
        reviewRetrofitInterface.patchStateUpdate().enqueue(new Callback<ReviewResponse>() {
            @Override
            public void onResponse(Call<ReviewResponse> call, Response<ReviewResponse> response) {
                ReviewResponse reviewResponse = response.body();
                mReviewFragmentView.patchStateUpdateSuccess(reviewResponse.getMessage());
            }

            @Override
            public void onFailure(Call<ReviewResponse> call, Throwable t) {

            }
        });
    }

    public void postReviewEnroll(int movieid,int goldeneggstatus,String content){
        ReviewRetrofitInterface reviewRetrofitInterface = getRetrofit().create(ReviewRetrofitInterface.class);
        JSONObject jsonObject = new JSONObject();
        try{
            jsonObject.put("movieId",movieid);
            jsonObject.put("goldenEggStatus",goldeneggstatus);
            jsonObject.put("content",content);
        } catch (Exception e) {
            e.printStackTrace();
        }
        String body = jsonObject.toString();
        RequestBody requestBody = RequestBody.Companion.create(body,MEDIA_TYPE_JSON);

        reviewRetrofitInterface.postReviewEnroll(requestBody).enqueue(new Callback<ReviewResponse>() {
            @Override
            public void onResponse(Call<ReviewResponse> call, Response<ReviewResponse> response) {
                ReviewResponse reviewResponse = response.body();
                mReviewFragmentView.postReviewEnrollSuccess(reviewResponse.getMessage());
            }

            @Override
            public void onFailure(Call<ReviewResponse> call, Throwable t) {

            }
        });

    }
}
