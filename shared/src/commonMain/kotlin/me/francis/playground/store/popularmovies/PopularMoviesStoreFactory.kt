package me.francis.playground.store.popularmovies

import com.arkivanov.mvikotlin.core.store.Reducer
import com.arkivanov.mvikotlin.core.store.Store
import com.arkivanov.mvikotlin.core.store.StoreFactory
import com.arkivanov.mvikotlin.extensions.coroutines.CoroutineExecutor
import kotlinx.coroutines.launch
import me.francis.playground.api.MoviesRepository
import me.francis.playground.model.PopularMovies
import me.francis.playground.store.popularmovies.PopularMoviesStore.Intent
import me.francis.playground.store.popularmovies.PopularMoviesStore.State

internal class PopularMoviesStoreFactory(
    private val storeFactory: StoreFactory,
    private val moviesRepository: MoviesRepository
) {

    fun create(): PopularMoviesStore =
        object : PopularMoviesStore,
            Store<Intent, State, Nothing> by storeFactory.create(
                name = "PopularMoviesStore",
                initialState = State(),
                executorFactory = ::ExecutorImpl,
                reducer = ReducerImpl
            ) {}

    private sealed class Result {
        object LoadingStarted : Result()
        data class PopularMoviesLoaded(val items: List<PopularMovies>) : Result()
        object LoadingFailed : Result()
    }

    private inner class ExecutorImpl :
        CoroutineExecutor<Intent, Nothing, State, Result, Nothing>() {
        override fun executeIntent(intent: Intent, getState: () -> State) =
            when (intent) {
                Intent.Refresh -> if (!getState().isLoading) refresh() else Unit
            }

        private fun refresh() {
            dispatch(Result.LoadingStarted)
            scope.launch {
                val items = moviesRepository.getAllPopularMovies()
                if (items != null) {
                    dispatch(Result.PopularMoviesLoaded(items))
                } else {
                    dispatch(Result.LoadingFailed)
                }
            }
        }
    }

    private object ReducerImpl : Reducer<State, Result> {
        override fun State.reduce(result: Result): State =
            when (result) {
                is Result.LoadingStarted -> copy(isLoading = true)
                is Result.PopularMoviesLoaded -> copy(isLoading = isLoading, items = items)
                is Result.LoadingFailed -> copy(isLoading = false)
            }
    }

}
