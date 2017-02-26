package com.magicminds.letslaugh.WebService.Jokes.Request;

import com.magicminds.letslaugh.WebService.Jokes.Config.Settings;

/**
 * Created by saaddar on 2/26/17.
 */

public class JokeRequest {

    private String jokeURL;


    public JokeRequest(Settings.JokeType type)
    {
        this.jokeURL = getJokesUrlWithType(type);
    }

    private String getJokesUrlWithType(Settings.JokeType type) {

        String url = null;
        switch (type) {
            case RANDOM:
                url = Settings.Base_URL + Settings.Jokes_URL + Settings.Random_URL + Settings.Jokes_count;
                break;

            case CATEGORY:
                break;

            default:
                break;
        }

        return url;
    }

}
