package com.example.mock_cgv.src.main.interfaces;

public interface MainActivityView {

    void validateSuccess(String text);
    void validateSuccess201(String text);

    void validateFailure(String message);
}
