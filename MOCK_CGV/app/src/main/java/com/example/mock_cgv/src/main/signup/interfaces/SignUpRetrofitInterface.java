package com.example.mock_cgv.src.main.signup.interfaces;

import com.example.mock_cgv.src.main.models.DefaultResponse;
import com.example.mock_cgv.src.main.signup.models.SignUpResponse;

import java.util.HashMap;

import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface SignUpRetrofitInterface {

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

//    @FormUrlEncoded
    @POST("/users")
    Call<SignUpResponse> SignUp(
            @Body String body
    );
}
//
//            @Field("userId") String userId,
//            @Field("pw") String pw,
//            @Field("email") String email,
//            @Field("userName") String userName,
//            @Field("sexStatus") int sexStatus,
//            @Field("ageStatus") int ageStatus
