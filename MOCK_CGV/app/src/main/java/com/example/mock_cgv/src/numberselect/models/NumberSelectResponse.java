package com.example.mock_cgv.src.numberselect.models;

import com.google.gson.annotations.SerializedName;

public class NumberSelectResponse {


    @SerializedName("result")
    public Result result;

    public Result getResult() {
        return result;
    }

    public class Result{
        @SerializedName("totalPrice")
        public String totalPrice;
        public String getTotalPrice(){
            return totalPrice;
        }
    }


    @SerializedName("code")
    private int code;
    public int getCode(){
        return code;
    }
    @SerializedName("message")
    private String message;
    public String getMessage(){
        return message;
    }

    @SerializedName("isSuccess")
    private boolean isSuccess;
    public boolean isSuccess(){
        return isSuccess;
    }
}
