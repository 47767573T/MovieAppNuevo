package com.primapp.movieappnuevo;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

/**
 * A placeholder fragment containing a simple view.
 */
public class DetailsActivityFragment extends Fragment {
    final private String POSTER_BASE_URL = "http://image.tmdb.org/t/p/";
    final private String POSTER_SIZE = "w185";
    public DetailsActivityFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        View x =  inflater.inflate(R.layout.fragment_details, container, false);

        Result peliPicada = (Result) getActivity().getIntent().getExtras().get("pelicula");

        TextView titulo = (TextView) x.findViewById(R.id.TVtitulo);
        TextView popularidad = (TextView) x.findViewById(R.id.TVpopularidad);
        TextView release = (TextView) x.findViewById(R.id.TVestreno);
        TextView desc = (TextView) x.findViewById(R.id.TVdesc);
        ImageView poster = (ImageView) x.findViewById(R.id.IVposter);

        titulo.setText(peliPicada.getTitle());
        popularidad.setText("Rating: "+String.valueOf(peliPicada.getPopularity()));
        release.setText("Release: "+peliPicada.getReleaseDate());
        desc.setText(peliPicada.getOverview());
        Picasso.with(getContext()).load(POSTER_BASE_URL+POSTER_SIZE+peliPicada.getPosterPath()).fit().into(poster);
        return x;
    }
}
