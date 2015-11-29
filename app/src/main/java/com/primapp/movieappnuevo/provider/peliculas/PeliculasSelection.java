package com.primapp.movieappnuevo.provider.peliculas;

import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;

import com.primapp.movieappnuevo.provider.base.AbstractSelection;

/**
 * Selection for the {@code peliculas} table.
 */
public class PeliculasSelection extends AbstractSelection<PeliculasSelection> {
    @Override
    protected Uri baseUri() {
        return PeliculasColumns.CONTENT_URI;
    }

    /**
     * Query the given content resolver using this selection.
     *
     * @param contentResolver The content resolver to query.
     * @param projection A list of which columns to return. Passing null will return all columns, which is inefficient.
     * @return A {@code PeliculasCursor} object, which is positioned before the first entry, or null.
     */
    public PeliculasCursor query(ContentResolver contentResolver, String[] projection) {
        Cursor cursor = contentResolver.query(uri(), projection, sel(), args(), order());
        if (cursor == null) return null;
        return new PeliculasCursor(cursor);
    }

    /**
     * Equivalent of calling {@code query(contentResolver, null)}.
     */
    public PeliculasCursor query(ContentResolver contentResolver) {
        return query(contentResolver, null);
    }

    /**
     * Query the given content resolver using this selection.
     *
     * @param context The context to use for the query.
     * @param projection A list of which columns to return. Passing null will return all columns, which is inefficient.
     * @return A {@code PeliculasCursor} object, which is positioned before the first entry, or null.
     */
    public PeliculasCursor query(Context context, String[] projection) {
        Cursor cursor = context.getContentResolver().query(uri(), projection, sel(), args(), order());
        if (cursor == null) return null;
        return new PeliculasCursor(cursor);
    }

    /**
     * Equivalent of calling {@code query(context, null)}.
     */
    public PeliculasCursor query(Context context) {
        return query(context, null);
    }


    public PeliculasSelection id(long... value) {
        addEquals("peliculas." + PeliculasColumns._ID, toObjectArray(value));
        return this;
    }

    public PeliculasSelection idNot(long... value) {
        addNotEquals("peliculas." + PeliculasColumns._ID, toObjectArray(value));
        return this;
    }

    public PeliculasSelection orderById(boolean desc) {
        orderBy("peliculas." + PeliculasColumns._ID, desc);
        return this;
    }

    public PeliculasSelection orderById() {
        return orderById(false);
    }

    public PeliculasSelection originaltitle(String... value) {
        addEquals(PeliculasColumns.ORIGINALTITLE, value);
        return this;
    }

    public PeliculasSelection originaltitleNot(String... value) {
        addNotEquals(PeliculasColumns.ORIGINALTITLE, value);
        return this;
    }

    public PeliculasSelection originaltitleLike(String... value) {
        addLike(PeliculasColumns.ORIGINALTITLE, value);
        return this;
    }

    public PeliculasSelection originaltitleContains(String... value) {
        addContains(PeliculasColumns.ORIGINALTITLE, value);
        return this;
    }

    public PeliculasSelection originaltitleStartsWith(String... value) {
        addStartsWith(PeliculasColumns.ORIGINALTITLE, value);
        return this;
    }

    public PeliculasSelection originaltitleEndsWith(String... value) {
        addEndsWith(PeliculasColumns.ORIGINALTITLE, value);
        return this;
    }

    public PeliculasSelection orderByOriginaltitle(boolean desc) {
        orderBy(PeliculasColumns.ORIGINALTITLE, desc);
        return this;
    }

    public PeliculasSelection orderByOriginaltitle() {
        orderBy(PeliculasColumns.ORIGINALTITLE, false);
        return this;
    }

    public PeliculasSelection overview(String... value) {
        addEquals(PeliculasColumns.OVERVIEW, value);
        return this;
    }

    public PeliculasSelection overviewNot(String... value) {
        addNotEquals(PeliculasColumns.OVERVIEW, value);
        return this;
    }

    public PeliculasSelection overviewLike(String... value) {
        addLike(PeliculasColumns.OVERVIEW, value);
        return this;
    }

    public PeliculasSelection overviewContains(String... value) {
        addContains(PeliculasColumns.OVERVIEW, value);
        return this;
    }

    public PeliculasSelection overviewStartsWith(String... value) {
        addStartsWith(PeliculasColumns.OVERVIEW, value);
        return this;
    }

    public PeliculasSelection overviewEndsWith(String... value) {
        addEndsWith(PeliculasColumns.OVERVIEW, value);
        return this;
    }

    public PeliculasSelection orderByOverview(boolean desc) {
        orderBy(PeliculasColumns.OVERVIEW, desc);
        return this;
    }

    public PeliculasSelection orderByOverview() {
        orderBy(PeliculasColumns.OVERVIEW, false);
        return this;
    }

    public PeliculasSelection releasedate(String... value) {
        addEquals(PeliculasColumns.RELEASEDATE, value);
        return this;
    }

    public PeliculasSelection releasedateNot(String... value) {
        addNotEquals(PeliculasColumns.RELEASEDATE, value);
        return this;
    }

    public PeliculasSelection releasedateLike(String... value) {
        addLike(PeliculasColumns.RELEASEDATE, value);
        return this;
    }

    public PeliculasSelection releasedateContains(String... value) {
        addContains(PeliculasColumns.RELEASEDATE, value);
        return this;
    }

    public PeliculasSelection releasedateStartsWith(String... value) {
        addStartsWith(PeliculasColumns.RELEASEDATE, value);
        return this;
    }

    public PeliculasSelection releasedateEndsWith(String... value) {
        addEndsWith(PeliculasColumns.RELEASEDATE, value);
        return this;
    }

    public PeliculasSelection orderByReleasedate(boolean desc) {
        orderBy(PeliculasColumns.RELEASEDATE, desc);
        return this;
    }

    public PeliculasSelection orderByReleasedate() {
        orderBy(PeliculasColumns.RELEASEDATE, false);
        return this;
    }

    public PeliculasSelection posterpath(String... value) {
        addEquals(PeliculasColumns.POSTERPATH, value);
        return this;
    }

    public PeliculasSelection posterpathNot(String... value) {
        addNotEquals(PeliculasColumns.POSTERPATH, value);
        return this;
    }

    public PeliculasSelection posterpathLike(String... value) {
        addLike(PeliculasColumns.POSTERPATH, value);
        return this;
    }

    public PeliculasSelection posterpathContains(String... value) {
        addContains(PeliculasColumns.POSTERPATH, value);
        return this;
    }

    public PeliculasSelection posterpathStartsWith(String... value) {
        addStartsWith(PeliculasColumns.POSTERPATH, value);
        return this;
    }

    public PeliculasSelection posterpathEndsWith(String... value) {
        addEndsWith(PeliculasColumns.POSTERPATH, value);
        return this;
    }

    public PeliculasSelection orderByPosterpath(boolean desc) {
        orderBy(PeliculasColumns.POSTERPATH, desc);
        return this;
    }

    public PeliculasSelection orderByPosterpath() {
        orderBy(PeliculasColumns.POSTERPATH, false);
        return this;
    }

    public PeliculasSelection popularity(Double... value) {
        addEquals(PeliculasColumns.POPULARITY, value);
        return this;
    }

    public PeliculasSelection popularityNot(Double... value) {
        addNotEquals(PeliculasColumns.POPULARITY, value);
        return this;
    }

    public PeliculasSelection popularityGt(double value) {
        addGreaterThan(PeliculasColumns.POPULARITY, value);
        return this;
    }

    public PeliculasSelection popularityGtEq(double value) {
        addGreaterThanOrEquals(PeliculasColumns.POPULARITY, value);
        return this;
    }

    public PeliculasSelection popularityLt(double value) {
        addLessThan(PeliculasColumns.POPULARITY, value);
        return this;
    }

    public PeliculasSelection popularityLtEq(double value) {
        addLessThanOrEquals(PeliculasColumns.POPULARITY, value);
        return this;
    }

    public PeliculasSelection orderByPopularity(boolean desc) {
        orderBy(PeliculasColumns.POPULARITY, desc);
        return this;
    }

    public PeliculasSelection orderByPopularity() {
        orderBy(PeliculasColumns.POPULARITY, false);
        return this;
    }

    public PeliculasSelection voteaverage(Double... value) {
        addEquals(PeliculasColumns.VOTEAVERAGE, value);
        return this;
    }

    public PeliculasSelection voteaverageNot(Double... value) {
        addNotEquals(PeliculasColumns.VOTEAVERAGE, value);
        return this;
    }

    public PeliculasSelection voteaverageGt(double value) {
        addGreaterThan(PeliculasColumns.VOTEAVERAGE, value);
        return this;
    }

    public PeliculasSelection voteaverageGtEq(double value) {
        addGreaterThanOrEquals(PeliculasColumns.VOTEAVERAGE, value);
        return this;
    }

    public PeliculasSelection voteaverageLt(double value) {
        addLessThan(PeliculasColumns.VOTEAVERAGE, value);
        return this;
    }

    public PeliculasSelection voteaverageLtEq(double value) {
        addLessThanOrEquals(PeliculasColumns.VOTEAVERAGE, value);
        return this;
    }

    public PeliculasSelection orderByVoteaverage(boolean desc) {
        orderBy(PeliculasColumns.VOTEAVERAGE, desc);
        return this;
    }

    public PeliculasSelection orderByVoteaverage() {
        orderBy(PeliculasColumns.VOTEAVERAGE, false);
        return this;
    }

    public PeliculasSelection votecount(Integer... value) {
        addEquals(PeliculasColumns.VOTECOUNT, value);
        return this;
    }

    public PeliculasSelection votecountNot(Integer... value) {
        addNotEquals(PeliculasColumns.VOTECOUNT, value);
        return this;
    }

    public PeliculasSelection votecountGt(int value) {
        addGreaterThan(PeliculasColumns.VOTECOUNT, value);
        return this;
    }

    public PeliculasSelection votecountGtEq(int value) {
        addGreaterThanOrEquals(PeliculasColumns.VOTECOUNT, value);
        return this;
    }

    public PeliculasSelection votecountLt(int value) {
        addLessThan(PeliculasColumns.VOTECOUNT, value);
        return this;
    }

    public PeliculasSelection votecountLtEq(int value) {
        addLessThanOrEquals(PeliculasColumns.VOTECOUNT, value);
        return this;
    }

    public PeliculasSelection orderByVotecount(boolean desc) {
        orderBy(PeliculasColumns.VOTECOUNT, desc);
        return this;
    }

    public PeliculasSelection orderByVotecount() {
        orderBy(PeliculasColumns.VOTECOUNT, false);
        return this;
    }
}
