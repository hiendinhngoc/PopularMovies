package com.example.android.popularmovies.model;

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
 * Created by Vu Trong Hoa on 1/12/2015.
 */
public class Review {

    private String id;
    private String author;

    private String content;

    public Review(){

    }

    public Review(JSONObject trailer) throws JSONException{
        this.id = trailer.getString("id");
        this.author = trailer.getString("author");
        this.content = trailer.getString("content");
    }

    public String getContent() {
        return content;
    }

    public String getAuthor() {
        return author;
    }

    public String getId() {
        return id;
    }
}
