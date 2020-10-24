package com.uc.movie_to_watch.ui.main.detail;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.uc.movie_to_watch.model.Genre;
import com.uc.movie_to_watch.repository.GenreRepo;

import java.util.List;

public class DetailViewModel extends ViewModel {

    private GenreRepo genreRepo;

    public DetailViewModel() { genreRepo = GenreRepo.getInstance(); }

    public LiveData<List<Genre>> getGenreList() {
        return genreRepo.getGenreList();
    }

    public LiveData<List<Genre>> getGenreTvList() {
        return genreRepo.getGenreTvList();
    }
}
