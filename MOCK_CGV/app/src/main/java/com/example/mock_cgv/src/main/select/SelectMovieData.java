package com.example.mock_cgv.src.main.select;

public class SelectMovieData {
    private String Thumbnail;
    private String Title;
    private int id;

    public SelectMovieData(String Thumbnail,String title,int id){
        this.Thumbnail=Thumbnail;
        this.Title=title;
        this.id=id;
    }

    public void setThumbnail(String mainImg){
        this.Thumbnail=mainImg;
    }
    public String getThumbnail(){
        return Thumbnail;
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
