package com.example.febandroid;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class MovieResponse {
    @SerializedName("ok")
    private boolean ok;

    @SerializedName("description")
    private List<MovieItem> description;

    @SerializedName("error_code")
    private int errorCode;

    public boolean isOk() {
        return ok;
    }

    public List<MovieItem> getDescription() {
        return description;
    }

    public int getErrorCode() {
        return errorCode;
    }
}
