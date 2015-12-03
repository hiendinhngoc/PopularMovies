package com.example.android.popularmovies.adapter;

import android.content.Context;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.android.popularmovies.R;
import com.example.android.popularmovies.model.Review;

import org.w3c.dom.Text;

import java.util.List;

/**
 * Copyright (c) 2014 Pendulab Inc.
 * 111 N Chestnut St, Suite 200, Winston Salem, NC, 27101, U.S.A.
 * All rights reserved.
 * <p/>
 * This software is the confidential and proprietary information of
 * Pendulab Inc. ("Confidential Information"). You shall not disclose such
 * Confidential Information and shall use it only in accordance with the terms
 * of the license agreement you entered into with Pendulab.
 * Created by Vu Trong Hoa on 1/12/2015.
 */
public class ReviewAdapter extends BaseAdapter {

    private final Context mContext;
    private final LayoutInflater mInflate;
    private final Review mLock = new Review();

    private List<Review> mObjects;

    public ReviewAdapter(Context context, List<Review> objects){
        mContext = context;
        mInflate = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        mObjects = objects;
    }

    public Context getContext(){
        return mContext;
    }

    public void add(Review object){
        synchronized (mLock){
            mObjects.add(object);
        }
        notifyDataSetChanged();
    }

    public void clear(){
        synchronized (mLock) {
            mObjects.clear();
        }
        notifyDataSetChanged();
    }

    @Override
    public int getCount(){
        return mObjects.size();
    }

    @Override
    public Review getItem(int position){
        return mObjects.get(position);
    }

    @Override
    public long getItemId(int position){
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent){
        View view = convertView;
        ViewHolder viewHolder;

        if (view == null){
            view = mInflate.inflate(R.layout.item_movie_review, parent, false);
            viewHolder = new ViewHolder(view);
            view.setTag(viewHolder);
        }

        final Review review = getItem(position);

        viewHolder = (ViewHolder) view.getTag();

        viewHolder.authorView.setText(review.getAuthor());
        viewHolder.contentView.setText(Html.fromHtml(review.getContent()));

        return view;
    }

    public static class ViewHolder{
        public final TextView authorView;
        public final TextView contentView;

        public ViewHolder(View view) {
            authorView = (TextView) view.findViewById(R.id.review_author);
            contentView = (TextView) view.findViewById(R.id.review_author);
        }
    }

}
