package com.example.mock_cgv.src.main.models;

import com.google.gson.annotations.SerializedName;

public class DefaultResponse {
    @SerializedName("code")
    private int code;

    @SerializedName("message")
    private String message;

    @SerializedName("isSuccess")
    private boolean isSuccess;

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    public boolean getIsSuccess() {
        return isSuccess;
    }
}

//json으로 넘어온 리스폰스 값을 자동으로
//자바 소스로 바꿔주는 어노테이션이 있다.
//gson이라고 하는 json 파서가 해주는 것.
//post맨으로 넘어왔을때 코드는 json에서 int로 넘어옴(code)