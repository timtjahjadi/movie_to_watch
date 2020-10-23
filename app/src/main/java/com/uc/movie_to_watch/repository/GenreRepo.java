package com.uc.movie_to_watch.repository;

import android.util.Log;

import androidx.lifecycle.MutableLiveData;

import com.uc.movie_to_watch.model.Genre;
import com.uc.movie_to_watch.model.GenreResponse;
import com.uc.movie_to_watch.network.APIendPoint;
import com.uc.movie_to_watch.network.RetrofitService;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class GenreRepo {
    private static GenreRepo genreRepo;
    private RetrofitService service;
    private APIendPoint apIendPoint;
    private static final String TAG = "GenreRepo";

    private GenreRepo() {
        service = RetrofitService.getInstance();
    }

    public static GenreRepo getInstance() {
        if (genreRepo == null) {
            genreRepo = new GenreRepo();
        }
        return genreRepo;
    }

    public MutableLiveData<List<Genre>> getGenreList() {
        MutableLiveData<List<Genre>> listGenre = new MutableLiveData<>();

        service.getGenre().enqueue(new Callback<GenreResponse>() {
            @Override
            public void onResponse(Call<GenreResponse> call, Response<GenreResponse> response) {
                Log.d(TAG, "TES TES: " + response.code());
                if (response.isSuccessful()) {
                    if (response.body() != null) {
                        listGenre.postValue(response.body().getResults());
                    }
                }
            }

            @Override
            public void onFailure(Call<GenreResponse> call, Throwable t) {
                Log.d(TAG, "onFailure: " + t.getMessage());
            }
        });

        return listGenre;
    }
}
