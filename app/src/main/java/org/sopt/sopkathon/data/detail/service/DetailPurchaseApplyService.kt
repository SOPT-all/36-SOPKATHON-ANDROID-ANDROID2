package org.sopt.sopkathon.data.detail.service

import org.sopt.sopkathon.data.detail.dto.response.DetailPurchaseApplyResponse
import org.sopt.sopkathon.data.remote.BaseResponse
import retrofit2.http.POST
import retrofit2.http.Path
import retrofit2.http.Query

interface DetailPurchaseApplyService {
    @POST("/register/{productId}")
    suspend fun getDetailPurchaseApply(
       @Path("productId") productId: Long,
       @Query("memberId") memberId: Long
    ): BaseResponse<List<DetailPurchaseApplyResponse>>
}