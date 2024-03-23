package com.example.moviesapp.presentation.screens.main.screens.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.base.models.ResponseStatus
import com.example.domain.use.cases.remote.now.playing.GetNowPlayingMoviesDataUseCase
import com.example.domain.use.cases.remote.popular.GetPopularMoviesDataUseCase
import com.example.domain.use.cases.remote.top.rated.GetTopRatedMoviesDataUseCase
import com.example.domain.use.cases.remote.upcoming.GetUpcomingMoviesDataUseCase
import com.example.moviesapp.presentation.mappers.toUIModel
import com.example.moviesapp.presentation.screens.main.screens.home.HomeScreenUiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.collections.immutable.toImmutableList
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeScreenViewModel @Inject constructor(
    private val getPopularMoviesDataUseCase: GetPopularMoviesDataUseCase,
    private val getNowPlayingMoviesDataUseCase: GetNowPlayingMoviesDataUseCase,
    private val getTopRatedMoviesDataUseCase: GetTopRatedMoviesDataUseCase,
    private val getUpcomingMoviesDataUseCase: GetUpcomingMoviesDataUseCase,
) : ViewModel() {
    private val _uiState: MutableStateFlow<HomeScreenUiState> =
        MutableStateFlow(HomeScreenUiState.Loading)
    val uiState: StateFlow<HomeScreenUiState> = _uiState.asStateFlow()
    private val handle = CoroutineExceptionHandler { _, throwable -> }

    init {
        getAllMovies()
    }

    fun getAllMovies() {
        viewModelScope.launch(handle + Dispatchers.IO) {
            _uiState.update { HomeScreenUiState.Loading }
            val getPopularMoviesDataUseCaseDeferred = async { getPopularMoviesDataUseCase(page = 1) }
            val getNowPlayingMoviesDataUseCaseDeferred = async { getNowPlayingMoviesDataUseCase(page = 1) }
            val getTopRatedMoviesDataUseCaseDeferred = async { getTopRatedMoviesDataUseCase(page = 1) }
            val getUpcomingMoviesDataUseCaseDeferred = async { getUpcomingMoviesDataUseCase(page = 1) }
            val getPopularMoviesDataUseCase = getPopularMoviesDataUseCaseDeferred.await()
            val getNowPlayingMoviesDataUseCase = getNowPlayingMoviesDataUseCaseDeferred.await()
            val getTopRatedMoviesDataUseCase = getTopRatedMoviesDataUseCaseDeferred.await()
            val getUpcomingMoviesDataUseCase = getUpcomingMoviesDataUseCaseDeferred.await()
            if (getTopRatedMoviesDataUseCase.status == ResponseStatus.SUCCESS && getPopularMoviesDataUseCase.status == ResponseStatus.SUCCESS && getNowPlayingMoviesDataUseCase.status == ResponseStatus.SUCCESS && getUpcomingMoviesDataUseCase.status == ResponseStatus.SUCCESS) {
                getPopularMoviesDataUseCase.data.let { popular ->
                    getNowPlayingMoviesDataUseCase.data.let { nowPlaying ->
                        getTopRatedMoviesDataUseCase.data.let { topRated ->
                            getUpcomingMoviesDataUseCase.data.let { upcoming ->
                                if (popular != null && nowPlaying != null && topRated != null && upcoming != null) _uiState.update {
                                    HomeScreenUiState.Loaded(
                                        popularMovies = popular.results.map {
                                            it.toUIModel()
                                        }.toImmutableList(),
                                        nowPlayingMovies = nowPlaying.results.map {
                                            it.toUIModel()
                                        }.toImmutableList(),
                                        topRatedMovies = topRated.results.map {
                                            it.toUIModel()
                                        }.toImmutableList(),
                                        upcomingMovies = upcoming.results.map {
                                            it.toUIModel()
                                        }.toImmutableList()
                                    )
                                }
                            }
                        }
                    }
                }
            } else {
                _uiState.update {
                    HomeScreenUiState.Error(
                        message = "Something went wrong,please check internet connection or try again"
                    )
                }
            }
        }
    }
}