package org.sopt.sopkathon.presentation.purchase.state

import androidx.compose.runtime.Immutable
import org.sopt.sopkathon.data.purchase.dto.response.ProductInformationResponse
import org.sopt.sopkathon.data.purchase.dto.response.PurchaseInformationResponse

class PurchaseContract {
    @Immutable
    data class PurchaseState(
        val purchaseList: PurchaseInformationResponse = PurchaseInformationResponse(emptyList< ProductInformationResponse>()),
    )
}
