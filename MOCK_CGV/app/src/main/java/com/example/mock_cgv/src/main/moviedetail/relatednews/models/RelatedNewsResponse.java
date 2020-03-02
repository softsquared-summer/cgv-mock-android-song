package com.example.mock_cgv.src.main.moviedetail.relatednews.models;

import com.google.gson.annotations.SerializedName;

import retrofit2.http.PUT;

public class RelatedNewsResponse {

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
    public class Result {
        @SerializedName("movieId")
        public int movieId;
        @SerializedName("totalCount")
        public int totalCount;
        @SerializedName("maleRatio")
        public int maleRatio;
        @SerializedName("femaleRatio")
        public int femaleRatio;
        @SerializedName("teenAgePercent")
        public int teenAgePercent;
        @SerializedName("twentiesPercent")
        public int twentiesPercent;
        @SerializedName("thirtyPercent")
        public int thirtyPercent;
        @SerializedName("fourtiesPercent")
        public int fourtiesPercent;
        @SerializedName("fiftiesPercent")
        public int fiftiesPercent;

        public int getMovieId() {
            return movieId;
        }

        public int getTotalCount() {
            return totalCount;
        }

        public int getMaleRatio() {
            return maleRatio;
        }

        public int getFemaleRatio() {
            return femaleRatio;
        }

        public int getTeenAgePercent() {
            return teenAgePercent;
        }

        public int getTwentiesPercent() {
            return twentiesPercent;
        }

        public int getThirtyPercent() {
            return thirtyPercent;
        }

        public int getFourtiesPercent() {
            return fourtiesPercent;
        }

        public int getFiftiesPercent() {
            return fiftiesPercent;
        }
    }
}
