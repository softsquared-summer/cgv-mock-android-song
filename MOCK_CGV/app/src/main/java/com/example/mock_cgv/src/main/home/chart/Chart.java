package com.example.mock_cgv.src.main.home.chart;


public class Chart {
    private int id;
    private String title;
    private int viewAge;
    private String releaseDate;
    private String ImgUrl;
    private int goldenEggRatio;
    private String ticketingRatio;
    private int rnum;

    public Chart(int id, String title, int viewAge, String releaseDate, String imgUrl, int goldenEggRatio, String ticketingRatio,int rnum) {
        this.id = id;
        this.title = title;
        this.viewAge = viewAge;
        this.releaseDate = releaseDate;
        this.ImgUrl = imgUrl;
        this.goldenEggRatio = goldenEggRatio;
        this.ticketingRatio = ticketingRatio;
        this.rnum=rnum;
    }

    public int getRnum() {
        return rnum;
    }

    public void setRnum(int rnum) {
        this.rnum = rnum;
    }

    public void setGoldenEggRatio(int goldenEggRatio) {
        this.goldenEggRatio = goldenEggRatio;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setViewAge(int viewAge) {
        this.viewAge = viewAge;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    public void setImgUrl(String imgUrl) {
        ImgUrl = imgUrl;
    }

    public void setTicketingRatio(String ticketingRatio) {
        this.ticketingRatio = ticketingRatio;
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


    public String getImgUrl() {
        return ImgUrl;
    }


    public int getGoldenEggRatio() {
        return goldenEggRatio;
    }

    public String getTicketingRatio() {
        return ticketingRatio;
    }

}
