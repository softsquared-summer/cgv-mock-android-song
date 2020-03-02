package com.example.mock_cgv.src.ticketing.models;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class TicketingSecondResponse {

    @SerializedName("result")
    public Result result;
    public Result getResult(){
        return result;
    }
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

    public class Result{
        @SerializedName("theaterId")
        private String theaterId;
        @SerializedName("theaterName")
        private String theaterName;
        @SerializedName("date")
        private String date;
        @SerializedName("time")
        private ArrayList<Time> time;

        public String getTheaterId() {
            return theaterId;
        }

        public String getTheaterName() {
            return theaterName;
        }

        public String getDate() {
            return date;
        }

        public ArrayList<Time> getTime() {
            return time;
        }

        public class Time{
            @SerializedName("uniqueMovieTImeId")
            private String uniqueMovieTimeId;

            @SerializedName("uniqueRoomId")
            private String uniqueRoomId;

            @SerializedName("startTime")
            private String startTime;

            @SerializedName("endTime")
            private String endTime;

            @SerializedName("seatCount")
            private String seatCount;

            @SerializedName("totalSeat")
            private String totalSeat;

            public String getUniqueMovieTimeId() {
                return uniqueMovieTimeId;
            }

            public String getUniqueRoomId() {
                return uniqueRoomId;
            }

            public String getStartTime() {
                return startTime;
            }

            public String getEndTime() {
                return endTime;
            }

            public String getSeatCount() {
                return seatCount;
            }

            public String getTotalSeat() {
                return totalSeat;
            }
        }
    }



}
