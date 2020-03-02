package com.example.mock_cgv.src.main.moviedetail.relatednews.interfaces;

import com.example.mock_cgv.src.main.moviedetail.relatednews.models.RelatedNewsResponse;

public interface RelatedNewsFragmentView {
    void getAgeSexDetailInfoSuccess(RelatedNewsResponse.Result result);
    void getAgeSexDetailInfoFail();

}
