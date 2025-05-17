package org.sopt.sopkathon.data.detail.dto.response

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class DetailCommentResponse(
    @SerialName("name")
    val name: String,
    @SerialName("content")
    val content: String,
    @SerialName("score")
    val score: Int
)