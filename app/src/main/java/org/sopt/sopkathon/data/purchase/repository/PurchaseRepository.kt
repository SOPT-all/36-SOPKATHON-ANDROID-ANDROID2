package org.sopt.sopkathon.data.purchase.repository

import org.sopt.sopkathon.data.purchase.dto.response.PurchaseInformationResponse
import org.sopt.sopkathon.data.purchase.service.PurchaseInformationService
import javax.inject.Inject

class PurchaseRepository @Inject constructor(
    private val purchaseService: PurchaseInformationService
) {
    suspend fun getPurchaseInformation(
        regionId: Long
    ): Result<List<PurchaseInformationResponse>> = runCatching {
        purchaseService.getPurchaseInformation(regionId).result
    }
}