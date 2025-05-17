package org.sopt.sopkathon.presentation.detail

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.compose.viewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import org.sopt.sopkathon.data.detail.dto.response.DetailCommentResponse
import org.sopt.sopkathon.data.detail.dto.response.DetailPurchaseApplyResponse
import org.sopt.sopkathon.data.detail.dto.response.DetailResponse
import org.sopt.sopkathon.data.detail.respository.DetailRepository
import javax.inject.Inject

@HiltViewModel
class DetailViewModel @Inject constructor(
    private val detailRepository: DetailRepository
) : ViewModel() {
    private val _detail = MutableStateFlow<DetailResponse?>(null)
    val detail: StateFlow<DetailResponse?> = _detail

    private val _comments = MutableStateFlow<List<DetailCommentResponse>>(emptyList())
    val comments: StateFlow<List<DetailCommentResponse>> = _comments

    private val _purchaseApplies = MutableStateFlow<List<DetailPurchaseApplyResponse>>(emptyList())
    val purchaseApplies: StateFlow<List<DetailPurchaseApplyResponse>> = _purchaseApplies

    private val _error = MutableStateFlow<Throwable?>(null)
    val error: StateFlow<Throwable?> = _error

    fun loadAll(detailId: Long = 1) {
        getDetail(detailId)
        getDetailComments(detailId)
        getPurchaseApplies(detailId)
    }

    private fun getDetail(detailId: Long) {
        viewModelScope.launch {
            detailRepository.getDetail(detailId)
                .onSuccess { _detail.value = it }
                .onFailure { _error.value = it }
        }
    }

    private fun getDetailComments(productId: Long) {
        viewModelScope.launch {
            detailRepository.getDetailCommentInformation(productId)
                .onSuccess { _comments.value = it }
                .onFailure { _error.value = it }
        }
    }

    private fun getPurchaseApplies(productId: Long) {
        viewModelScope.launch {
            detailRepository.getDetailPurchaseApply(productId)
                .onSuccess { _purchaseApplies.value = it }
                .onFailure { _error.value = it }
        }
    }
}