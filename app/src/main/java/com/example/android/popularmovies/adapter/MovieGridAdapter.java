package com.example.android.popularmovies.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.android.popularmovies.R;
import com.example.android.popularmovies.model.Movie;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Copyright (c) 2014 Pendulab Inc.
 * 111 N Chestnut St, Suite 200, Winston Salem, NC, 27101, U.S.A.
 * All rights reserved.
 * <p>
 * This software is the confidential and proprietary information of
 * Pendulab Inc. ("Confidential Information"). You shall not disclose such
 * Confidential Information and shall use it only in accordance with the terms
 * of the license agreement you entered into with Pendulab.
 * Created by Vu Trong Hoa on 25/11/2015.
 */
public class MovieGridAdapter extends BaseAdapter {

    private final Context mContext;
    private final LayoutInflater mInflater;

    private final Movie mLock = new Movie();

    private List<Movie> mObjects;

    public MovieGridAdapter(Context context, List<Movie> objects){
        mContext = context;
        mInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        mObjects = objects;
    }

    public Context getContext(){
        return mContext;
    }

    public void add(Movie object){
        synchronized (mLock){
            mObjects.add(object);
        }
        notifyDataSetChanged();
    }

    public void clear(){
        synchronized (mLock){
            mObjects.clear();
        }
        notifyDataSetChanged();
    }

    public void setData(List<Movie> data){
        clear();
        for (Movie movie : data){
            add(movie);
        }
    }

    @Override
    public int getCount(){
        return mObjects.size();
    }

    @Override
    public Movie getItem(int position){
        return mObjects.get(position);
    }

    @Override
    public long getItemId(int position){
        return position;
    }

    @Override
    public View getView(int position, View converView, ViewGroup parent){
        View view = converView;
        ViewHolder viewHolder;

        if (view == null){
            view = mInflater.inflate(R.layout.grid_item_movie, parent, false);
            viewHolder = new ViewHolder(view);
            view.setTag(viewHolder);
        }

        final Movie movie = getItem(position);

        String image_url = "http://image.tmdb.org/t/p/w185" + movie.getImage();

        viewHolder = (ViewHolder) view.getTag();

        Picasso.with(getContext()).load(image_url).into(viewHolder.imageView);
        viewHolder.titleView.setText(movie.getTitle());

        return view;
    }

    public static class ViewHolder{
        public final ImageView imageView;
        public final TextView titleView;

        public ViewHolder(View view){
            imageView = (ImageView) view.findViewById(R.id.grid_item_image);
            titleView = (TextView) view.findViewById(R.id.grid_item_title);
        }
    }
}
