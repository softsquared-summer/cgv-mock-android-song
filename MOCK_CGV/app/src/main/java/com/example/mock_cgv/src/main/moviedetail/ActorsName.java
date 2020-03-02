package com.example.mock_cgv.src.main.moviedetail;

public class ActorsName {

    private String mActorsName;
    private String mActorsEnName;
    private String mActorsImg;

    public ActorsName(String actorsName,String actorsEnName,String actorsimg) {
        this.mActorsEnName=actorsEnName;
        this.mActorsName=actorsName;
        this.mActorsImg=actorsimg;
    }

    public void setmActorsName(String actorsName){
        this.mActorsName = actorsName;
    }

    public String getmActorsName() {
        return mActorsName;
    }

    public void setmActorsEnName(String actorsEnName){
        this.mActorsEnName=actorsEnName;
    }

    public String getmActorsEnName(){
        return mActorsEnName;
    }
    public void setmActorsImg(String actorsImg){
        this.mActorsImg=actorsImg;
    }
    public String getmActorsImg(){
        return mActorsImg;
    }
}

