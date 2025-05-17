package org.sopt.sopkathon.data.guide.dto.response

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class GuideResponse(
    @SerialName("regionName")
    val regionName: String,
    @SerialName("regionSubName")
    val regionSubName: String,
    @SerialName("regionDescription")
    val regionDescription: String,
    @SerialName("regionImage")
    val regionImage: String
)