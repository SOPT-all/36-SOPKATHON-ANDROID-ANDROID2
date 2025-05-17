package org.sopt.sopkathon.data.guide.service

import org.sopt.sopkathon.data.guide.dto.response.GuideResponse
import org.sopt.sopkathon.data.remote.BaseResponse
import retrofit2.http.GET
import retrofit2.http.Path

interface GuideService {
    @GET("/region/{regionId}")
    suspend fun getGuideIntroduction(
        @Path("regionId") regionId: Long
    ): BaseResponse<List<GuideResponse>>
}