package org.sopt.sopkathon.data.guide.respository

import org.sopt.sopkathon.data.guide.dto.response.GuideResponse
import org.sopt.sopkathon.data.guide.service.GuideService
import javax.inject.Inject

class GuideRepository @Inject constructor(
    private val guideService: GuideService
) {
    suspend fun getGuideIntroduction(
        regionId: Long
    ): Result<GuideResponse> = runCatching {
        guideService.getGuideIntroduction(regionId).result
    }
}