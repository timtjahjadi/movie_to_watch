package com.uc.movie_to_watch.ui.main.tvShows;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.uc.movie_to_watch.model.TvShow;
import com.uc.movie_to_watch.repository.TvRepo;

import java.util.List;

public class TvViewModel extends ViewModel {

    private TvRepo repository;

    public TvViewModel() {
        repository = TvRepo.getInstance();
    }

    public LiveData<List<TvShow>> getTvCollection() {
        return repository.getTvCollection();
    }

}
