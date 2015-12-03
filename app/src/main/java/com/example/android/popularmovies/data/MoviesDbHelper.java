package com.example.android.popularmovies.data;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Copyright (c) 2014 Pendulab Inc.
 * 111 N Chestnut St, Suite 200, Winston Salem, NC, 27101, U.S.A.
 * All rights reserved.
 * <p>
 * This software is the confidential and proprietary information of
 * Pendulab Inc. ("Confidential Information"). You shall not disclose such
 * Confidential Information and shall use it only in accordance with the terms
 * of the license agreement you entered into with Pendulab.
 * Created by Vu Trong Hoa on 20/11/2015.
 */
public class MoviesDbHelper extends SQLiteOpenHelper{

    private static final int DATABASE_VERSION = 2;

    static final String DATABASE_NAME = "movie.db";

    public MoviesDbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        final String SQL_CREATE_MOVIE_TABLE = "CREATE TABLE " + MoviesData.MovieEntry.TABLE_NAME + " (" +
                MoviesData.MovieEntry._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                MoviesData.MovieEntry.COLUMN_MOVIE_ID + " INTEGER NOT NULL, "+
                MoviesData.MovieEntry.COLUMN_TITLE + " TEXT NOT NULL, " +
                MoviesData.MovieEntry.COLUMN_IMAGE + " TEXT, " +
                MoviesData.MovieEntry.COLUMN_IMAGE2 + " TEXT, " +
                MoviesData.MovieEntry.COLUMN_DATE + " TEXT, " +
                MoviesData.MovieEntry.COLUMN_RATE + " INTEGER, "+
                MoviesData.MovieEntry.COLUMN_DESC + " TEXT);";
        sqLiteDatabase.execSQL(SQL_CREATE_MOVIE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int oldVersion, int newVersion) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + MoviesData.MovieEntry.TABLE_NAME);
        onCreate(sqLiteDatabase);
    }
}
