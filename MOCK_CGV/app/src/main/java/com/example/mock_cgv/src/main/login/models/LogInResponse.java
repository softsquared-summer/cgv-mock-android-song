package com.example.mock_cgv.src.main.login.models;

import com.google.gson.annotations.SerializedName;

import org.json.JSONObject;

import java.io.Serializable;


public class LogInResponse {

    @SerializedName("code")
    private int code;

    public int getCode() {
        return code;
    }

    @SerializedName("message")
    private String message;

    public String getMessage() {
        return message;
    }

    @SerializedName("isSuccess")
    private boolean isSuccess;

    public boolean getIsSuccess() {
        return isSuccess;
    }

    @SerializedName("result")
    public Result result;
    public Result getResult(){
        return result;
    }
    public class Result {
        @SerializedName("jwt")
        public String jwt;
        public String getJwt(){
            return jwt;
        }
    }
}









