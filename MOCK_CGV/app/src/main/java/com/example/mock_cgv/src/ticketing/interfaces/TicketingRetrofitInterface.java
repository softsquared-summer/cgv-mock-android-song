package com.example.mock_cgv.src.ticketing.interfaces;

import com.example.mock_cgv.src.ticketing.models.TicketDetailResponse;
import com.example.mock_cgv.src.ticketing.models.TicketingResponse;
import com.example.mock_cgv.src.ticketing.models.TicketingSecondResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface TicketingRetrofitInterface {

    @GET("/book/{movieId}") //어플리케이션클레스에 있는 베이스도메인으로 자동완성, 엔드포인트 바꾸고
    Call<TicketingResponse> getTicketSelect(
            @Path("movieId") int movieId
    );

    @GET("/book/{movieId}/theater/{theaterId}")
    Call<TicketingSecondResponse> getMovieTimeTable(
            @Path("movieId") int movieId,
            @Path("theaterId") int theaterId
    );

    @GET("/ticket/{movieTimeId}")
    Call<TicketDetailResponse> getTicketDetail(
            @Path("movieTimeId") int movieTimeId
    );


}
