package com.uc.movie_to_watch.repository;

import android.util.Log;

import androidx.lifecycle.MutableLiveData;

import com.uc.movie_to_watch.model.MovieResponse;
import com.uc.movie_to_watch.model.TvShow;
import com.uc.movie_to_watch.model.TvShowResponse;
import com.uc.movie_to_watch.network.APIendPoint;
import com.uc.movie_to_watch.network.RetrofitService;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class TvRepo {
    private static TvRepo tvRepo;
    private RetrofitService service;
    private APIendPoint apIendPoint;
    private static final String TAG = "tvRepo";

    private TvRepo() {
        service = RetrofitService.getInstance();
    }

    public static TvRepo getInstance() {
        if (tvRepo == null) {
            tvRepo = new TvRepo();
        }
        return tvRepo;
    }

    public MutableLiveData<List<TvShow>> getTvCollection() {
        MutableLiveData<List<TvShow>> listTv = new MutableLiveData<>();

        service.getTvs().enqueue(new Callback<TvShowResponse>() {
            @Override
            public void onResponse(Call<TvShowResponse> call, Response<TvShowResponse> response) {
                if (response.isSuccessful()) {
                    if (response.body() != null) {
                        listTv.postValue(response.body().getResults());
                    }
                }
            }

            @Override
            public void onFailure(Call<TvShowResponse> call, Throwable t) {
                Log.d(TAG, "onFailure: " + t.getMessage());
            }
        });

        return listTv;
    }
}
