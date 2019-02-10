package com.example.rawanalsh.warba_test_v0;

public class New {
    private String title;
    private String author;
    private String date;
    private String imgUrl;



    public New(String title, String author, String date, String imgUrl) {
        this.title = title;
        this.author = author;
        this.date = date;
        this.imgUrl = imgUrl;

    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
