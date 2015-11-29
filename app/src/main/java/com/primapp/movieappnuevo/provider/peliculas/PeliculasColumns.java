package com.primapp.movieappnuevo.provider.peliculas;

import android.net.Uri;
import android.provider.BaseColumns;

import com.primapp.movieappnuevo.provider.NotesProvider;

/**
 * Columns for the {@code peliculas} table.
 */
public class PeliculasColumns implements BaseColumns {
    public static final String TABLE_NAME = "peliculas";
    public static final Uri CONTENT_URI = Uri.parse(NotesProvider.CONTENT_URI_BASE + "/" + TABLE_NAME);

    /**
     * Primary key.
     */
    public static final String _ID = BaseColumns._ID;

    public static final String ORIGINALTITLE = "originalTitle";

    public static final String OVERVIEW = "overview";

    public static final String RELEASEDATE = "releaseDate";

    public static final String POSTERPATH = "posterPath";

    public static final String POPULARITY = "popularity";

    public static final String VOTEAVERAGE = "voteAverage";

    public static final String VOTECOUNT = "voteCount";


    public static final String DEFAULT_ORDER = TABLE_NAME + "." +_ID;

    // @formatter:off
    public static final String[] ALL_COLUMNS = new String[] {
            _ID,
            ORIGINALTITLE,
            OVERVIEW,
            RELEASEDATE,
            POSTERPATH,
            POPULARITY,
            VOTEAVERAGE,
            VOTECOUNT
    };
    // @formatter:on

    public static boolean hasColumns(String[] projection) {
        if (projection == null) return true;
        for (String c : projection) {
            if (c.equals(ORIGINALTITLE) || c.contains("." + ORIGINALTITLE)) return true;
            if (c.equals(OVERVIEW) || c.contains("." + OVERVIEW)) return true;
            if (c.equals(RELEASEDATE) || c.contains("." + RELEASEDATE)) return true;
            if (c.equals(POSTERPATH) || c.contains("." + POSTERPATH)) return true;
            if (c.equals(POPULARITY) || c.contains("." + POPULARITY)) return true;
            if (c.equals(VOTEAVERAGE) || c.contains("." + VOTEAVERAGE)) return true;
            if (c.equals(VOTECOUNT) || c.contains("." + VOTECOUNT)) return true;
        }
        return false;
    }

}
