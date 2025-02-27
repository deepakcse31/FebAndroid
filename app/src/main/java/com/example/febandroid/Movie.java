package com.example.febandroid;

import java.util.ArrayList;
import java.util.List;

public class Movie {
    private List<Search> Search = new ArrayList<Search>();
    private String totalResults;
    private String response;

    public List<com.example.febandroid.Search> getSearch() {
        return Search;
    }

    public void setSearch(List<com.example.febandroid.Search> search) {
        Search = search;
    }

    public String getTotalResults() {
        return totalResults;
    }

    public void setTotalResults(String totalResults) {
        this.totalResults = totalResults;
    }

    public String getResponse() {
        return response;
    }

    public void setResponse(String response) {
        this.response = response;
    }
}
