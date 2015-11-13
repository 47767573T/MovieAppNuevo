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

import com.squareup.picasso.Picasso;

import java.text.DecimalFormat;
import java.util.List;

//import com.squareup.picasso.Picasso;


public class GridAdapter extends ArrayAdapter<Result>
{
        final private String POSTER_BASE_URL = "http://image.tmdb.org/t/p/";
        final private String POSTER_SIZE = "w185";
        DecimalFormat oneDecimal = new DecimalFormat("#.#");


        public GridAdapter(Context context, int resource, List<Result> objects)
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
                myView = inflater.inflate(R.layout.gv_peliculas, parent, false);
            }
            ImageView poster = (ImageView) myView.findViewById(R.id.IVposter);
            Picasso.with(getContext()).load(POSTER_BASE_URL+POSTER_SIZE+selectedFilm.getPosterPath()).fit().into(poster);
            return myView;
        }
}
