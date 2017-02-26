package com.magicminds.letslaugh.WebService.Jokes.Facade;

import com.magicminds.letslaugh.WebService.Jokes.Response.JokeResponse;

/**
 * Created by saaddar on 2/26/17.
 */

public interface JokeServiceCallback {

    public void jokesServiceSuccess(JokeResponse response);
    public void jokesServiceFailure(JokeResponse response);
}
