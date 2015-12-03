package com.example.android.popularmovies;

import android.content.Context;
import android.database.Cursor;
import android.support.v4.app.INotificationSideChannel;
import android.util.Log;

import com.example.android.popularmovies.data.MoviesData;
import com.example.android.popularmovies.model.Movie;

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
public class Utility {
    public static final String TAG = Utility.class.getSimpleName();

    public static int isFavorited(Context context, int id){
        int numRows = 0;
        Cursor cursor = context.getContentResolver().query(
                MoviesData.MovieEntry.CONTENT_URI,
                null,
                MoviesData.MovieEntry.COLUMN_MOVIE_ID + " = ?",
                new String[] { Integer.toString(id)},
                null
        );
        if (cursor != null && cursor.moveToFirst()){
            do {
                numRows = cursor.getCount();
            }while (cursor.moveToNext());
            cursor.close();
        }
        return numRows;
    }

    public static String buildImageUrl(int width, String fileName){
        return "http://image.tmdb.org/t/p/w" + Integer.toString(width) + fileName;
    }
}
