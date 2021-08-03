package me.francis.playground.api

import me.francis.playground.model.PopularMovies

interface MoviesRepository {

    suspend fun getAllPopularMovies() : List<PopularMovies>

    suspend fun getDetailsMovie(id: Int)

}