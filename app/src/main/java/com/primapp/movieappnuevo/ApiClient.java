package com.primapp.movieappnuevo;

import android.util.Log;
import android.widget.ArrayAdapter;


import com.google.gson.JsonElement;

import java.util.Arrays;

import retrofit.Call;
import retrofit.Callback;
import retrofit.GsonConverterFactory;
import retrofit.Response;
import retrofit.Retrofit;
import retrofit.http.GET;
import retrofit.http.Query;

/**
 * Created by 47767573t on 04/11/15.
 */
public class ApiClient {
    String apiKey = "e6f2c549601727fca2e90f4291bbe34d";
    String sesionId = "47767573t";
    String urlBase = "https://api.themoviedb.org/3/";
    String mode = "";

    public ApiClient() {
        super();
    }

    public void getFavoritesMovies(final ArrayAdapter adapter){

        final String urlEnd = "favorite/movie";

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(urlBase)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        iMovieService servicio = retrofit.create(iMovieService.class);
    }


    interface iMovieService {
        @GET("movie/popular")
        Call<ApiData> getFavoriteMovies(
                @Query("apikey") String apiKey
        );

        @GET ("movie/top_rated")
        Call<ApiData> getRatedMovies(
                @Query("apikey") String apiKey
        );
    }





}
