package org.sopt.sopkathon.data.detail.service

import org.sopt.sopkathon.data.detail.dto.response.DetailResponse
import org.sopt.sopkathon.data.remote.BaseResponse
import retrofit2.http.GET
import retrofit2.http.Path

interface DetailService {
    @GET("/product/{productId}")
    suspend fun getDetailInformation(
        @Path("productId") productId: Long
    ): BaseResponse<DetailResponse>
}