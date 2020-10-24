package com.uc.movie_to_watch.ui.main.movie;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.navigation.NavDirections;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.uc.movie_to_watch.R;
import com.uc.movie_to_watch.adapter.ShowsAdapter;
import com.uc.movie_to_watch.model.Movie;
import com.uc.movie_to_watch.util.ItemClickSupport;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MovieFragment extends Fragment {

    @BindView(R.id.rv_shows)
    RecyclerView rv_movie;

    private MovieViewModel viewModel;
    private ShowsAdapter showsAdapter;

    public MovieFragment() {}

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_movie, container, false);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ButterKnife.bind(this, view);

        viewModel = ViewModelProviders.of(getActivity()).get(MovieViewModel.class);
        viewModel.getMovieCollection().observe(requireActivity(), observeViewModel);

        rv_movie.setLayoutManager(new LinearLayoutManager(getActivity()));
        showsAdapter = new ShowsAdapter(getActivity());
    }

    private Observer<List<Movie>> observeViewModel = new Observer<List<Movie>>() {
        @Override
        public void onChanged(List<Movie> movieList) {
            if (movieList != null) {
                showsAdapter.setList_movie(movieList);
                showsAdapter.notifyDataSetChanged();
                rv_movie.setAdapter(showsAdapter);

                ItemClickSupport.addTo(rv_movie).setOnItemClickListener(new ItemClickSupport.OnItemClickListener() {
                    @Override
                    public void onItemClicked(RecyclerView recyclerView, int position, View v) {
                        Movie movie = movieList.get(position);
                        NavDirections action = MovieFragmentDirections.actionToDetailFragment(movie, null);
                        Navigation.findNavController(v).navigate(action);
                    }
                });
            }
        }
    };

}