package com.uc.movie_to_watch.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class TvShowResponse {

    @SerializedName("page")
    private int pages;

    @SerializedName("total_pages")
    private int total_pages;

    @SerializedName("total_results")
    private int total_results;

    @SerializedName("results")
    private List<TvShow> results;

    public int getPages() {
        return pages;
    }

    public int getTotal_pages() {
        return total_pages;
    }

    public int getTotal_results() {
        return total_results;
    }

    public List<TvShow> getResults() {
        return results;
    }
}
