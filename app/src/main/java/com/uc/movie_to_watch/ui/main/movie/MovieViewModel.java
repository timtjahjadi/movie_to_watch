package com.uc.movie_to_watch.ui.main.movie;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.uc.movie_to_watch.model.Movie;
import com.uc.movie_to_watch.repository.MovieRepo;

import java.util.List;

public class MovieViewModel extends ViewModel {

    private MovieRepo repository;

    public MovieViewModel() {
        repository = MovieRepo.getInstance();
    }

    public LiveData<List<Movie>> getMovieCollection() {
        return repository.getMovieCollection();
    }

}
