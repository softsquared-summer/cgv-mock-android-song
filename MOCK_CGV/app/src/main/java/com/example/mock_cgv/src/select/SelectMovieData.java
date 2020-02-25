package com.example.mock_cgv.src.select;

public class SelectMovieData {
    private String MainImg;
    private String Title;
    private int id;

    public SelectMovieData(String MainImg,String title,int id){
        this.MainImg=MainImg;
        this.Title=title;
        this.id=id;
    }

    public void setMainImg(String mainImg){
        this.MainImg=mainImg;
    }
    public String getMainImg(){
        return MainImg;
    }

    public void setTitle(String title){
        this.Title=title;
    }
    public String getTitle(){
        return Title;
    }

    public void setId(int id){this.id=id;}
    public int getId(){return id;}
}
