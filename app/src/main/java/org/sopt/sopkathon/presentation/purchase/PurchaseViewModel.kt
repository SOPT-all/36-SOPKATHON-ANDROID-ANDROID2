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
import org.sopt.sopkathon.data.purchase.dto.response.ProductInformationResponse
import org.sopt.sopkathon.data.purchase.dto.response.PurchaseInformationResponse
import org.sopt.sopkathon.data.purchase.repository.PurchaseRepository
import org.sopt.sopkathon.presentation.purchase.state.PurchaseContract.PurchaseState
import javax.inject.Inject

@HiltViewModel
class PurchaseViewModel @Inject constructor(
    savedStateHandle: SavedStateHandle,
    private val purchaseRepository: PurchaseRepository,
) : ViewModel() {
    private var regionId: Long = 1

    private val _uiState = MutableStateFlow(PurchaseState())
    val uiState = _uiState.asStateFlow()

    val list = PurchaseInformationResponse(
        listOf(
            ProductInformationResponse(
                1,
                "경주 명물 쫀득한 찰보리빵 10개입 세트",
                12000,
                "https://img.publichs.com/ECMCFO/share/product/61/60/88/17715157.jpeg/dims/resize/Q_80,700"
            ),
            ProductInformationResponse(
                2,
                "경주 들판에서 자란 당도 높은 완숙 토마토 3kg",
                13500,
                "https://shop-phinf.pstatic.net/20250119_300/17372962030286EePD_JPEG/7560872144344925_16330788.jpg?type=m510"
            ),
            ProductInformationResponse(
                3,
                "경주 햇살받은 고당도 국산 체리 1kg",
                18000,
                "https://imgur.com/a/cVTz4Sr"
            ),
            ProductInformationResponse(
                4,
                "경주에서 청정한 환경에서 자란 1++ 한우. 풍부한 육즙과 부드러운 결이 살아있는 프리미엄 불고기용/구이용 세트입니다. 선물용으로도 인기 많습니다.",
                39000,
                "https://soptkathon-s3.s3.ap-northeast-2.amazonaws.com/test/%E1%84%80%E1%85%A7%E1%86%BC%E1%84%8C%E1%86%BC%E1%84%8C%E1%85%AE_%E1%84%92%E1%85%A1%E1%86%AB%E1%84%8B%E1%85%AE_%E1%84%89%E1%85%A5%E1%86%B7%E1%84%82%E1%85%A6%E1%84%8B%E1%85%B5%E1%86%AF.png"
            )
        )
    )

    fun get() = viewModelScope.launch {
        purchaseRepository.getPurchaseInformation(regionId).onSuccess {
            updateState(it)
        }
    }

    fun updateState(newList: PurchaseInformationResponse) {
        _uiState.update {
            it.copy(
                purchaseList = list
            )
        }
    }
}
