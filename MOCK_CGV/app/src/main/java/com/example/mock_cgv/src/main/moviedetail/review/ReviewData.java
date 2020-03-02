package com.example.mock_cgv.src.main.moviedetail.review;

public class ReviewData {
    private int id;
    private String userId;
    private int goldenEggStatus;
    private String content;
    private String DATE;

    public ReviewData(int id,String userid, int goldenEggStatus, String content, String date) {
        this.id=id;
        this.userId = userid;
        this.goldenEggStatus = goldenEggStatus;
        this.content = content;
        this.DATE = date;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public int getGoldenEggStatus() {
        return goldenEggStatus;
    }

    public void setGoldenEggStatus(int goldenEggStatus) {
        this.goldenEggStatus = goldenEggStatus;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getDATE() {
        return DATE;
    }

    public void setDATE(String DATE) {
        this.DATE = DATE;
    }
}



