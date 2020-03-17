package com.example.mock_cgv.src.main.moviedetail.models;

import com.google.gson.annotations.SerializedName;

public class LikedResponse {

    @SerializedName("isSuccess")
    public boolean isSuccess;
    public boolean getIsSuccess(){
        return isSuccess;
    }

    @SerializedName("code")
    public int code;
    public int getCode(){
        return code;
    }

    @SerializedName("message")
    public String message;
    public String getMessage(){
        return message;
    }

    @SerializedName("result")
    public Result result;
    public Result getResult(){
        return result;
    }
    public class Result{
        @SerializedName("movieId")
        public int movieId;

        public int getMovieId() {
            return movieId;
        }

        @SerializedName("count")
        public int count;

        public int getCount() {
            return count;
        }

        @SerializedName("userId")
        public String userId;

        public String getUserId() {
            return userId;
        }

        @SerializedName("isLiked")
        public int isLiked;

        public int getIsLiked() {
            return isLiked;
        }
    }
}
