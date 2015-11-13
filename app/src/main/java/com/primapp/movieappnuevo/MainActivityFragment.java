package com.primapp.movieappnuevo;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import retrofit.Call;
import retrofit.Callback;
import retrofit.GsonConverterFactory;
import retrofit.Response;
import retrofit.Retrofit;
import retrofit.http.GET;
import retrofit.http.Query;

/**
 * A placeholder fragment containing a simple view.
 */
public class MainActivityFragment extends Fragment {

    ApiData resultado;
    private ArrayList<Result> items;
    private ListAdapter adapter;
    private ListView lvPelis;
    String apiKey = "e6f2c549601727fca2e90f4291bbe34d";
    String sesionId = "47767573t";
    String urlBase = "https://api.themoviedb.org/3/movie/";
    String mode = "";
    iMovieService servicio;
   //FULL LINK https://api.themoviedb.org/3/movie/popular?

    public MainActivityFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState)
    {
        View rootView = inflater.inflate(R.layout.fragment_main, container, false);
        createRetrofit();
        refreshPopulars();
        lvPelis = (ListView)rootView.findViewById(R.id.lvPelis);
        items = new ArrayList<>();
        adapter = new ListAdapter(getContext(), 0, items);
        lvPelis.setAdapter(adapter);

        return rootView;
    }
    public void createRetrofit(){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(urlBase)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        servicio = retrofit.create(iMovieService.class);
    }

    public void refreshPopulars()
    {
        Call<ApiData> call = servicio.getPopularMovies(apiKey); //Fem un call en segon pla
        call.enqueue(new Callback<ApiData>() {
            public void onResponse(Response<ApiData> response, Retrofit retrofit) {
                if (response.isSuccess()) {
                    resultado = response.body();
                    adapter.addAll(resultado.getResults());
                } else {
                    try {
                        Log.w("Response Error", response.errorBody().string());
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }

            public void onFailure(Throwable t) {
            }
        });
    }

    public void refreshTopRated()
    {
        Call<ApiData> call = servicio.getRatedMovies(apiKey); //Fem un call en segon pla
        call.enqueue(new Callback<ApiData>()
        {
            public void onResponse(Response<ApiData> response, Retrofit retrofit)
            {
                resultado = response.body();
                adapter.addAll(resultado.getResults());
            }
            public void onFailure(Throwable t) {}});
    }

    interface iMovieService {
        @GET("popular")
        Call<ApiData> getPopularMovies(
                @Query("api_key") String apiKey
        );

        @GET ("top_rated")
        Call<ApiData> getRatedMovies(
                @Query("api_key") String apiKey
        );

    }
}
