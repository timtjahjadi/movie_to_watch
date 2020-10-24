package com.uc.movie_to_watch.adapter;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.uc.movie_to_watch.R;
import com.uc.movie_to_watch.model.Movie;
import com.uc.movie_to_watch.model.TvShow;
import com.uc.movie_to_watch.util.Constants;

import java.util.List;

public class TvAdapter extends RecyclerView.Adapter<TvAdapter.CardsViewHolder> {

    private Context context;
    private List<TvShow> list_tv;

    public TvAdapter(Context context) {
        this.context = context;
    }

    private List<TvShow> getList_tv() {
        return list_tv;
    }
    private static final String TAG = "TV Adapter";

    public void setList_tv(List<TvShow> list_tv) {
        this.list_tv = list_tv;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public CardsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_tv_adapter, parent, false);
        return new CardsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final TvAdapter.CardsViewHolder holder, int position) {
        final TvShow tv = getList_tv().get(position);

        //THIS CODE IS TO LOAD THE IMAGE :))))
        Glide.with(context).load(Constants.BASE_IMG_URL+tv.getCover()).into(holder.cover);
        holder.title.setText(tv.getName());

    }

    @Override
    public int getItemCount() {
        return getList_tv().size();
    }

    class CardsViewHolder extends RecyclerView.ViewHolder {
        TextView title;
        ImageView cover;

        CardsViewHolder(View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.txt_tv_name);
            cover = itemView.findViewById(R.id.img_tv_cover);
        }
    }
}