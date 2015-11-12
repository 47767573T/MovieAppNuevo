package com.primapp.movieappnuevo;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * A placeholder fragment containing a simple view.
 */
public class MainActivityFragment extends Fragment {

    private ArrayList<String> items;
    private ArrayAdapter<String> adapter;
    private ListView lvPelis:


    public MainActivityFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_main, container, false);

        String[] peliEjemplo = {
                "pelicula 1",
                "pelicula 2",
                "pelicula 3"
        };

        lvPelis = (ListView)rootView.findViewById(R.id.lvPelis);
        items = new ArrayList<>(Arrays.asList(peliEjemplo));
        adapter = new ArrayAdapter<>(
                getContext()
                ,R.layout.lv_peliculas
                ,R.id.tvMovie
                ,lvPelis
        );
        return rootView;
    }
}
