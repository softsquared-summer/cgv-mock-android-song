package com.example.mock_cgv.src.main.home.chart.models;

import android.util.Log;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class ChartResponse {

    @SerializedName("result")
    public ArrayList<Result> result;

    @SerializedName("isSuccess")
    public boolean isSuccess;

    @SerializedName("code")
    public int code;

    @SerializedName("message")
    public String message;

    public boolean getIsSuccess() {
        return isSuccess;
    }
    public int getCode() {
        return code;
    }
    public String getMessage() {
        return message;
    }

    public ArrayList<Result> getResult() {
        return result;

    }
    public class Result{

        @SerializedName("id")
        public int id;

        @SerializedName("title")
        public String title;

        @SerializedName("viewAge")
        public int viewAge;

        @SerializedName("releaseDate")
        public String releaseDate;

        @SerializedName("thumbnail")
        public String thumbnail;

        @SerializedName("goldenEggRatio")
        public int goldenEggRatio;

        @SerializedName("ticketingRatio")
        public String ticketingRatio;

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
        public String getThumbnail() {
            return thumbnail;
        }
        public int getGoldenEggRatio() {
            return goldenEggRatio;
        }
        public String getTicketingRatio() {
            return ticketingRatio;
        }


    }

}
