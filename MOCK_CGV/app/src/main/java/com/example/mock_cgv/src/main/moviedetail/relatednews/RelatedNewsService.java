package com.example.mock_cgv.src.main.moviedetail.relatednews;

import android.util.Log;

import com.example.mock_cgv.src.main.moviedetail.relatednews.interfaces.RelatedNewsFragmentView;
import com.example.mock_cgv.src.main.moviedetail.relatednews.interfaces.RelatedNewsRetrofitInterface;
import com.example.mock_cgv.src.main.moviedetail.relatednews.models.RelatedNewsResponse;
import com.example.mock_cgv.src.main.moviedetail.review.models.ReviewResponse;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.example.mock_cgv.src.ApplicationClass.getRetrofit;


public class RelatedNewsService {
    private final RelatedNewsFragmentView mRelatedNewsFragmentView;

    public RelatedNewsService(RelatedNewsFragmentView mRelatedNewsFragmentView) {
        this.mRelatedNewsFragmentView = mRelatedNewsFragmentView;
    }

    public void getAgeSexDetailInformation(int movieid){
        final RelatedNewsRetrofitInterface relatedNewsRetrofitInterface=getRetrofit().create(RelatedNewsRetrofitInterface.class);
        relatedNewsRetrofitInterface.getAgeSexDetailInfo(movieid).enqueue(new Callback<RelatedNewsResponse>() {
            @Override
            public void onResponse(Call<RelatedNewsResponse> call, Response<RelatedNewsResponse> response) {
                RelatedNewsResponse relatedNewsResponse = response.body();
                mRelatedNewsFragmentView.getAgeSexDetailInfoSuccess(relatedNewsResponse.getResult());
            }

            @Override
            public void onFailure(Call<RelatedNewsResponse> call, Throwable t) {
                Log.e("gogogogo",""+t.getMessage());

            }
        });
    }
}
