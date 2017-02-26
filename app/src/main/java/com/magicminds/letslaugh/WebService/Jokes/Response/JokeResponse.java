package com.magicminds.letslaugh.WebService.Jokes.Response;

import com.magicminds.letslaugh.WebService.Jokes.Model.Jokes;

/**
 * Created by saaddar on 2/26/17.
 */

public class JokeResponse {

    private Jokes jokes;
    private String resultType;


    public Jokes getJokes() {
        return jokes;
    }

    public void setJokes(Jokes jokes) {
        this.jokes = jokes;
    }

    public String getResultType() {
        return resultType;
    }

    public void setResultType(String result) {
        this.resultType = result;
    }

}
