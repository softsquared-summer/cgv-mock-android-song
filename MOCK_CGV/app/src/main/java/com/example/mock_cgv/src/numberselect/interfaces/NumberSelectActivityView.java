package com.example.mock_cgv.src.numberselect.interfaces;

import com.example.mock_cgv.src.numberselect.models.NumberSelectResponse;

public interface NumberSelectActivityView {
    void postBuyTicketSuccess(NumberSelectResponse.Result result);
    void postBuyTicketFail();

}
