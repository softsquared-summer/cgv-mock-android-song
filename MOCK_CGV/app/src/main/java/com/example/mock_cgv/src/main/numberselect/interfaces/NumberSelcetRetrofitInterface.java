package com.example.mock_cgv.src.main.numberselect.interfaces;

import com.example.mock_cgv.src.main.numberselect.models.NumberSelectResponse;

import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface NumberSelcetRetrofitInterface {


    @POST("/ticket/{movieTimeId}")
    Call<NumberSelectResponse> postBuy(
            @Body RequestBody params,
            @Path("movieTimeId") int movieTimeId
    );

}
