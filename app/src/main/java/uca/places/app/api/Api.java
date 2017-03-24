package uca.places.app.api;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by polin on 03-23-17.
 */

public class Api {

    private static final String API_URL = "https://api-uca-places.herokuapp.com/api/";

    public static String getBase() {
        return API_URL;
    }

    public static ApiInterface instance() {
        Retrofit retrofit = new Retrofit
                .Builder()
                .baseUrl(Api.getBase())
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        return retrofit.create(ApiInterface.class);
    }
}
