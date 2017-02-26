package com.magicminds.letslaugh.WebService.Jokes.Model;

/**
 * Created by saaddar on 2/26/17.
 */

import com.google.gson.annotations.SerializedName;

import java.util.List;


public class Jokes {


    @SerializedName("type")
    private String type;
    @SerializedName("value")
    private List<Joke> value;



    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public List<Joke> getJoke() {
        return value;
    }

    public void setJoke(List<Joke> results) {
        this.value = results;
    }

}
