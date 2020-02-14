package com.example.mock_cgv.src.main.interfaces;

import com.example.mock_cgv.src.main.models.DefaultResponse;

import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface MainRetrofitInterface {

    @GET("/jwt") //어플리케이션클레스에 있는 베이스도메인으로 자동완성, 엔드포인트 바꾸고
    Call<DefaultResponse> getTest();

    @GET("/test/{number}")
    Call<DefaultResponse> getTestPathAndQuery(
        @Path("number") int number,
        @Query("content") final String content
    );
//줘야 하는 리퀘스트 파라미터와 리스폰스 파라미터를 모델스 라고 하는 데이터 클래스, 리스폰스가 넘어오는
    //데이터를 정의 해논 클래스다.
    @POST("/test")
    Call<DefaultResponse> postTest(@Body RequestBody params);
}
