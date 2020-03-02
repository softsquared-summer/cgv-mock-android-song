package com.example.mock_cgv.src.ticketing.models;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class TicketingResponse {
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
        @SerializedName("title") public String title;
        @SerializedName("viewAge") public String viewAge;
        @SerializedName("runningTime") public String runningTime;
        @SerializedName("thumbnail") public String thumbnail;
        @SerializedName("date") public String date;
        @SerializedName("week") public String week;
        public String getTitle(){
            return title;
        }
        public String getViewAge(){
            return viewAge;
        }
        public String getRunningTime(){
            return runningTime;
        }
        public String getThumbnail(){
            return thumbnail;
        }
        public String getDate(){
            return date;
        }
        public String getWeek(){
            return week;
        }

        @SerializedName("theaters")
        public ArrayList<Theaters> theaters;
        public ArrayList<Theaters> getTheaters(){
            return theaters;
        }
        public class Theaters{
            @SerializedName("theaterRoomId") public String theaterRoomId;
            @SerializedName("theaterId") public String theaterId;
            @SerializedName("theaterName") public String theaterName;
            @SerializedName("floor") public String floor;
            @SerializedName("roomId") public String roomId;

            public String getTheaterRoomId(){
                return theaterRoomId;
            }
            public String getTheaterId(){
                return theaterId;
            }
            public String getTheaterName(){
                return theaterName;
            }
            public String getFloor(){
                return floor;
            }
            public String getRoomId(){
                return roomId;
            }


        }

    }

}
