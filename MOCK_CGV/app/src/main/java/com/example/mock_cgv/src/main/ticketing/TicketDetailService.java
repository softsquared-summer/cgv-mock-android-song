package com.example.mock_cgv.src.main.ticketing;

import android.util.Log;

import com.example.mock_cgv.src.main.ticketing.interfaces.TicketingActivityView;
import com.example.mock_cgv.src.main.ticketing.interfaces.TicketingRetrofitInterface;
import com.example.mock_cgv.src.main.ticketing.models.TicketDetailResponse;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.example.mock_cgv.src.ApplicationClass.getRetrofit;

public class TicketDetailService {

    private  final TicketingActivityView ticketingActivityView;
    private int movieTimeId;

    public TicketDetailService(TicketingActivityView ticketingActivityView,int movieTimeId) {
        this.ticketingActivityView = ticketingActivityView;
        this.movieTimeId=movieTimeId;
    }

    public  void getTicketDetail(){
        final TicketingRetrofitInterface ticketingRetrofitInterface = getRetrofit().create(TicketingRetrofitInterface.class);
        ticketingRetrofitInterface.getTicketDetail(movieTimeId).enqueue(new Callback<TicketDetailResponse>() {
            @Override
            public void onResponse(Call<TicketDetailResponse> call, Response<TicketDetailResponse> response) {
                TicketDetailResponse detailResponse = response.body();
                if(detailResponse!=null){
                    try {
                        ticketingActivityView.getTicketDetailSuccess(detailResponse.getResult(),movieTimeId,detailResponse.getCode(),detailResponse.getMessage());
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }

            }

            @Override
            public void onFailure(Call<TicketDetailResponse> call, Throwable t) {
                Log.e("ㅅㄱ","ㅅㄱ");
            }
        });
    }
}
