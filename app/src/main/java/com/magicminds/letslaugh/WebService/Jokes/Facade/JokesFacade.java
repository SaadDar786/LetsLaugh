package com.magicminds.letslaugh.WebService.Jokes.Facade;

import com.magicminds.letslaugh.WebService.Jokes.Config.Settings;
import com.magicminds.letslaugh.WebService.Jokes.Request.JokeRequest;
import com.magicminds.letslaugh.WebService.Jokes.Response.JokeResponse;
import com.magicminds.letslaugh.WebService.Jokes.Service.JokesService;

/**
 * Created by saaddar on 2/26/17.
 */

public class JokesFacade implements JokeServiceCallback {

    private JokeUICallBack callback;

    public JokesFacade(JokeUICallBack callback) {

        this.callback = callback;
    }

    public void getRandomJokes() {

        JokeRequest _request = new JokeRequest(Settings.JokeType.RANDOM);
        JokesService _service = new JokesService(_request,this);
        _service.dispatchService();

    }

    @Override
    public void jokesServiceSuccess(JokeResponse response) {
        this.callback.updateUIWithJokes(response.getJokes().getJoke());
    }

    @Override
    public void jokesServiceFailure(JokeResponse response) {
        this.callback.noJokesToUpdateUI(response.getResultType());
    }
}
