package com.example.android.popularmovies.model;

import android.database.Cursor;
import android.os.Parcel;
import android.os.Parcelable;

import com.example.android.popularmovies.MainActivityFragment;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Copyright (c) 2014 Pendulab Inc.
 * 111 N Chestnut St, Suite 200, Winston Salem, NC, 27101, U.S.A.
 * All rights reserved.
 * <p/>
 * This software is the confidential and proprietary information of
 * Pendulab Inc. ("Confidential Information"). You shall not disclose such
 * Confidential Information and shall use it only in accordance with the terms
 * of the license agreement you entered into with Pendulab.
 * Created by Vu Trong Hoa on 25/11/2015.
 */
public class Movie implements Parcelable {

    private int id;
    private String title;
    private String image;
    private String image2;
    private int rate;
    private String date;
    private String description;

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getImage() {
        return image;
    }
    public String getImage2() {
        return image2;
    }

    public int getRate() {
        return rate;
    }

    public String getDate() {
        return date;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public Movie(JSONObject movie) throws JSONException{
        this.id = movie.getInt("id");
        this.title = movie.getString("original_title");
        this.image = movie.getString("poster_path");
        this.image2 = movie.getString("backdrop_path");
        this.description = movie.getString("overview");
        this.date = movie.getString("release_date");
        this.rate = movie.getInt("vote_average");
    }

    public Movie(Cursor cursor){
        this.id = cursor.getInt(MainActivityFragment.COL_MOVIE_ID);
        this.title = cursor.getString(MainActivityFragment.COL_TITLE);
        this.image = cursor.getString(MainActivityFragment.COL_IMAGE);
        this.image2 = cursor.getString(MainActivityFragment.COL_IMAGE2);
        this.description = cursor.getString(MainActivityFragment.COL_DESC);
        this.date = cursor.getString(MainActivityFragment.COL_DATE);
        this.rate = cursor.getInt(MainActivityFragment.COL_RATE);
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(id);
        dest.writeString(title);
        dest.writeString(image);
        dest.writeString(image2);
        dest.writeString(date);
        dest.writeInt(rate);
        dest.writeString(description);
    }

    public Movie() {
    }

    protected Movie(Parcel in) {
        id = in.readInt();
        title = in.readString();
        image = in.readString();
        image2 = in.readString();
        date = in.readString();
        rate = in.readInt();
        description = in.readString();
    }

    public static final Parcelable.Creator<Movie> CREATOR = new Parcelable.Creator<Movie>() {
        public Movie createFromParcel(Parcel source) {
            return new Movie(source);
        }

        public Movie[] newArray(int size) {
            return new Movie[size];
        }
    };
}
