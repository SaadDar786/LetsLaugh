package com.magicminds.letslaugh.WebService.Jokes.Service;

import com.magicminds.letslaugh.WebService.Jokes.Config.Settings;
import com.magicminds.letslaugh.WebService.Jokes.Facade.JokeServiceCallback;
import com.magicminds.letslaugh.WebService.Jokes.Model.Jokes;
import com.magicminds.letslaugh.WebService.Jokes.Request.JokeRequest;
import com.magicminds.letslaugh.WebService.Jokes.Response.JokeResponse;
import com.magicminds.letslaugh.WebService.Jokes.ServiceCommunicator.HTTPClient;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by saaddar on 2/26/17.
 */

public class JokesService {

    private JokeRequest request;
    private JokeServiceCallback _delegate;


    public JokesService (JokeRequest request, JokeServiceCallback callback)
    {
        this.request = request;
        this._delegate = callback;
    }

    public void dispatchService() {

        JokeApiInterface apiService =
                HTTPClient.getInstance().getClient().create(JokeApiInterface.class);

        Call<Jokes> call = apiService.getRandomJokes(Settings.Jokes_count);
        call.enqueue(new Callback<Jokes>() {
            @Override
            public void onResponse(Call<Jokes>call, Response<Jokes> response) {

                JokeResponse _response = new JokeResponse();
                _response.setJokes(response.body());
                _response.setResultType(response.body().getType());

                _delegate.jokesServiceSuccess(_response);
            }

            @Override
            public void onFailure(Call<Jokes>call, Throwable t) {
                // Log error here since request failed
                JokeResponse _response = new JokeResponse();
                _response.setJokes(null);
                _response.setResultType("Failure");

                _delegate.jokesServiceFailure(_response);
            }
        });
    }
}
