package com.app.travel.models.additionaldata;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public abstract class AdditionalData {
    public String toJson(){
        GsonBuilder builder = new GsonBuilder();
        Gson gson = builder.create();
        return gson.toJson(this);
    }
}

