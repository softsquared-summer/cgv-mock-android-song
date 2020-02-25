package com.example.mock_cgv.src.main.login.interfaces;

public interface LogInActivityView {

    void LogInFail();
    void LogInSuccess(String message,int code,String jwt);

}
