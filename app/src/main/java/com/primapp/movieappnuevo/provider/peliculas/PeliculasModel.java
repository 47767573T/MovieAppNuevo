package com.primapp.movieappnuevo.provider.peliculas;

import android.support.annotation.Nullable;

import com.primapp.movieappnuevo.provider.base.BaseModel;

/**
 * Data model for the {@code peliculas} table.
 */
public interface PeliculasModel extends BaseModel {

    /**
     * Get the {@code originaltitle} value.
     * Can be {@code null}.
     */
    @Nullable
    String getOriginaltitle();

    /**
     * Get the {@code overview} value.
     * Can be {@code null}.
     */
    @Nullable
    String getOverview();

    /**
     * Get the {@code releasedate} value.
     * Can be {@code null}.
     */
    @Nullable
    String getReleasedate();

    /**
     * Get the {@code posterpath} value.
     * Can be {@code null}.
     */
    @Nullable
    String getPosterpath();

    /**
     * Get the {@code popularity} value.
     * Can be {@code null}.
     */
    @Nullable
    Double getPopularity();

    /**
     * Get the {@code voteaverage} value.
     * Can be {@code null}.
     */
    @Nullable
    Double getVoteaverage();

    /**
     * Get the {@code votecount} value.
     * Can be {@code null}.
     */
    @Nullable
    Integer getVotecount();
}
