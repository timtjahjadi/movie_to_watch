package com.uc.movie_to_watch.ui.main.detail;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.navigation.NavDirections;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.uc.movie_to_watch.R;
import com.uc.movie_to_watch.model.Genre;
import com.uc.movie_to_watch.model.Movie;
import com.uc.movie_to_watch.model.TvShow;
import com.uc.movie_to_watch.ui.main.movie.MovieFragmentDirections;
import com.uc.movie_to_watch.ui.main.movie.MovieViewModel;
import com.uc.movie_to_watch.util.Constants;
import com.uc.movie_to_watch.util.ItemClickSupport;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class DetailFragment extends Fragment {

    @BindView(R.id.img_detailCover)
    ImageView cover;

    @BindView(R.id.lbl_title)
    TextView title;

    @BindView(R.id.lbl_genre)
    TextView genre;

    @BindView(R.id.lbl_desc)
    TextView desc;

    private Movie movie;
    private TvShow tvShow;

    private DetailViewModel detailViewModel;
    private List<Genre> genreFetchList;
    private String genreName = "";
    private static final String TAG = "DetailFrag";
    public DetailFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_detail, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ButterKnife.bind(this, view);

        detailViewModel = ViewModelProviders.of(getActivity()).get(DetailViewModel.class);

        movie = DetailFragmentArgs.fromBundle(getArguments()).getMovie();

        movie = DetailFragmentArgs.fromBundle(getArguments()).getMovie();
        tvShow = DetailFragmentArgs.fromBundle(getArguments()).getTvShow();

        if (movie != null) {
            detailViewModel.getGenreList().observe(requireActivity(), observeViewModel);
            Glide.with(getActivity()).load(Constants.BASE_IMG_URL + movie.getCover()).into(cover);
            title.setText(movie.getTitle());
            desc.setText(movie.getOverview());
        } else {
            detailViewModel.getGenreTvList().observe(requireActivity(), observeViewModel);
            Glide.with(getActivity()).load(Constants.BASE_IMG_URL + tvShow.getCover()).into(cover);
            title.setText(tvShow.getName());
            desc.setText(tvShow.getOverview());
        }
    }

    private Observer<List<Genre>> observeViewModel = new Observer<List<Genre>>() {
        @Override
        public void onChanged(List<Genre> genresList) {
            genreFetchList = genresList;
            Log.d(TAG, "TES TES: " + genreFetchList);
            getGenreName();
            genre.setText(genreName);
        }
    };

    public void getGenreName() {
        if (genreFetchList != null) {
            if (movie != null) {
                for (int i = 0; i < movie.getGenre_ids().size(); i++) {
                    for (int j = 0; j < genreFetchList.size(); j++) {
                        Genre genreObj = genreFetchList.get(j);
                        if (genreObj.getId() == movie.getGenre_ids().get(i)) {
                            if (i < movie.getGenre_ids().size() - 1) {
                                genreName += genreFetchList.get(j).getName() + ", ";
                            } else {
                                genreName += genreFetchList.get(j).getName();
                            }
                        }
                    }
                }
            } else {
                for (int i = 0; i < tvShow.getGenre_ids().size(); i++) {
                    for (int j = 0; j < genreFetchList.size(); j++) {
                        Genre genreObj = genreFetchList.get(j);
                        if (genreObj.getId() == tvShow.getGenre_ids().get(i)) {
                            genreName += genreFetchList.get(j).getName();
                        }
                    }
                }
            }
        }
    }
}