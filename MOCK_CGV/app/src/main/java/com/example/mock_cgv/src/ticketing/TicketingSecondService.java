package com.example.mock_cgv.src.ticketing;

import android.util.Log;

import com.example.mock_cgv.src.ticketing.interfaces.TicketingActivityView;
import com.example.mock_cgv.src.ticketing.interfaces.TicketingRetrofitInterface;
import com.example.mock_cgv.src.ticketing.models.TicketingSecondResponse;


import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.example.mock_cgv.src.ApplicationClass.getRetrofit;

public class TicketingSecondService {

    private int mMovieId,mTheaterId;
    private final TicketingActivityView ticketingActivityView;


    public TicketingSecondService(int MovieId,int TheaterId , TicketingActivityView ticketingActivityView) {
        this.mMovieId = MovieId;
        this.mTheaterId=TheaterId;
        this.ticketingActivityView = ticketingActivityView;
    }

    public void getMovieTimeTable(){

        final TicketingRetrofitInterface ticketingRetrofitInterface = getRetrofit().create(TicketingRetrofitInterface.class);
        ticketingRetrofitInterface.getMovieTimeTable(mMovieId,mTheaterId).enqueue(new Callback<TicketingSecondResponse>() {

            @Override
            public void onResponse(Call<TicketingSecondResponse> call, Response<TicketingSecondResponse> response) {
                TicketingSecondResponse ticketingSecondResponse = response.body();

                if(ticketingSecondResponse!=null){
                    ticketingActivityView.getMovieTimeTableSuccess(ticketingSecondResponse.getResult());
                }
            }

            @Override
            public void onFailure(Call<TicketingSecondResponse> call, Throwable t) {

            }

        });
    }

}
