package com.uc.movie_to_watch.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class TvShow implements Parcelable {

    @SerializedName("popularity")
    private String popularity;

    @SerializedName("backdrop_path")
    private String cover;

    @SerializedName("name")
    private String name;

    @SerializedName("overview")
    private String overview;

    @SerializedName("genre_ids")
    private List<Integer> genre_ids;

    public TvShow(){}

    public TvShow(String popularity, String cover, String name, String overview, List<Integer> genre_ids) {
        this.popularity = popularity;
        this.cover = cover;
        this.name = name;
        this.overview = overview;
        this.genre_ids = genre_ids;
    }

    protected TvShow(Parcel in) {
        popularity = in.readString();
        cover = in.readString();
        name = in.readString();
        overview = in.readString();
    }

    public static final Creator<TvShow> CREATOR = new Creator<TvShow>() {
        @Override
        public TvShow createFromParcel(Parcel in) {
            return new TvShow(in);
        }

        @Override
        public TvShow[] newArray(int size) {
            return new TvShow[size];
        }
    };

    public String getPopularity() {
        return popularity;
    }

    public String getCover() {
        return cover;
    }

    public String getName() {
        return name;
    }

    public String getOverview() {
        return overview;
    }

    public List<Integer> getGenre_ids() {
        return genre_ids;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(popularity);
        dest.writeString(cover);
        dest.writeString(name);
        dest.writeString(overview);
    }
}
