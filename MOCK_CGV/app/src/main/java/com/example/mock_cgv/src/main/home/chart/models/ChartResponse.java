package com.example.mock_cgv.src.main.home.chart.models;

import com.example.mock_cgv.src.main.login.models.LogInResponse;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

import retrofit2.http.PUT;

public class ChartResponse {


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
    private ArrayList<Result> result;
    public void setResult(ArrayList<Result> result) {
        this.result = result;
    }
    public ArrayList<Result> getResult() {
        return result;
    }
    public class Result{
        @SerializedName("id") public int id;
        @SerializedName("title") public String title;
        @SerializedName("viewAge") public int viewAge;
        @SerializedName("releaseDate") public String releaseDate;
        @SerializedName("mainImg") public String mainImg;
        @SerializedName("goldenEggRatio") public int goldenEggRatio;
        @SerializedName("ticketingRatio") public int ticketingRatio;

        public int getGoldenEggRatio() {
            return goldenEggRatio;
        }

        public int getId() {
            return id;
        }

        public String getTitle() {
            return title;
        }

        public int getViewAge() {
            return viewAge;
        }

        public String getReleaseDate() {
            return releaseDate;
        }

        public String getMainImg() {
            return mainImg;
        }

        public int getTicketingRatio() {
            return ticketingRatio;
        }
    }

}
