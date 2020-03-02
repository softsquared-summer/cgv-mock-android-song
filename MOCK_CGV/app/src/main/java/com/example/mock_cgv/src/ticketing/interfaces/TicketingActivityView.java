package com.example.mock_cgv.src.ticketing.interfaces;

import com.example.mock_cgv.src.ticketing.models.TicketDetailResponse;
import com.example.mock_cgv.src.ticketing.models.TicketingResponse;
import com.example.mock_cgv.src.ticketing.models.TicketingSecondResponse;

import java.util.ArrayList;

public interface TicketingActivityView {

    void getMovieTimeTableSuccess(TicketingSecondResponse.Result result);
    void getMovieTimeTableFail();

    void getMovieSelectSuccess( ArrayList<TicketingResponse.Result> results);
    void getMovieSelectFail();

    void getTicketDetailSuccess(TicketDetailResponse.Result result, int movieTimeId, int code, String message);
    void getTicketDetailFail();

}


