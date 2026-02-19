package com.example.febandroid;


import com.google.gson.annotations.SerializedName;

public class MovieItem {

    @SerializedName("#TITLE")
    private String title;

    @SerializedName("#YEAR")
    private int year;

    @SerializedName("#IMDB_ID")
    private String imdbId;

    @SerializedName("#RANK")
    private int rank;

    @SerializedName("#ACTORS")
    private String actors;

    @SerializedName("#AKA")
    private String aka;

    @SerializedName("#IMDB_URL")
    private String imdbUrl;

    @SerializedName("#IMDB_IV")
    private String imdbIv;

    @SerializedName("#IMG_POSTER")
    private String imgPoster;

    @SerializedName("photo_width")
    private int photoWidth;

    @SerializedName("photo_height")
    private int photoHeight;

    public String getTitle() {
        return title;
    }

    public int getYear() {
        return year;
    }

    public String getImdbId() {
        return imdbId;
    }

    public int getRank() {
        return rank;
    }

    public String getActors() {
        return actors;
    }

    public String getAka() {
        return aka;
    }

    public String getImdbUrl() {
        return imdbUrl;
    }

    public String getImdbIv() {
        return imdbIv;
    }

    public String getImgPoster() {
        return imgPoster;
    }

    public int getPhotoWidth() {
        return photoWidth;
    }

    public int getPhotoHeight() {
        return photoHeight;
    }
}
