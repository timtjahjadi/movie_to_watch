package com.uc.movie_to_watch.network;

import com.uc.movie_to_watch.model.GenreResponse;
import com.uc.movie_to_watch.model.MovieResponse;
import com.uc.movie_to_watch.util.Constants;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitService {

    private APIendPoint api;
    private static RetrofitService service;

    private RetrofitService() {
        api = new Retrofit.Builder()
                .baseUrl(Constants.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(APIendPoint.class);
    }

    public static RetrofitService getInstance() {
        if (service == null) {
            service = new RetrofitService();
        }
        return service;
    }

    public Call<MovieResponse> getMovies() {
        return api.getMovies(Constants.API_KEY);
    }
    public Call<GenreResponse> getGenre() { return api.getGenre(Constants.API_KEY); }
}
