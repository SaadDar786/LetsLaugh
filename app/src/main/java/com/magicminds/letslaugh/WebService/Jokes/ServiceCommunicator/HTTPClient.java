package com.magicminds.letslaugh.WebService.Jokes.ServiceCommunicator;

/**
 * Created by saaddar on 2/26/17.
 */

import com.magicminds.letslaugh.WebService.Jokes.Config.Settings;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class HTTPClient {
    private static HTTPClient ourInstance;
    private static Retrofit retrofit = null;
    private static Retrofit.Builder builder = null;

    public static HTTPClient getInstance() {

        if(ourInstance == null) {

            ourInstance = new HTTPClient();
            retrofit = new Retrofit.Builder()
                    .baseUrl(Settings.Base_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();

        }
        return ourInstance;
    }

    private HTTPClient() {

    }

    public Retrofit getClient()
    {
        return retrofit;
    }
}
