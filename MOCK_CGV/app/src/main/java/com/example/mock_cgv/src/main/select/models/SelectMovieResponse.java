package com.example.mock_cgv.src.main.select.models;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class SelectMovieResponse {

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

    @SerializedName("result")
    private ArrayList<Result> result;
    public void setResult(ArrayList<Result> result){
        this.result=result;
    }
    public ArrayList<Result> getResult(){
        return result;
    }
    public class Result{
        @SerializedName("id") public int id;
        @SerializedName("title") public String title;
        @SerializedName("thumbnail") public String thumbnail;

        public int getId(){
            return id;
        }
        public String getTitle(){
            return title;
        }
        public String getThumbnail(){
            return thumbnail;
        }
    }



}
