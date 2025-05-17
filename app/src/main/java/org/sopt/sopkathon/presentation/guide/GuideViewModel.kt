package org.sopt.sopkathon.presentation.guide

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import org.sopt.sopkathon.data.guide.dto.response.GuideResponse
import org.sopt.sopkathon.data.guide.respository.GuideRepository
import javax.inject.Inject

@HiltViewModel
class GuideViewModel @Inject constructor(
    val guideRepository: GuideRepository
) : ViewModel() {
    private val _guideData = MutableStateFlow<GuideResponse?>(null)
    val guideData: StateFlow<GuideResponse?> = _guideData

    fun getGuideData(regionId: Long) {
        viewModelScope.launch {
            guideRepository.getGuideIntroduction(regionId)
                .onSuccess {
                    _guideData.value = it
                }
                .onFailure {}
        }
    }
}