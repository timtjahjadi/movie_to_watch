package com.uc.movie_to_watch.adapter;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.uc.movie_to_watch.R;
import com.uc.movie_to_watch.model.Movie;
import com.uc.movie_to_watch.ui.main.movie.MovieFragment;
import com.uc.movie_to_watch.util.Constants;

import java.util.List;

public class ShowsAdapter extends RecyclerView.Adapter<ShowsAdapter.CardViewHolder> {

    private Context context;
    private List<Movie> list_movie;

    public ShowsAdapter(Context context) {
        this.context = context;
    }

    private List<Movie> getList_movie() {
        return list_movie;
    }

    public void setList_movie(List<Movie> list_movie) {
        this.list_movie = list_movie;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public CardViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_shows_adapter, parent, false);
        return new CardViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final ShowsAdapter.CardViewHolder holder, int position) {
        final Movie movie = getList_movie().get(position);

        //THIS CODE IS TO LOAD THE IMAGE :))))
        Glide.with(context).load(Constants.BASE_IMG_URL+movie.getCover()).into(holder.cover);
        holder.title.setText(movie.getTitle());
    }

    @Override
    public int getItemCount() {
        return getList_movie().size();
    }

    class CardViewHolder extends RecyclerView.ViewHolder {
        TextView title;
        ImageView cover;

        CardViewHolder(View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.lbl_adapter_show_title);
            cover = itemView.findViewById(R.id.img_showsCover);
        }
    }
}