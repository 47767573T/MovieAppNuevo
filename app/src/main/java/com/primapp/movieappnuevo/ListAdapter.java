package com.primapp.movieappnuevo;

/**
 * Created by 47767573t on 13/11/15.
 */

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

//import com.squareup.picasso.Picasso;

import com.squareup.picasso.Picasso;

import java.text.DecimalFormat;
import java.util.List;


public class ListAdapter extends ArrayAdapter<Result>
{
        final private String POSTER_BASE_URL = "http://image.tmdb.org/t/p/";
        final private String POSTER_SIZE = "w185";
        DecimalFormat oneDecimal = new DecimalFormat("#.#");


        public ListAdapter(Context context, int resource, List<Result> objects)
        {
            super(context, resource, objects);
        }


        @Override
        public View getView(int position, View myView, ViewGroup parent)
        {
            Result selectedFilm = getItem(position);
            if (myView == null)
            {
                LayoutInflater inflater = LayoutInflater.from(getContext());
                myView = inflater.inflate(R.layout.lv_peliculas, parent, false);
            }
            TextView titulo = (TextView) myView.findViewById(R.id.TVtitulo);
            TextView popularidad = (TextView) myView.findViewById(R.id.TVpopularidad);
            TextView release = (TextView) myView.findViewById(R.id.TVestreno);
            ImageView poster = (ImageView) myView.findViewById(R.id.IVposter);

            titulo.setText(selectedFilm.getTitle());
            popularidad.setText("Ratings: "+String.valueOf(oneDecimal.format(selectedFilm.getPopularity()))+"%");
            release.setText("Release: "+selectedFilm.getReleaseDate());
            Picasso.with(getContext()).load(POSTER_BASE_URL+POSTER_SIZE+selectedFilm.getPosterPath()).fit().into(poster);
            return myView;
        }
}
