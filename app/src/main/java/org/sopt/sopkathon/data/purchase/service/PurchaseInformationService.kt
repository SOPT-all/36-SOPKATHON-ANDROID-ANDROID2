package org.sopt.sopkathon.data.purchase.service

import org.sopt.sopkathon.data.remote.BaseResponse
import org.sopt.sopkathon.data.purchase.dto.response.PurchaseInformationResponse
import retrofit2.http.GET
import retrofit2.http.Path

interface PurchaseInformationService {
    @GET("/products/{regionId}")
    suspend fun getPurchaseInformation(
        @Path("regionId") regionId: Long
    ): BaseResponse<PurchaseInformationResponse>
}
