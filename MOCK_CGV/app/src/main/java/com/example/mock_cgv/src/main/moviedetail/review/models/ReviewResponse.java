package com.example.mock_cgv.src.main.moviedetail.review.models;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class ReviewResponse {


    @SerializedName("result")
    public Result result;

    public Result getResult() {
        return result;
    }

    public class Result{

        @SerializedName("review")
        public ArrayList<Review> reviews;
        public ArrayList<Review> getReviews() {
            return reviews;
        }
        public class Review{
            @SerializedName("id")
            public int id;
            @SerializedName("userId")
            public String userId;
            @SerializedName("goldenEggStatus")
            public int goldenEggStatus;
            @SerializedName("content")
            public String content;
            @SerializedName("DATE")
            public String DATE;

            public int getId() {
                return id;
            }

            public String getUserId() {
                return userId;
            }

            public int getGoldenEggStatus() {
                return goldenEggStatus;
            }

            public String getContent() {
                return content;
            }

            public String getDATE() {
                return DATE;
            }
        }
        @SerializedName("reviewCount")
        public int reviewCount;

        public int getReviewCount() {
            return reviewCount;
        }
    }


    @SerializedName("isSuccess")
    public boolean isSuccess;

    @SerializedName("code")
    public int code;

    @SerializedName("message")
    public String message;

    public boolean isSuccess() {
        return isSuccess;
    }

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }


}
