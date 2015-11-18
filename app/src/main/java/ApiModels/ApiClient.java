package ApiModels;

import android.widget.ArrayAdapter;


import Adapters.ListAdapter;

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
    iMovieService servicio;

    public ApiClient() {
        super();
    }

    public void getFavoritesMovies(final ArrayAdapter adapter){

        final String urlEnd = "favorite/movie";

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(urlBase)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        servicio = retrofit.create(iMovieService.class);
    }

    public void refreshPopulars(final ListAdapter myAdapter)
    {
        Call<ApiData> call = servicio.getPopularMovies(apiKey); //Fem un call en segon pla
        call.enqueue(new Callback<ApiData>() {
            public void onResponse(Response<ApiData> response, Retrofit retrofit) {
                ApiData resultado = response.body();
                myAdapter.addAll(resultado.getResults());
            }

            public void onFailure(Throwable t) {
            }
        });
    }

    public void refreshTopRated(final ListAdapter myAdapter)
    {
        Call<ApiData> call = servicio.getRatedMovies(apiKey); //Fem un call en segon pla
        call.enqueue(new Callback<ApiData>()
        {
            public void onResponse(Response<ApiData> response, Retrofit retrofit)
            {
                ApiData resultado = response.body();
                myAdapter.addAll(resultado.getResults());

            }
            public void onFailure(Throwable t) {}});
    }

    interface iMovieService {
        @GET("movie/popular")
        Call<ApiData> getPopularMovies(
                @Query("apikey") String apiKey
        );

        @GET ("movie/top_rated")
        Call<ApiData> getRatedMovies(
                @Query("apikey") String apiKey
        );
    }





}
