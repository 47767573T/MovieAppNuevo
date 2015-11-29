package com.primapp.movieappnuevo.provider.peliculas;

import java.util.Date;

import android.content.Context;
import android.content.ContentResolver;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.primapp.movieappnuevo.provider.base.AbstractContentValues;

/**
 * Content values wrapper for the {@code peliculas} table.
 */
public class PeliculasContentValues extends AbstractContentValues {
    @Override
    public Uri uri() {
        return PeliculasColumns.CONTENT_URI;
    }

    /**
     * Update row(s) using the values stored by this object and the given selection.
     *
     * @param contentResolver The content resolver to use.
     * @param where The selection to use (can be {@code null}).
     */
    public int update(ContentResolver contentResolver, @Nullable PeliculasSelection where) {
        return contentResolver.update(uri(), values(), where == null ? null : where.sel(), where == null ? null : where.args());
    }

    /**
     * Update row(s) using the values stored by this object and the given selection.
     *
     * @param contentResolver The content resolver to use.
     * @param where The selection to use (can be {@code null}).
     */
    public int update(Context context, @Nullable PeliculasSelection where) {
        return context.getContentResolver().update(uri(), values(), where == null ? null : where.sel(), where == null ? null : where.args());
    }

    public PeliculasContentValues putOriginaltitle(@Nullable String value) {
        mContentValues.put(PeliculasColumns.ORIGINALTITLE, value);
        return this;
    }

    public PeliculasContentValues putOriginaltitleNull() {
        mContentValues.putNull(PeliculasColumns.ORIGINALTITLE);
        return this;
    }

    public PeliculasContentValues putOverview(@Nullable String value) {
        mContentValues.put(PeliculasColumns.OVERVIEW, value);
        return this;
    }

    public PeliculasContentValues putOverviewNull() {
        mContentValues.putNull(PeliculasColumns.OVERVIEW);
        return this;
    }

    public PeliculasContentValues putReleasedate(@Nullable String value) {
        mContentValues.put(PeliculasColumns.RELEASEDATE, value);
        return this;
    }

    public PeliculasContentValues putReleasedateNull() {
        mContentValues.putNull(PeliculasColumns.RELEASEDATE);
        return this;
    }

    public PeliculasContentValues putPosterpath(@Nullable String value) {
        mContentValues.put(PeliculasColumns.POSTERPATH, value);
        return this;
    }

    public PeliculasContentValues putPosterpathNull() {
        mContentValues.putNull(PeliculasColumns.POSTERPATH);
        return this;
    }

    public PeliculasContentValues putPopularity(@Nullable Double value) {
        mContentValues.put(PeliculasColumns.POPULARITY, value);
        return this;
    }

    public PeliculasContentValues putPopularityNull() {
        mContentValues.putNull(PeliculasColumns.POPULARITY);
        return this;
    }

    public PeliculasContentValues putVoteaverage(@Nullable Double value) {
        mContentValues.put(PeliculasColumns.VOTEAVERAGE, value);
        return this;
    }

    public PeliculasContentValues putVoteaverageNull() {
        mContentValues.putNull(PeliculasColumns.VOTEAVERAGE);
        return this;
    }

    public PeliculasContentValues putVotecount(@Nullable Integer value) {
        mContentValues.put(PeliculasColumns.VOTECOUNT, value);
        return this;
    }

    public PeliculasContentValues putVotecountNull() {
        mContentValues.putNull(PeliculasColumns.VOTECOUNT);
        return this;
    }
}
