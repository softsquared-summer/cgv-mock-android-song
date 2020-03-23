package com.example.mock_cgv.src.main.ticketing.models;


import com.google.gson.annotations.SerializedName;

public class TicketDetailResponse {

    @SerializedName("result")
    public Result result;

    public Result getResult() {
        return result;
    }

    public class Result {
        @SerializedName("id")
        public String id;
        //getter
        @SerializedName("theaterName")
        public String theaterName;

        @SerializedName("roomId")
        public String roomId;

        @SerializedName("floor")
        public String floor;

        @SerializedName("totalSeat")
        public String totalSeat;

        @SerializedName("seatCount")
        public String seatCount;
        @SerializedName("startTime")
        public String startTime;
        @SerializedName("endTime")
        public String endTime;
        @SerializedName("description")
        public String description;
        @SerializedName("date")
        public String date;

        @SerializedName("week")
        public String week;

        public String getId() {
            return id;
        }

        public String getTheaterName() {
            return theaterName;
        }

        public String getRoomId() {
            return roomId;
        }

        public String getFloor() {
            return floor;
        }

        public String getTotalSeat() {
            return totalSeat;
        }

        public String getSeatCount() {
            return seatCount;
        }

        public String getStartTime() {
            return startTime;
        }

        public String getEndTime() {
            return endTime;
        }

        public String getDescription() {
            return description;
        }

        public String getDate() {
            return date;
        }

        public String getWeek() {
            return week;
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
