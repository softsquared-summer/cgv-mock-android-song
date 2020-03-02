package com.example.mock_cgv.src.main.moviedetail.models;

import com.google.gson.annotations.SerializedName;

import java.lang.reflect.Array;
import java.util.ArrayList;

import retrofit2.http.PUT;

public class MovieDetailResponse {

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
        @SerializedName("title")
        public String title;
        public String getTitle(){
            return title;
        }

        @SerializedName("titleEn")
        public String titleEn;
        public String getTitleEn(){return titleEn;}

        @SerializedName("viewAge")
        public int viewAge;
        public int getViewAge(){return viewAge;}

        @SerializedName("date")
        public String date;
        public String getReleaseDate(){return date;}

        @SerializedName("runningTime")
        public int runningTime;
        public int getRunningTime(){return runningTime;}

        @SerializedName("director")
        public String director;
        public String getDirector(){return director;}

        @SerializedName("directorImg")
        public String directorImg;
        public String getDirectorImg(){return directorImg;}

        @SerializedName("directorEnName")
        public String directorEnName;
        public String getDirectorEnName(){return directorEnName;}

        @SerializedName("description")
        public String description;
        public String getDescription(){return description;}

        @SerializedName("genre")
        public String genre;
        public String getGenre(){return genre;}

        @SerializedName("thumbnail")
        public String thumbnail;
        public String getThumbnail(){return thumbnail;}

        @SerializedName("subImg")
        public String subImg;
        public String getSubImg(){return subImg;}

        @SerializedName("video")
        public String video;
        public String getVideo(){return video;}

        @SerializedName("goldenEggRatio")
        public int goldenEggRatio;
        public int getGoldenEggRatio(){return goldenEggRatio;}

        @SerializedName("ticketingRatio")
        public String ticketingRatio;
        public String getTicketingRatio(){return ticketingRatio;}

        @SerializedName("actors")
        private ArrayList<Actors> actors;
        public void setActors(ArrayList<Actors> actors){
            this.actors=actors;
        }
        public ArrayList<Actors> getActors(){
            return actors;
        }
        public class Actors{

            @SerializedName("actorsName")
            public String actorsName;
            public String getActorsName(){return actorsName;}

            @SerializedName("actorsEnName")
            public String actorsEnName;
            public String getActorsEnName(){return actorsEnName;}

            @SerializedName("actorsImg")
            public String actorsImg;
            public String getActorsImg(){return actorsImg;}
        }

    }
}
