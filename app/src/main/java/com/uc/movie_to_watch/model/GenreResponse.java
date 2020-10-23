package com.uc.movie_to_watch.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class GenreResponse {

    @SerializedName("genres")
    private List<Genre> genreResult;

    public List<Genre> getResults() {
        return genreResult;
    }

}
