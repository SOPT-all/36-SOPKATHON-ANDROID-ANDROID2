package org.sopt.sopkathon.data.detail.dto.response

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class DetailResponse(
    @SerialName("imageLinks")
    val imageLinks: List<String>,
    @SerialName("productName")
    val productName: String,
    @SerialName("description")
    val description: String,
    @SerialName("price")
    val price: Int,
    @SerialName("maxParticipantCount")
    val maxParticipantCount: Int,
    @SerialName("participantCount")
    val participantCount: Int,
    @SerialName("sellerName")
    val sellerName: String
)
