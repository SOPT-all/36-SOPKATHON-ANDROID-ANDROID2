package org.sopt.sopkathon.data.detail.dto.response

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class DetailResponse(
    @SerialName("productImage")
    val productImage: Int,
    @SerialName("productName")
    val productName: String,
    @SerialName("productDescription")
    val productDescription: String,
    @SerialName("maxParticipantCount")
    val maxParticipantCount: Int,
    @SerialName("participantCount")
    val participantCount: Int,
    @SerialName("sellerName")
    val sellerName: String
)
