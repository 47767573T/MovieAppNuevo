package com.primapp.movieappnuevo.provider.peliculas;

import android.database.Cursor;
import android.support.annotation.Nullable;

import com.primapp.movieappnuevo.provider.base.AbstractCursor;

/**
 * Cursor wrapper for the {@code peliculas} table.
 */
public class PeliculasCursor extends AbstractCursor implements PeliculasModel {
    public PeliculasCursor(Cursor cursor) {
        super(cursor);
    }

    /**
     * Primary key.
     */
    public long getId() {
        Long res = getLongOrNull(PeliculasColumns._ID);
        if (res == null)
            throw new NullPointerException("The value of '_id' in the database was null, which is not allowed according to the model definition");
        return res;
    }

    /**
     * Get the {@code originaltitle} value.
     * Can be {@code null}.
     */
    @Nullable
    public String getOriginaltitle() {
        String res = getStringOrNull(PeliculasColumns.ORIGINALTITLE);
        return res;
    }

    /**
     * Get the {@code overview} value.
     * Can be {@code null}.
     */
    @Nullable
    public String getOverview() {
        String res = getStringOrNull(PeliculasColumns.OVERVIEW);
        return res;
    }

    /**
     * Get the {@code releasedate} value.
     * Can be {@code null}.
     */
    @Nullable
    public String getReleasedate() {
        String res = getStringOrNull(PeliculasColumns.RELEASEDATE);
        return res;
    }

    /**
     * Get the {@code posterpath} value.
     * Can be {@code null}.
     */
    @Nullable
    public String getPosterpath() {
        String res = getStringOrNull(PeliculasColumns.POSTERPATH);
        return res;
    }

    /**
     * Get the {@code popularity} value.
     * Can be {@code null}.
     */
    @Nullable
    public Double getPopularity() {
        Double res = getDoubleOrNull(PeliculasColumns.POPULARITY);
        return res;
    }

    /**
     * Get the {@code voteaverage} value.
     * Can be {@code null}.
     */
    @Nullable
    public Double getVoteaverage() {
        Double res = getDoubleOrNull(PeliculasColumns.VOTEAVERAGE);
        return res;
    }

    /**
     * Get the {@code votecount} value.
     * Can be {@code null}.
     */
    @Nullable
    public Integer getVotecount() {
        Integer res = getIntegerOrNull(PeliculasColumns.VOTECOUNT);
        return res;
    }
}
