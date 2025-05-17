package org.sopt.sopkathon.data.detail.respository

import org.sopt.sopkathon.data.detail.dto.response.DetailCommentResponse
import org.sopt.sopkathon.data.detail.dto.response.DetailPurchaseApplyResponse
import org.sopt.sopkathon.data.detail.dto.response.DetailResponse
import org.sopt.sopkathon.data.detail.service.DetailCommentService
import org.sopt.sopkathon.data.detail.service.DetailPurchaseApplyService
import org.sopt.sopkathon.data.detail.service.DetailService
import javax.inject.Inject

class DetailRepository @Inject constructor(
    private val detailService: DetailService,
    private val detailCommentService: DetailCommentService,
    private val detailPurchaseApplyService: DetailPurchaseApplyService
){
    suspend fun getDetail(
        productId: Long
    ): Result<DetailResponse> = runCatching {
        detailService.getDetailInformation(productId).result
    }

    suspend fun getDetailCommentInformation(
        productId: Long
    ): Result<List<DetailCommentResponse>> = runCatching {
        detailCommentService.getDetailCommentInformation(productId).result
    }

    suspend fun getDetailPurchaseApply(
        productId: Long
    ): Result<List<DetailPurchaseApplyResponse>> = runCatching {
        detailPurchaseApplyService.getDetailPurchaseApply(productId).result
    }
}