package com.magicminds.letslaugh.WebService.Jokes.Model;

/**
 * Created by saaddar on 2/26/17.
 */

import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import java.util.List;

public class Joke {

    @SerializedName("id")
    private int id;
    @SerializedName("joke")
    private String joke;
    @SerializedName("categories")
    private List<String> categories = new ArrayList<String>();



    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getJoke() {
        return joke;
    }

    public void setJoke(String joke) {
        this.joke = joke;
    }

    public List<String> getCategories() {
        return categories;
    }

    public void setResults(List<String> results) {
        this.categories = results;
    }

}
