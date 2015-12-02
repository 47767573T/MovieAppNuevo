package com.primapp.movieappnuevo;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.text.DecimalFormat;

import ApiModels.Result;

/**
 * A placeholder fragment containing a simple view.
 */
public class DetailsActivityFragment extends Fragment {
    final private String POSTER_BASE_URL = "http://image.tmdb.org/t/p/";
    final private String POSTER_SIZE = "w185";
    DecimalFormat df = new DecimalFormat("#.00");
    public DetailsActivityFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        View x =  inflater.inflate(R.layout.fragment_details, container, false);

        Result peliClickada = (Result) getActivity().getIntent().getExtras().get("pelicula");

        TextView titulo = (TextView) x.findViewById(R.id.TVtitulo);
        TextView popularidad = (TextView) x.findViewById(R.id.TVpopularidad);
        TextView estreno = (TextView) x.findViewById(R.id.TVestreno);
        TextView sinopsis = (TextView) x.findViewById(R.id.TVsinopsis);
        ImageView poster = (ImageView) x.findViewById(R.id.ivListPoster);

        titulo.setText(peliClickada.getTitle());

        popularidad.setText("Clasificacion: "+df.format(peliClickada.getPopularity()));
        estreno.setText("Lanzamiento: "+peliClickada.getReleaseDate());
        sinopsis.setText("Sinopsis: "+peliClickada.getOverview());
        Picasso.with(getContext()).load(POSTER_BASE_URL+POSTER_SIZE+peliClickada.getPosterPath()).fit().into(poster);
        return x;
    }
}
