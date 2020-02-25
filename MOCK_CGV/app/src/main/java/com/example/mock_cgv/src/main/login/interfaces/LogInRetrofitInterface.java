package com.example.mock_cgv.src.main.login.interfaces;

import com.example.mock_cgv.src.main.login.models.LogInResponse;

import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface LogInRetrofitInterface {

    @POST("/jwt")
    Call<LogInResponse> LogIn(
            @Body RequestBody body
    );
}
