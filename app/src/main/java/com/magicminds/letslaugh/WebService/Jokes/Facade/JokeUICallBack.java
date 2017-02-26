package com.magicminds.letslaugh.WebService.Jokes.Facade;

import com.magicminds.letslaugh.WebService.Jokes.Model.Joke;

import java.util.List;

/**
 * Created by saaddar on 2/26/17.
 */

public interface JokeUICallBack {

    public void updateUIWithJokes(List<Joke> list);
    public void noJokesToUpdateUI(String err);

}
