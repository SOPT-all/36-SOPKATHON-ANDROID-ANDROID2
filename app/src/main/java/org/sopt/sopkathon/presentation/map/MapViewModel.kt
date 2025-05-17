package org.sopt.sopkathon.presentation.map

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import org.sopt.sopkathon.data.guide.dto.response.GuideResponse
import org.sopt.sopkathon.data.guide.respository.GuideRepository
import javax.inject.Inject

@HiltViewModel
class MapViewModel @Inject constructor(
    private val guideRepository: GuideRepository
) : ViewModel() {

    private val _guideList = MutableStateFlow<GuideResponse?>(null)
    val guideList: StateFlow<GuideResponse?> = _guideList.asStateFlow()

    private val _regionId = MutableStateFlow<Long?>(null)
    val regionId: StateFlow<Long?> = _regionId

    private val _regionName = MutableStateFlow<String?>(null)
    val regionName: StateFlow<String?> = _regionName

    fun fetchRegionName(regionName: String) {
        _regionName.value = regionName
    }

    fun fetchRegionId(regionId: Long) {
        _regionId.value = regionId
    }

    private val _error = MutableStateFlow<Throwable?>(null)
    val error: StateFlow<Throwable?> = _error

    fun fetchGuideIntroduction(regionId: Long) {
        viewModelScope.launch {
            guideRepository.getGuideIntroduction(regionId)
                .onSuccess {
                    _guideList.value = it
                }
                .onFailure {
                    _error.value = it
                }
        }
    }
}
