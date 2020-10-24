package com.uc.movie_to_watch.network;

import com.uc.movie_to_watch.model.GenreResponse;
import com.uc.movie_to_watch.model.MovieResponse;
import com.uc.movie_to_watch.model.TvShowResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface APIendPoint {
    @GET("discover/movie")
    Call<MovieResponse> getMovies(@Query("api_key") String apiKey);

    @GET("genre/movie/list")
    Call<GenreResponse> getGenre(@Query("api_key") String apiKey);

    @GET("genre/tv/list")
    Call<GenreResponse> getGenreTv(@Query("api_key") String apiKey);

    @GET("discover/tv")
    Call<TvShowResponse> getTvs(@Query("api_key") String apiKey);
}
