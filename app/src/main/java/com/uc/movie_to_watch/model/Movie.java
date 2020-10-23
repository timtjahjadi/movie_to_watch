package com.uc.movie_to_watch.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Movie implements Parcelable {

    @SerializedName("popularity")
    private String popularity;

    @SerializedName("poster_path")
    private String poster;

    @SerializedName("backdrop_path")
    private String cover;

    @SerializedName("title")
    private String title;

    @SerializedName("overview")
    private String overview;

    @SerializedName("release_date")
    private String released_date;

    @SerializedName("genre_ids")
    private List<Integer> genre_ids;

    public Movie() {

    }

    public Movie(String popularity, String poster, String cover, String title, String overview, String released_date, List<Integer> genre_ids) {
        this.popularity = popularity;
        this.poster = poster;
        this.cover = cover;
        this.title = title;
        this.overview = overview;
        this.released_date = released_date;
        this.genre_ids = genre_ids;
    }

    protected Movie(Parcel in) {
        popularity = in.readString();
        poster = in.readString();
        cover = in.readString();
        title = in.readString();
        overview = in.readString();
        released_date = in.readString();
    }

    public static final Creator<Movie> CREATOR = new Creator<Movie>() {
        @Override
        public Movie createFromParcel(Parcel in) {
            return new Movie(in);
        }

        @Override
        public Movie[] newArray(int size) {
            return new Movie[size];
        }
    };

    public String getPopularity() {
        return popularity;
    }

    public String getPoster() {
        return poster;
    }

    public String getCover() {
        return cover;
    }

    public String getTitle() {
        return title;
    }

    public String getOverview() {
        return overview;
    }

    public String getReleased_date() {
        return released_date;
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
        dest.writeString(poster);
        dest.writeString(cover);
        dest.writeString(title);
        dest.writeString(overview);
        dest.writeString(released_date);
    }
}
