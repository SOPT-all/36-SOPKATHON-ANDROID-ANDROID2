package org.sopt.sopkathon.data.detail.dto.response

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class DetailPurchaseApplyResponse (
    @SerialName("participantCount")
    val participantCount: Int
)