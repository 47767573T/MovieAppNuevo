package com.primapp.movieappnuevo;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ListView;

import java.io.IOException;
import java.util.ArrayList;

import Adapters.ListAdapter;
import ApiModels.ApiData;
import ApiModels.Result;
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
    private GridView gvPelis;
    String apiKey = "e6f2c549601727fca2e90f4291bbe34d";
    String urlBase = "https://api.themoviedb.org/3/movie/";
    iMovieService servicio;
   //FULL LINK https://api.themoviedb.org/3/movie/popular?

    public MainActivityFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true); //Aixo fa que mostri el menu. Com n'hi han fragments no grafics cal especificar-ho
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }
        if (id == R.id.actions_refresh) {

            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState)
    {
        View rootView = inflater.inflate(R.layout.fragment_main, container, false);
        createRetrofit();
        refreshPopulars();
        lvPelis = (ListView)rootView.findViewById(R.id.lvPelis);
        gvPelis = (GridView) rootView.findViewById(R.id.GVgridView);
        items = new ArrayList<>();
        adapter = new ListAdapter(getContext(), 0, items);
        gvPelis.setAdapter(adapter);

        gvPelis.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Result peliPicada = (Result) parent.getItemAtPosition(position);
                Intent details = new Intent(getContext(), DetailsActivity.class);
                details.putExtra("pelicula", peliPicada);
                startActivity(details);
            }
        });

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
