package Adapters;

/**
 * Created by 47767573t on 13/11/15.
 */

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;

import com.primapp.movieappnuevo.R;
import com.squareup.picasso.Picasso;

import java.util.List;

import ApiModels.Result;

//import com.squareup.picasso.Picasso;


public class GridAdapter extends ArrayAdapter<Result>
{
        final private String POSTER_BASE_URL = "http://image.tmdb.org/t/p/";
        final private String POSTER_SIZE = "w185";



        public GridAdapter(Context context, int resource, List<Result> objects)
        {
            super(context, resource, objects);
        }

        @Override
        public View getView(int position, View posterView, ViewGroup parent)
        {
            Result selectedFilm = getItem(position);
            if (posterView == null)
            {
                LayoutInflater inflater = LayoutInflater.from(getContext());
                posterView = inflater.inflate(R.layout.gv_peliculas, parent, false);
            }
            ImageView poster = (ImageView) posterView.findViewById(R.id.IVposter);
            Picasso.with(getContext()).load(POSTER_BASE_URL+POSTER_SIZE+selectedFilm.getPosterPath()).fit().into(poster);
            return posterView;
        }
}
