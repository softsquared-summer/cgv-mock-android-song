package com.example.mock_cgv.src.main.login.interfaces;

import com.example.mock_cgv.src.main.login.models.LogInResponse;

public interface LogInActivityView {

    void LogInFail();
    void LogInSuccess(String message, LogInResponse.Result result, int code);
}
