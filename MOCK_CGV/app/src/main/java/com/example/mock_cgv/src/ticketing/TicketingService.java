package com.example.mock_cgv.src.ticketing;


import android.util.Log;

import com.example.mock_cgv.src.ticketing.interfaces.TicketingActivityView;
import com.example.mock_cgv.src.ticketing.interfaces.TicketingRetrofitInterface;
import com.example.mock_cgv.src.ticketing.models.TicketingResponse;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.example.mock_cgv.src.ApplicationClass.getRetrofit;

public class TicketingService {

    private final TicketingActivityView ticketingActivityView;


    //무비 아이디도 같이 받아와라.
    public TicketingService(TicketingActivityView ticketingActivityView) {
        this.ticketingActivityView = ticketingActivityView;
    }

    public void getTicketingSelect(int movieid){

        final TicketingRetrofitInterface ticketingRetrofitInterface = getRetrofit().create(TicketingRetrofitInterface.class);
        ticketingRetrofitInterface.getTicketSelect(movieid).enqueue(new Callback<TicketingResponse>() {

            @Override
            public void onResponse(Call<TicketingResponse> call, Response<TicketingResponse> response) {

                TicketingResponse ticketingResponse = response.body();

                try{
                    ticketingActivityView.getMovieSelectSuccess(ticketingResponse.getResult());
                } catch (Exception e) {
                    e.printStackTrace();
                }

            }

            @Override
            public void onFailure(Call<TicketingResponse> call, Throwable t) {

            }
        });
    }
}
