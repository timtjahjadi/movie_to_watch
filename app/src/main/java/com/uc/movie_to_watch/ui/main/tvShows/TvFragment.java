package com.uc.movie_to_watch.ui.main.tvShows;

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

import com.uc.movie_to_watch.R;
import com.uc.movie_to_watch.adapter.ShowsAdapter;
import com.uc.movie_to_watch.adapter.TvAdapter;
import com.uc.movie_to_watch.model.Movie;
import com.uc.movie_to_watch.model.TvShow;
import com.uc.movie_to_watch.ui.main.movie.MovieFragmentDirections;
import com.uc.movie_to_watch.ui.main.movie.MovieViewModel;
import com.uc.movie_to_watch.util.ItemClickSupport;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class TvFragment extends Fragment {

    @BindView(R.id.rv_tv)
    RecyclerView rv_tvs;

    private TvViewModel tvViewModel;
    private TvAdapter adapter;

    public TvFragment() {}

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_tv, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ButterKnife.bind(this, view);

        tvViewModel = ViewModelProviders.of(getActivity()).get(TvViewModel.class);
        tvViewModel.getTvCollection().observe(requireActivity(), observer);

        rv_tvs.setLayoutManager(new LinearLayoutManager(getActivity()));
        adapter = new TvAdapter(getActivity());
    }

    private Observer<List<TvShow>> observer = new Observer<List<TvShow>>() {
        @Override
        public void onChanged(List<TvShow> tvShows) {
            if (tvShows != null) {
                adapter.setList_tv(tvShows);
                adapter.notifyDataSetChanged();
                rv_tvs.setAdapter(adapter);

                ItemClickSupport.addTo(rv_tvs).setOnItemClickListener(new ItemClickSupport.OnItemClickListener() {
                    @Override
                    public void onItemClicked(RecyclerView recyclerView, int position, View v) {
                        TvShow tvShow = tvShows.get(position);
                        NavDirections action = TvFragmentDirections.actionTvFragmentToDetailFragment(null, tvShow);
                        Navigation.findNavController(v).navigate(action);
                    }
                });
            }
        }
    };
}