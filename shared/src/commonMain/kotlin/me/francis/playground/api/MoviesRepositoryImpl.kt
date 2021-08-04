package me.francis.playground.api

import io.ktor.client.*
import me.francis.playground.model.PopularMovies

internal class MoviesRepositoryImpl(
    private val client: HttpClient
) : MoviesRepository {

    override suspend fun getAllPopularMovies(): List<PopularMovies>? {
        client.runCatching {
            try {
                get
            }
        }
    }

    override suspend fun getDetailsMovie(id: Int) {
        TODO("Not yet implemented")
    }


}