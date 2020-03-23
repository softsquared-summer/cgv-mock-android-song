package com.example.mock_cgv.src.main.numberselect.interfaces;

import com.example.mock_cgv.src.main.numberselect.models.NumberSelectResponse;

public interface NumberSelectActivityView {
    void postBuyTicketSuccess(NumberSelectResponse.Result result);
    void postBuyTicketFail();

}
