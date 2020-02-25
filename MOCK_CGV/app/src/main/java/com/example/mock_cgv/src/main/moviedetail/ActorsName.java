package com.example.mock_cgv.src.main.moviedetail;

public class ActorsName {

    private String mActorsName;
    private String mActorsEnName;

    public ActorsName(String actorsName,String actorsEnName) {
        this.mActorsEnName=actorsEnName;
        this.mActorsName=actorsName;
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


}

