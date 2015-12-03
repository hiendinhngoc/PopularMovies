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
public class Trailer {

    private String id;
    private String key;
    private String name;
    private String site;
    private String type;

    public Trailer() {

    }

    public Trailer(JSONObject trailer) throws JSONException{
        this.id = trailer.getString("id");
        this.key = trailer.getString("key");
        this.name = trailer.getString("name");
        this.site = trailer.getString("site");
        this.type = trailer.getString("type");
    }

    public String getId() {
        return id;
    }

    public String getKey() {
        return key;
    }

    public String getName() {
        return name;
    }

    public String getSite() {
        return site;
    }

    public String getType() {
        return type;
    }
}
