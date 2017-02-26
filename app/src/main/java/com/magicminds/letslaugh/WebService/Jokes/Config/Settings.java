package com.magicminds.letslaugh.WebService.Jokes.Config;

/**
 * Created by saaddar on 2/26/17.
 */

public class Settings {

    public enum JokeType {
        RANDOM,
        CATEGORY;
    }

    public static final String Base_URL      = "http://api.icndb.com/";
    public static final String Random_URL    = "random/";
    public static final String Jokes_URL     = "jokes/";
    public static final String Jokes_count   = "40";
}
