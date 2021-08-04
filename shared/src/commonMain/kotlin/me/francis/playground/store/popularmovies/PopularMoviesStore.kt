package me.francis.playground.store.popularmovies

import com.arkivanov.mvikotlin.core.store.Store
import me.francis.playground.model.PopularMovies
import me.francis.playground.store.popularmovies.PopularMoviesStore.State
import me.francis.playground.store.popularmovies.PopularMoviesStore.Intent

internal interface PopularMoviesStore : Store<Intent, State, Nothing> {

    sealed class Intent {
        object Refresh : Intent()
    }

    data class State(
        var isLoading: Boolean = false,
        var items: List<PopularMovies> = emptyList()
    )

}