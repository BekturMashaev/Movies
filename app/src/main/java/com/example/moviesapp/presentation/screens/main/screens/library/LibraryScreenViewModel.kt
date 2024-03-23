package com.example.moviesapp.presentation.screens.main.screens.library

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.use.cases.local.get.GetAllCachedMoviesUseCase
import com.example.domain.use.cases.remote.popular.GetPopularMoviesDataUseCase
import com.example.moviesapp.presentation.mappers.toUI
import com.example.moviesapp.presentation.models.movie.info.MovieInfoDataModelUI
import com.example.moviesapp.presentation.screens.main.screens.home.HomeScreenUiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.collections.immutable.ImmutableList
import kotlinx.collections.immutable.toImmutableList
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LibraryScreenViewModel @Inject constructor(
    private val getAllCachedMoviesUseCase: GetAllCachedMoviesUseCase
): ViewModel(){
    private val _uiState: MutableStateFlow<LibraryScreenUiState> =
        MutableStateFlow(LibraryScreenUiState.Loading)
    val uiState: StateFlow<LibraryScreenUiState> = _uiState.asStateFlow()
    init {
        getAllMovies()
    }
    val allCachedMovies=getAllCachedMoviesUseCase().stateIn(viewModelScope, SharingStarted.Lazily,null)
    fun getAllMovies() {
        Log.d("AAA","aa $allCachedMovies")
        viewModelScope.launch {
            allCachedMovies.collectLatest {listOfMovies->
                Log.d("AAA","$listOfMovies")
                _uiState.update {
                    LibraryScreenUiState.Loaded(
                        movies = listOfMovies?.map { it.toUI() }?.toImmutableList().orEmpty() as ImmutableList<MovieInfoDataModelUI>
                    )
                }
            }
        }
    }
}