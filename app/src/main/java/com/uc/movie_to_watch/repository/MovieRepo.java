package com.uc.movie_to_watch.repository;

import android.util.Log;

import androidx.lifecycle.MutableLiveData;

import com.uc.movie_to_watch.model.Movie;
import com.uc.movie_to_watch.model.MovieResponse;
import com.uc.movie_to_watch.network.APIendPoint;
import com.uc.movie_to_watch.network.RetrofitService;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MovieRepo {
    private static MovieRepo movieRepo;
    private RetrofitService service;
    private APIendPoint apIendPoint;
    private static final String TAG = "MovieRepo";

    private MovieRepo() {
        service = RetrofitService.getInstance();
    }

    public static MovieRepo getInstance() {
        if (movieRepo == null) {
            movieRepo = new MovieRepo();
        }
        return movieRepo;
    }

    public MutableLiveData<List<Movie>> getMovieCollection() {
        MutableLiveData<List<Movie>> listMovie = new MutableLiveData<>();

        service.getMovies().enqueue(new Callback<MovieResponse>() {
            @Override
            public void onResponse(Call<MovieResponse> call, Response<MovieResponse> response) {
                Log.d(TAG, "TES TES: " + response.code());
                if (response.isSuccessful()) {
                    if (response.body() != null) {
                        listMovie.postValue(response.body().getResults());
                    }
                }
            }

            @Override
            public void onFailure(Call<MovieResponse> call, Throwable t) {
                Log.d(TAG, "onFailure: " + t.getMessage());
            }
        });

        return listMovie;
    }
}
