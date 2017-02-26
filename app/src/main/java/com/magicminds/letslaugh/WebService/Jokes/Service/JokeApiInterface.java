package com.magicminds.letslaugh.WebService.Jokes.Service;

/**
 * Created by saaddar on 2/26/17.
 */

import com.magicminds.letslaugh.WebService.Jokes.Model.Jokes;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface JokeApiInterface {

    @GET("jokes/random/{count}")
    Call<Jokes> getRandomJokes(@Path("count") String count);

}
