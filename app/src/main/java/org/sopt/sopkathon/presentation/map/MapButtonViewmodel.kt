package org.sopt.sopkathon.presentation.map

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.filterNotNull
import kotlinx.coroutines.flow.take
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MapButtonViewmodel @Inject constructor(
    private val savedStateHandle: SavedStateHandle
) : ViewModel() {
    private var regionId: Long? = null

    init {
        viewModelScope.launch {
            savedStateHandle.getStateFlow("regionId", null)
                .filterNotNull()
                .take(1)
                .collect { id ->
                    regionId = id
                }
        }
    }
}