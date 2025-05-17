package org.sopt.sopkathon.data.detail.service

import org.sopt.sopkathon.data.detail.dto.response.DetailCommentResponse
import org.sopt.sopkathon.data.remote.BaseResponse
import retrofit2.http.GET
import retrofit2.http.Path

interface DetailCommentService {
    @GET("/comments/{productId}")
    suspend fun getDetailCommentInformation(
        @Path("productId") productId: Long
    ): BaseResponse<List<DetailCommentResponse>>
}