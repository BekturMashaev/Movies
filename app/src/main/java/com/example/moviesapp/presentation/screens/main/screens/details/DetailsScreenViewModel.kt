package com.example.moviesapp.presentation.screens.main.screens.details

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.base.models.ResponseStatus
import com.example.domain.models.movie.info.MovieInfoDomainModel
import com.example.domain.use.cases.local.save.SaveMovieToCacheUseCase
import com.example.domain.use.cases.remote.info.GetMovieInfoUseCase
import com.example.moviesapp.presentation.mappers.toDomain
import com.example.moviesapp.presentation.mappers.toUI
import com.example.moviesapp.presentation.models.movie.info.MovieInfoDataModelUI
import dagger.hilt.android.lifecycle.HiltViewModel
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
class DetailsScreenViewModel @Inject constructor(
    private val getMovieInfoUseCase: GetMovieInfoUseCase,
    private val saveMovieToCacheUseCase: SaveMovieToCacheUseCase,
) : ViewModel() {
    private val _uiState: MutableStateFlow<DetailsScreenUIState> =
        MutableStateFlow(DetailsScreenUIState.Loading)
    val uiState: StateFlow<DetailsScreenUIState> = _uiState.asStateFlow()
    private val handle = CoroutineExceptionHandler { _, throwable -> }

    fun saveMovie(model: MovieInfoDomainModel) {
        viewModelScope.launch(handle + Dispatchers.IO) {
            Log.d("AAA","save movie")
            Log.d("AAA","save movie $model")
            saveMovieToCacheUseCase.invoke(model)
        }
    }

    fun getMovieInfo(
        movieId: Int,
    ) {
        viewModelScope.launch(handle + Dispatchers.IO) {
            _uiState.update { DetailsScreenUIState.Loading }
            val getMovieInfoUseCaseDeferred = async {
                getMovieInfoUseCase(movieId = movieId)
            }
            val getMovieInfoUseCase = getMovieInfoUseCaseDeferred.await()
            if (getMovieInfoUseCase.status == ResponseStatus.SUCCESS) {
                getMovieInfoUseCase.data.let { movieDetails ->
                    if (movieDetails != null) {
                        _uiState.update {
                            DetailsScreenUIState.Loaded(
                                movie = movieDetails.toUI()
                            )
                        }
                        Log.d("AAA","saveMovie in getmovie")
                        saveMovie(model=movieDetails)
                    }
                }
            } else {
                _uiState.update {
                    DetailsScreenUIState.Error(
                        message = "Something went wrong,please check internet connection or try again"
                    )
                }
            }
        }
    }
}