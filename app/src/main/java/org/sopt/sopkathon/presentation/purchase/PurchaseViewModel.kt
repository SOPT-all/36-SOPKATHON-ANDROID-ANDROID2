package org.sopt.sopkathon.presentation.purchase

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.filterNotNull
import kotlinx.coroutines.flow.take
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import org.sopt.sopkathon.data.purchase.dto.response.PurchaseInformationResponse
import org.sopt.sopkathon.data.purchase.repository.PurchaseRepository
import org.sopt.sopkathon.presentation.purchase.state.PurchaseContract.PurchaseState
import javax.inject.Inject

@HiltViewModel
class PurchaseViewModel @Inject constructor(
    savedStateHandle: SavedStateHandle,
    private val purchaseRepository: PurchaseRepository,
) : ViewModel() {
    private var regionId: Long? = null

    private val _uiState = MutableStateFlow(PurchaseState())
    val uiState = _uiState.asStateFlow()
    
    init {
        viewModelScope.launch {
            savedStateHandle.getStateFlow<Long?>("regionId", null)
                .filterNotNull()
                .take(1)
                .collect { id ->
                    regionId = id
                    purchaseRepository.getPurchaseInformation(id).onSuccess {
                        updateState(it)
                    }
                }
        }
    }

    private fun updateState(newList: List<PurchaseInformationResponse>) {
        _uiState.update {
            it.copy(
                purchaseList = newList
            )
        }
    }
}
